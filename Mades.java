/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mades;

import java.io.*;
import java.nio.file.*;
import java.security.*;
import javax.crypto.*;

/**
 *
 * @author install
 */
public class Mades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
           FileInputStream in = null;
            FileOutputStream out = null; 
            FileOutputStream decypher = null;
            Path ipath=Paths.get("input.txt");
        try {
            
         in = new FileInputStream("input.txt");
         out = new FileOutputStream("output.txt");
         decypher = new FileOutputStream("decypher.txt");
          KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
             Cipher desCipher;
         desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
          desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
           byte[] text = Files.readAllBytes(ipath);
           byte[] textEncrypted = desCipher.doFinal(text);
           out.write(textEncrypted);
           System.out.println("done Encryption");
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
             byte[] textDecrypted = desCipher.doFinal(textEncrypted);
   decypher.write(textDecrypted);
           System.out.println("done decryption");
       
      }
        catch(Exception e){System.out.println("error!!! in mades");}
        finally {
         if (in != null) {
            in.close();
         }
         if (out != null) {
            out.close();
         }
      }
        
        
        // TODO code application logic here
    }
    
}
