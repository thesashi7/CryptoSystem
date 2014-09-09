
package Transposition;



/**
 *
 * @author thapaliya
 */
public class ColumnarTransposition extends Transposition
{

    private int numberOfColums;
    
    public ColumnarTransposition(int numColums)
    {
        this.numberOfColums=numColums;
    }
    
    
    @Override
    public String transpose(String stream) 
    {
        char [] cipher;
        int numRows, numColums, row, colum,i;
	
        cipher = new char[stream.length()];
	//makes fixed 5 colums with the number of rows depending on the stream size
	numRows= (int)Math.ceil(stream.length()/this.numberOfColums);
	
	i=0;
        System.out.println("\ndiffusing: \n");
        for(colum=0; colum<this.numberOfColums; colum++)
	{	
		
		for(row=0; (row<numRows && i<stream.length()); row++)
		{
                        cipher[(row*this.numberOfColums)+colum] = stream.charAt(i++);
                        System.out.print(cipher[(row*this.numberOfColums)+colum]);
                        
		}
		
		System.out.println();
	}
	   
        
        return String.copyValueOf(cipher);
    }
    
}
