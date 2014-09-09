
package cryptosystem;

import Substitution.*;
import Transposition.*;

/**
 *
 * @author thapaliya
 */
public class Decrypt 
{
    private Substitution substitution;
    private Transposition transposition;
    
    public Decrypt()
    {
        this.substitution = new ReversePolyAlphabeticSubstitution();
        this.transposition = new ReverseColumnarTransposition(5);
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
     * First resubstitutes and retransposes the characters
     * However a character might be added or modified in the final text
     * But, the deciphered text would be sufficeint to get the plain text
     * @param cipher to be deciphered
     * @return the final text
     */
    public String decipher(String cipher)
    {
        String text;
        text="";
        
        text = this.substitution.substitute(cipher);
        text =this.transposition.transpose(text);
        
        return text;
    }
    
}
