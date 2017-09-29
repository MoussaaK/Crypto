package org.dador;

import java.nio.charset.StandardCharsets;

/**
 * Collection of tools to manipulate String represented as Hex characters
 * Created by Damien Salvador on 18/10/2016.
 */
public class HexConverters {

    /**
     * Private constructor
     */
    private HexConverters() {
    }

    /**
     * Turns Hex encoded string representation into an array of bytes
     *
     * @param hex String Hex representation to convert to Array of bytes
     * @return Generated byte array
     */
    public static byte[] toByteArrayFromHex(String hex) {
        byte[] buf;

        Integer hexlen = hex.length() / 2;
        buf = new byte[hexlen];
        int i;
        for (i = 0; i < hexlen; i++) {
            String str = hex.substring(i * 2, i * 2 + 2);

            buf[i] = (byte) ((Character.digit(str.charAt(0), 16) << 4) + Character.digit(str.charAt(1), 16));
        }
        return buf;
    }

    /**
     * Turns array of bytes into string hex representation
     *
     * @param buf Array of bytes to convert to hex string
     * @return Generated hex string
     */
    public static String toHexFromByteArray(byte buf[]) {
        StringBuilder strbuf = new StringBuilder(buf.length * 2);
        int i;
        for (i = 0; i < buf.length; i++) {
            if (((int) buf[i] & 0xff) < 0x10) {
                strbuf.append("0");
            }
            strbuf.append(Long.toString((int) buf[i] & 0xff, 16));
        }
        return strbuf.toString();
    }

    /**
     * Applies xor element by element. buf1 and buf2 must be same length !
     *
     * @param buf1 : first element for xor
     * @param buf2 : second element for xor
     * @return byte array containing xored values of buf1 and buf2
     */
    public static byte[] xorArray(byte[] buf1, byte[] buf2) throws IllegalArgumentException {
        if (buf1.length != buf2.length) throw new IllegalArgumentException("Arrays should be of the same size");
        byte[] result = new byte[buf1.length];
        for (int i = 0; i < buf1.length; i++) {
            result[i] = (byte) (buf1[i] ^ buf2[i]);
        }
        return result;


    }


    /**
     * Convert a byte[] to a String, removing unprintable chars
     *
     * @param buf
     * @return
     */
    public static String toPrintableString(byte[] buf) {
        byte[] copyBuf = removeUnprintableChars(buf);
        String result = new String(copyBuf, StandardCharsets.UTF_8);
        return result;
    }

    private static byte[] removeUnprintableChars(byte[] buf) {
        byte[] copyBuf = buf.clone();
        for (int i = 0; i < copyBuf.length; i++) {
            if (copyBuf[i] >= 0 && copyBuf[i] < 32) {
                copyBuf[i] = 46; // "." character
            }
        }
        return copyBuf;
    }

}