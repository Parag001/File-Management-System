package javaprogram.java.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;




public class EncryptDecrypt
{
  private static String key = "";
  private static final String ALGORITHM = "AES";
  private static final String TRANSFORMATION = "AES";
  
  
  
  public static void encryptFile(File paramFile1, File paramFile2) {
    System.out.println("Enter the Key");
    Scanner localScanner = new Scanner(System.in);
    key = localScanner.next();
    int i = key.length();
    if ((key.isEmpty()) || (i != 16))
    {
      System.out.println("\nInvalid Key..!\n");
    }
    else
    {
      try
      {

        SecretKeySpec localSecretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        
        Cipher localCipher = Cipher.getInstance("AES");
        
        localCipher.init(1, localSecretKeySpec);
        

        FileInputStream localFileInputStream = new FileInputStream(paramFile1);
        


        byte[] arrayOfByte1 = new byte[(int)paramFile1.length()];
        localFileInputStream.read(arrayOfByte1);
        


        byte[] arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
        localFileOutputStream.write(arrayOfByte2);
        


        localFileInputStream.close();
        localFileOutputStream.close();
        

        System.out.print("\nFile has been encrypted successfully..!\n");

      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void decryptFile(File paramFile1, File paramFile2)
  {
    System.out.println("Enter the Key");
    Scanner localScanner = new Scanner(System.in);
    key = localScanner.next();
    int i = key.length();
    if ((key.isEmpty()) || (i != 16))
    {
      System.out.println("\nInvalid Key..!\n");

    }
    else
    {
      try
      {

        SecretKeySpec localSecretKeySpec = new SecretKeySpec(key.getBytes(), "AES");
        
        Cipher localCipher = Cipher.getInstance("AES");
        
        localCipher.init(2, localSecretKeySpec);
        

        FileInputStream localFileInputStream = new FileInputStream(paramFile1);
        


        byte[] arrayOfByte1 = new byte[(int)paramFile1.length()];
        localFileInputStream.read(arrayOfByte1);
        


        byte[] arrayOfByte2 = localCipher.doFinal(arrayOfByte1);
        FileOutputStream localFileOutputStream = new FileOutputStream(paramFile2);
        localFileOutputStream.write(arrayOfByte2);
        


        localFileInputStream.close();
        localFileOutputStream.close();
        

        System.out.print("\nFile has been decrypted successfully..!\n");

      }
      catch (Exception localException)
      {
        System.out.print("\nIncorrect key\n");
      }
    }
  }
}
