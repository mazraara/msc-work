//CS Assignment CSC 607

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class Main {
 private static Cipher ecipher;
 private static Cipher dcipher;
 
 private static void encrypt(InputStream is, OutputStream os) {
  try {
   byte[] buf = new byte[1024];
   // bytes at this stream are first encoded
   os = new CipherOutputStream(os, ecipher);
   // read in the clear text and write to out to encrypt int numRead = 0;
   while ((numRead = is.read(buf)) >= 0) {
    os.write(buf, 0, numRead);
   }
   // close all streams os.close();
  } catch (IOException e) {
   System.out.println("I/O Error:" + e.getMessage());
  }
 }
 
 private static void decrypt(InputStream is, OutputStream os) {
  try {
   byte[] buf = new byte[1024];
   // bytes read from stream will be decrypted CipherInputStream cis = new CipherInputStream(is, dcipher);
   // read in the decrypted bytes and write the clear text to out int numRead = 0;
   while ((numRead = cis.read(buf)) >= 0) {
    os.write(buf, 0, numRead);
   }
   // close all streams cis.close();
   is.close();
   os.close();
  } catch (IOException e) {
   System.out.println("I/O Error:" + e.getMessage());

  }
 }
 
 public static void main(String[] args) {
  new Main().DESencrypt();
  System.out.println("end of DES");
  new Main().AESEncrypt();
 }
 
 final String PATH = "F://query.log";
 
 public void DESencrypt() {
  String strCipherText = new String();
  try {
   KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
   SecretKey myDesKey = keygenerator.generateKey();
   long start = System.currentTimeMillis();
   ecipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
   // Initialize the cipher for encryption ecipher.init(Cipher.ENCRYPT_MODE, myDesKey);
   encrypt(new FileInputStream(PATH),
    new FileOutputStream("DES-encrypted.dat"));
   // byte[] textEncrypted = desCipher.doFinal(text);
   long end = System.currentTimeMillis();
   // strCipherText = new String(textEncrypted);// new
   // BASE64Encoder().encode(textEncrypted); System.out.println("DES: Time to encrypt: " + (end - start) + " ms");
   // System.out.println("Text Encryted : " + strCipherText);
   // Initialize the same cipher for decryption
   dcipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
   dcipher.init(Cipher.DECRYPT_MODE, myDesKey);
   decrypt(new FileInputStream("DES-encrypted.dat"), new FileOutputStream("des-cleartext-reversed.txt"));
  } catch (NoSuchAlgorithmException x) {
   x.printStackTrace();
  } catch (NoSuchPaddingException e) {

   e.printStackTrace();
  } catch (InvalidKeyException e) {
   e.printStackTrace();
  } catch (FileNotFoundException e) {
   System.out.println("File Not Found:" + e.getMessage());
   return;
  }
 }
 
 public void AESEncrypt() {
  String strCipherText = new String();
  try {
   KeyGenerator keyGen = KeyGenerator.getInstance("AES");
   keyGen.init(128);
   SecretKey secretKey = keyGen.generateKey();
   final int AES_KEYLENGTH = 128; // change this as desired for the // security level you want
   byte[] iv = new byte[AES_KEYLENGTH / 8]; // Save the IV bytes or
   SecureRandom prng = new SecureRandom();
   prng.nextBytes(iv);
   ecipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
   // Initialize the cipher for encryption
   long start = System.currentTimeMillis();
   ecipher.init(Cipher.ENCRYPT_MODE, secretKey,
    new IvParameterSpec(iv));
   encrypt(new FileInputStream(
     PATH),
    new FileOutputStream("AES-encrypted.dat"));
   long end = System.currentTimeMillis();
   dcipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
   dcipher.init(Cipher.DECRYPT_MODE, secretKey,
    new IvParameterSpec(iv));
   // System.out.println("Text Encryted : " + strCipherText); System.out.println("AES: Time to encrypt: " + (end - start) + " ms"); decrypt(new FileInputStream("AES-encrypted.dat"), new FileOutputStream(
   "aes-cleartext-reversed.txt"));

 ;
} catch (NoSuchAlgorithmException x) {
 x.printStackTrace();
} catch (NoSuchPaddingException e) {
 e.printStackTrace();
} catch (InvalidKeyException e) {
 e.printStackTrace();
} catch (FileNotFoundException e) {
 System.out.println("File Not Found:" + e.getMessage());
 return;
} catch (InvalidAlgorithmParameterException e) { // TODO Auto-generated catch block e.printStackTrace();
}
}
}