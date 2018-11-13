
package org.dador;

/**
 *
 */
public class MultiTimePad {


    /**
     * Main function. Loads cryptogram and displays decryption
     * @param args
     */
    public static void main(final String[] args) {
        String msg0 = "BB3A65F6F0034FA957F6A767699CE7FABA855AFB4F2B520AEAD612944A801E";
        String msg1 = "BA7F24F2A35357A05CB8A16762C5A6AAAC924AE6447F0608A3D11388569A1E";
        String msg2 = "A67261BBB30651BA5CF6BA297ED0E7B4E9894AA95E300247F0C0028F409A1E";
        String msg3 = "A57261F5F0004BA74CF4AA2979D9A6B7AC854DA95E305203EC8515954C9D0F";
        String msg4 = "BB3A70F3B91D48E84DF0AB702ECFEEB5BC8C5DA94C301E0BECD241954C831E";
        String msg5 = "A6726DE8F01A50E849EDBC6C7C9CF2B2A88E19FD423E0647ECCB04DD4C9D1E";
        String msg6 = "BC7570BBBF1D46E85AF9AA6C7A9CEFA9E9825CFD5E3A0047F7CD009305A71E";
        String[] messages = new String[]{msg0, msg1, msg2, msg3, msg4, msg5, msg6};
        byte[] key;
        byte[][] byteArrayMsg;
        int nbMsg = messages.length;
        byte[] tmpByteMsg;
        int i;
        byteArrayMsg = new byte[nbMsg][];

        System.out.println("Original Cryptograms :");
        for (i = 0; i < nbMsg; i++) {
            System.out.println(messages[i]);
            tmpByteMsg = HexConverters.toByteArrayFromHex(messages[i]);
            byteArrayMsg[i] = tmpByteMsg ;
        }

        System.out.println();

        key = new byte[msg1.length() / 2];
        // Fill in the key ...
        key[0] = (byte) 0xF2;
        key[1] = (byte) 0x1A;
        key[2] = (byte) 0x04;
        key[3] = (byte) 0x9B;
        key[4] = (byte) 0xD0;
        key[5] = (byte) 0x73;
        key[6] = (byte) 0x23;
        key[7] = (byte) 0xC8;
        key[8] = (byte) 0x39;
        key[9] = (byte) 0x98;
        
        key[10] = (byte) 0xCE;
        key[11] = (byte) 0x09;
        key[12] = (byte) 0x0E;
        key[13] = (byte) 0xBC;
        key[14] = (byte) 0x86;
        key[15] = (byte) 0xDA;
        key[16] = (byte) 0xC9;
        key[17] = (byte) 0xE0;
        key[18] = (byte) 0x39;
        key[19] = (byte) 0x89;
        key[20] = (byte) 0x2A;
        key[21] = (byte) 0x5F;
        key[22] = (byte) 0x72;
        key[23] = (byte) 0x67;
        
        key[24] = (byte) (0x6F^0xEC) ;
        key[25] = (byte) (0x77^0xD2) ;
        key[26] = (byte) (0x20^0x41) ;
        key[27] = (byte) (0x69^0x94) ;
        key[28] = (byte) (0x6F^0x4A) ;
        key[29] = (byte) (0x6E^0x80) ;

        System.out.println("Key :");
        System.out.println(HexConverters.toHexFromByteArray(key));

        System.out.println();
        System.out.println("Decoded messages :");
        for (i = 0; i < nbMsg; i++) {
            tmpByteMsg = HexConverters.xorArray(key, byteArrayMsg[i]);
            System.out.println(HexConverters.toPrintableString(tmpByteMsg));
        }
        
        
        /*XoR between Crypto*/
        for (int i1 = 0; i1 < byteArrayMsg.length; i1++) {
        	byte[] bytesMsg0XorMsg1 = HexConverters.xorArray(byteArrayMsg[0], byteArrayMsg[i1]);
        	String msg0XorMsg1 = HexConverters.toHexFromByteArray(bytesMsg0XorMsg1);
        	System.out.println(msg0XorMsg1);
        	//msg0XorMsg1.replace(target, replacement)
        }
        
        
		/*for (int j = 0; j < byteArrayMsg.length; j++) {
			for (int i1 = 0; i1 < byteArrayMsg.length; i1++) {
				if(i1 != j) {
					byte[] byteMsg0XorMsg1 = HexConverters.xorArray(byteArrayMsg[j], byteArrayMsg[i1]);
					String msg0XorMsg1 = HexConverters.toHexFromByteArray(byteMsg0XorMsg1);
					System.out.println(msg0XorMsg1);
				}
			}
			System.out.println("-------------------------------------------------------");
		}*/
    }
}
