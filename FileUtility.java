package javaprogram.java.filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtility
{
  private static final String zipFolder = "E:\\zipFolder\\";
  private static final String extractFolder = "E:\\ExtractedFiles";
  private static final String encryptedFileLocation = "E:\\EncryptedFiles\\";
  private static final String decryptedFileLocation = "E:\\DecryptedFiles\\";
  
  
  
  public static void createFile(String paramString1, String paramString2)
    throws IOException
  {
    try
    {
      File localFile = new File(paramString1);
      
      if (!localFile.exists())
      {
        localFile.createNewFile();
      }
      
      FileWriter localFileWriter = new FileWriter(paramString1);
      BufferedWriter localBufferedWriter = new BufferedWriter(localFileWriter);
      localBufferedWriter.write(paramString2);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      
      System.out.println("\nFile " + paramString1 + " has been created successfully..!\n");

    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static void reNameFile(String paramString1, String paramString2)
  {
    File localFile1 = new File(paramString1);
    
    if (localFile1.isFile())
    {
      String str = localFile1.getParent();
      File localFile2 = new File(str + "\\" + paramString2);
      if (localFile1.renameTo(localFile2))
      {
        System.out.println("\n File successfully renamed..!\n");
      }
      else
      {
        System.out.println("\nThere is some issue renaming your file\n");
      }
    }
    else
    {
      System.out.println("\nFile not found\n");
    }
  }
  
  public static void deleteFile(String paramString)
  {
    File localFile = new File(paramString);
    
    if (localFile.isFile())
    {
      if (localFile.delete())
      {
        System.out.println("\nFile successfully deleted..!\n");
      }
      else
      {
        System.out.println("\nThere is some issue deleting the file\n");
      }
      
    }
    else {
      System.out.println("\nFile not found\n");
    }
  }
  
  public static void createDirectory(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      System.out.println("\nDirectory already exists\n");
    }
    else
    {
      localFile.mkdirs();
      System.out.println("\nDirectory created successfully..!\n");
    }
  }
  
  public static void reNameDirectory(String paramString1, String paramString2)
  {
    File localFile1 = new File(paramString1);
    if (localFile1.isDirectory())
    {
      if (localFile1.exists())
      {
        String str = localFile1.getParent();
        File localFile2 = new File(str + "\\" + paramString2);
        if (!localFile2.exists())
        {
          localFile1.renameTo(localFile2);
          System.out.println("\nDirectory renamed successfully..!\n");

        }
        else
        {
          System.out.println("\nDirectory already exists..!\n");
        }
        
      }
      else
      {
        System.out.println("\nDirectory does not exists..!\n");
      }
      
    }
    else {
      System.out.println("\nInvalid Directory..!\n");
    }
  }
  
  public static int deleteDirectory(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile1 = paramFile.listFiles();
      if (arrayOfFile1 != null)
      {
        for (File localFile : arrayOfFile1)
        {
          int k = deleteDirectory(localFile);
        }
      }
      paramFile.delete();
      System.out.println("\n\n");
    }
    else
    {
      System.out.println("\nInvalid Directory..!\n");
    }
    return 1;
  }
  
  public static void viewDirectory(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile1 = paramFile.listFiles();
      System.out.println("\n" + paramFile.getName());
      if (arrayOfFile1 != null)
      {
        for (File localFile : arrayOfFile1)
        {
          System.out.println("\t->" + localFile.getName());
        }
        System.out.println("\n");
      }
      else
      {
        System.out.println("\nNo Sub-Folders..!\n");
      }
    }
    else
    {
      System.out.println("\nInvalid Directory..!\n");
    }
  }
  
  public static void copyFile(String paramString)
    throws IOException
  {
    File localFile1 = new File(paramString + ".txt");
    if ((localFile1.isFile()) && (localFile1.exists()))
    {
      File localFile2 = new File(paramString + " - Copy.txt");
      localFile2.createNewFile();
      
      FileWriter localFileWriter = new FileWriter(localFile2);
      FileReader localFileReader = new FileReader(localFile1);
      try
      {
        int i;
        while ((i = localFileReader.read()) != -1)
        {
          localFileWriter.write(i);
        }
        localFileReader.close();
        localFileWriter.close();
      }
      catch (Exception localException)
      {
        System.out.println(localException);
      }
      System.out.println("\nFile copied successfully..!\n");
    }
    else
    {
      System.out.println("\nInvalid File..!\n");
    }
  }
  
  public static void copyDirectory(String paramString1, String paramString2) throws IOException
  {
    File localFile1 = new File(paramString1);
    File localFile2 = new File(paramString2 + "(COPY)");
    localFile2.mkdir();
    File[] arrayOfFile = localFile1.listFiles();
    
    for (int i = 0; i < arrayOfFile.length; i++)
    {
      File localFile3 = new File(paramString2 + "(COPY)\\" + arrayOfFile[i].getName());
      localFile3.createNewFile();
      
      FileWriter localFileWriter = new FileWriter(localFile3);
      FileReader localFileReader = new FileReader(arrayOfFile[i]);
      
      try
      {
        while ((i = localFileReader.read()) != -1)
        {
          localFileWriter.write(i);
        }
        localFileReader.close();
        localFileWriter.close();
      }
      catch (Exception localException)
      {
        System.out.println(localException);
      }
    }
    

    System.out.println("\nFolder copied successfully..!\n");
  }
  




  public static void compressFile(File paramFile)
    throws IOException
  {
    try
    {
      FileOutputStream localFileOutputStream = new FileOutputStream("E:\\zipFolder\\" + paramFile.getName() + ".zip");
      ZipOutputStream localZipOutputStream = new ZipOutputStream(localFileOutputStream);
      File[] arrayOfFile1 = paramFile.listFiles();
      if (arrayOfFile1 != null)
      {
        for (File localFile : arrayOfFile1)
        {
			 
          ZipEntry localZipEntry = new ZipEntry(localFile.getName());
          localZipOutputStream.putNextEntry(localZipEntry);
          FileInputStream localFileInputStream = new FileInputStream(localFile);
          byte[] arrayOfByte = new byte[1024];
          int k;
          while ((k = localFileInputStream.read(arrayOfByte)) >= 0)
          {
            localZipOutputStream.write(arrayOfByte, 0, k);
          }
        }
      }
      

      System.out.println("\nFile successfully compressed..!\n");
      localZipOutputStream.closeEntry();
      
      localZipOutputStream.close();
      localFileOutputStream.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  

  public static void decompressFile(String paramString)
  {
    Scanner localScanner = new Scanner(System.in);
    try
    {
      System.out.println("Enter the file path where you want to save decompress file");
      
      String str1 = localScanner.nextLine();
      File localFile1 = new File(paramString);
      

      ZipInputStream localZipInputStream = new ZipInputStream(new FileInputStream(localFile1));
      
      ZipEntry localZipEntry = localZipInputStream.getNextEntry();
      
      while (localZipEntry != null)
      {

        String str2 = localZipEntry.getName();
        File localFile2 = new File(str1 + File.separator + str2);
        
        System.out.println("\nfile unzip : " + localFile2.getAbsoluteFile() + "\n");
        

		

        FileOutputStream localFileOutputStream = new FileOutputStream(localFile2);
        

        byte[] arrayOfByte = new byte[1024];
		
        int i; 
		while ((i = localZipInputStream.read(arrayOfByte)) > 0)
        {
          localFileOutputStream.write(arrayOfByte, 0, i);
        }
        
        localFileOutputStream.close();
        localZipEntry = localZipInputStream.getNextEntry();
      }
      
      localZipInputStream.closeEntry();
      localZipInputStream.close();
      
      System.out.println("\nDone\n");

    }
    catch (Exception localException)
    {
      System.out.println(localException);
    }
  }
  


  public static void encryptFile(String paramString)
  {
    File localFile1 = new File(paramString);
    
    File localFile2 = new File("E:\\EncryptedFiles\\" + localFile1.getName());
    
    try
    {
      EncryptDecrypt.encryptFile(localFile1, localFile2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  


  public static void decryptFile(String paramString)
  {
    File localFile1 = new File(paramString);
    

    File localFile2 = new File("E:\\DecryptedFiles\\" + localFile1.getName());
    

    try
    {
      EncryptDecrypt.decryptFile(localFile1, localFile2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}
