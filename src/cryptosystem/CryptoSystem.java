
package cryptosystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * This is a CryptoSystem that can be used for encryption or decryption of files.
 * @author thapaliya
 */
public class CryptoSystem {

 
    public static void main(String[] args) 
    {
       Encrypt encryptor;
       Decrypt decryptor;
       String text, fileName, mode;
       Scanner input;
       
       encryptor = new Encrypt();
       decryptor = new Decrypt();
       text="";
       input = new Scanner(System.in);
       
       while(true)
       {
            System.out.println("Enter 1 to encrypt or 2 to decrypt or 0 to exit:");
            mode = input.nextLine();
            
            if(mode.equals("1"))
            {
                System.out.print("Enter the file to encrypt:");
                fileName =input.nextLine();
       
                text = getFromFile(fileName);
                if(text!=null)writeToFile(encryptor.encipher(text), "cipher");
            }
            else if(mode.equals("2"))
            {
               System.out.print("Enter the file to decrypt:");
               fileName =input.nextLine();
       
               text = getFromFile(fileName);
               if(text!=null)writeToFile(decryptor.decipher(text),"cracked");
            
            }
            else if(mode.equals("0")) break;
            //input.nextLine(); // just to clear the buffer in case any left overs
            //while(input.hasNext())input.next();
       }
    }
    
    public static String getFromFile(String fileName)
    {
        String text = "";
        
        try 
        {
            FileInputStream inputStream;
            BufferedReader bufReader;
            int unit;
            
            inputStream = new FileInputStream(new File(fileName));
            bufReader = new BufferedReader(new InputStreamReader(inputStream));
            text = "";
            unit=0;
            //System.out.println("here");
            while((unit= bufReader.read())!= -1)
            {   //System.out.println("loop");
                text = text.concat(Character.toString((char)unit));
                //System.out.println(text);
            }
            
            bufReader.close();
            inputStream.close();
            
        } catch (FileNotFoundException ex) 
        {
            System.out.println(ex.toString());
            text=null;
        } catch (IOException ex) 
        {
            System.out.println(ex.toString());
            text = null;
        }
        
        return text;
    }
    
    public static void writeToFile(String cipher, String origFileName)
    {
        try 
        {
            FileOutputStream outputStream;
            BufferedWriter bufWriter;
            int i;
            
            outputStream = new FileOutputStream(new File("enc".concat(origFileName).concat(".txt")));
            bufWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            
          
            bufWriter.write(cipher);
            
            
            bufWriter.close();
            outputStream.close();
            
        } catch (FileNotFoundException ex) 
        {
            System.out.println(ex.toString());
        } catch (IOException ex) 
        {
            System.out.println(ex.toString());
        }
        
    }
}
