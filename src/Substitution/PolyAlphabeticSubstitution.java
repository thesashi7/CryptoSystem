
package Substitution;



import java.util.Scanner;

/**
 *
 * @author thapaliya
 */
public class PolyAlphabeticSubstitution extends Substitution
{

  
    public String substitute(String stream) 
    {
        String cipher, key;
        char finalKey;
        Scanner input;
        int i;
        
        cipher=""; key="";
        finalKey=1;
        input = new Scanner(System.in);
        
	System.out.print("Enter key for encryption: ");
        key = input.nextLine();

	for (i=0; i< key.length(); i++)
            finalKey *= key.charAt(i);
        
       
        	
	for(i=0; i< stream.length(); i++)
	{
            
		cipher=cipher.concat(Character.toString((char)(stream.charAt(i) +finalKey)));
		//fputc(cipher, cipherFile);
		finalKey = (char)(finalKey*5) ;
                
	    
	}
	
      return cipher;  
    }
    
}
