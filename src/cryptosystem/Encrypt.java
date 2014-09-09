
package cryptosystem;

import Substitution.*;
import Transposition.*;

/**
 *
 * @author thapaliya
 */
public class Encrypt
{
    private Substitution substitution;
    private Transposition transposition;
    
    public Encrypt()
    {
        this.substitution = new PolyAlphabeticSubstitution();
        this.transposition = new ColumnarTransposition(5);
    }
    
    public void setSubstition(Substitution subs)
    {
        this.substitution = subs;
    }
    
    public void setTransposition(Transposition trans)
    {
        this.transposition = trans;
    }
    
    /**
     * First uses transposition and then substitution to get the final cipher
     * @param text to be encrypted
     * @return the final cipher
     */
    public String encipher(String text)
    {
        String cipher;
        cipher="";
        
       
        cipher =this.transposition.transpose(text);
        cipher = this.substitution.substitute(cipher);
        
        
        return cipher;
    }
    
}
