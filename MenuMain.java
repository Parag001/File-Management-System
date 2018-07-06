package javaprogram.java.filemanager;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;


public class MenuMain
{
  
  
  public static void main(String args[]) throws IOException
  {
    Scanner localScanner = new Scanner(System.in);
    String str1 = "";
    
    String str2 = "";
    
    do
    {
      System.out.println("*** Welcome To File Management System ***");
      System.out.println("1. Create file");
      System.out.println("2. Rename file");
      System.out.println("3. Delete file");
      System.out.println("4. Create directory");
      System.out.println("5. Rename directory");
      System.out.println("6. Delete directory");
      System.out.println("7. View Files in a Directory");
      System.out.println("8. Copy File");
      System.out.println("9. Compress");
      System.out.println("10. Decompress");
      System.out.println("11. Encrypt");
      System.out.println("12. Decrypt");
      System.out.println("13. Exit");
      System.out.println("**********************************************");
      System.out.println("Please enter your choice:");
      

      str1 = localScanner.next();
      

      localScanner = new Scanner(System.in);
      String str4; Object localObject; switch (str1)
      {


      case "1": 
        System.out.println("Enter the file path where you want to create the file ");
        str2 = localScanner.nextLine();
        
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");
        }
        else
        {
          System.out.println("Enter the content :");
          str4 = localScanner.nextLine();
          FileUtility.createFile(str2, str4);
        }
        
        break;
      

      case "2": 
        System.out.println("Enter the path of the file where you want to rename ");
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");
        }
        else
        {
          System.out.println("Enter the new name of the file with extension eg : test.txt");
          str4 = localScanner.nextLine();
          FileUtility.reNameFile(str2, str4);
        }
        break;
      
      case "3": 
        System.out.println("Enter the path of the file which you want to delete ");
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");
        }
        else
        {
          FileUtility.deleteFile(str2);
        }
        break;
      
      case "4": 
        System.out.println("Enter the directory you want to create ");
        str4 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");
        }
        else
        {
          FileUtility.createDirectory(str4);
        }
        break;
      
      case "5": 
        System.out.println("Enter the directory that you want to rename ");
        str4 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          System.out.println("Enter the new name for the Directory ");
          localObject = localScanner.nextLine();
          if (((String)localObject).isEmpty())
          {
            System.out.println("\nInvalid input..!\n");

          }
          else
          {
            FileUtility.reNameDirectory(str4, (String)localObject);
          }
        }
        break;
      
      case "6": 
        System.out.println("Enter the directory you want to delete ");
        str4 = localScanner.nextLine();
        if (str4.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          localObject = new File(str4);
          int j = FileUtility.deleteDirectory((File)localObject);
          if (j == 1)
          {
            System.out.println("Directory deleted successfully..!");
          }
        }
        break;
      
      case "7": 
        System.out.println("Enter the directory you want to view ");
        str4 = localScanner.nextLine();
        if (str4.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          localObject = new File(str4);
          FileUtility.viewDirectory((File)localObject);
        }
        break;
      
      case "8": 
        System.out.println("Enter the file name along with the path you want to copy ");
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          FileUtility.copyFile(str2);
        }
        break;
      
      case "9": 
        System.out.println("Enter the file name along with the path you want to compress with extension ");
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          localObject = new File(str2);
          FileUtility.compressFile((File)localObject);
        }
        
        break;
      
      case "10": 
        System.out.println("Enter the zip file name that you want to decompress ");
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          FileUtility.decompressFile(str2);
        }
        break;
      

      case "11": 
        System.out.print("\nEnter the file path that you want to encrypt : ");
        
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          FileUtility.encryptFile(str2);
        }
        break;
      


      case "12": 
        System.out.print("\nEnter the file path that you want to Decrypt : ");
        
        str2 = localScanner.nextLine();
        if (str2.isEmpty())
        {
          System.out.println("\nInvalid input..!\n");

        }
        else
        {
          FileUtility.decryptFile(str2);
        }
        break;
      

      case "13": 
        System.out.print("\nEnter the folder name to copy with path : ");
        str2 = localScanner.nextLine();
        
        System.out.print("\nEnter the folder name to copy with path : ");
        localObject = localScanner.nextLine();
        
        FileUtility.copyDirectory(str2, (String)localObject);
      



      default: 
        System.out.print("\nInvalid Choice\n ");
      }
      
    } while (str1 != "13");
  }
}
