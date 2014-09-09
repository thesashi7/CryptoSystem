/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Transposition;



/**
 *
 * @author thapaliya
 */
public class ReverseColumnarTransposition extends Transposition{

    private int numberOfColums;
    
    public ReverseColumnarTransposition(int numColums)
    {
        this.numberOfColums=numColums;
    }
    
    @Override
    public String transpose(String stream)
    {
        char [] text;
        int numRows, numColums, row, colum,i;
	
        text = new char[stream.length()];
	//makes fixed 5 colums with the number of rows depending on the stream size
	numRows= (int)Math.ceil(stream.length()/this.numberOfColums);
	
	i=0;
        System.out.println("\ncombining: \n");
        for(colum=0; colum<this.numberOfColums; colum++)
	{	
		
		for(row=0; (row<numRows && i<stream.length()); row++)
		{
                        text[i] = stream.charAt((row*this.numberOfColums)+colum);
                        i++;
                        System.out.print(text[i-1]);
                        
		}
		
		System.out.println();
	}
	   
        
        return String.copyValueOf(text);
    }
    
}
