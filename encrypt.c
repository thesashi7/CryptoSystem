#include <stdio.h>
#include <math.h>

//this is the array that contains the cipher
char *cipher;

/*
	returns the cipher file name for the given file
	Basic format is enc.concant(filename.txt)
 */
char* getCipherFileName(char *filename);

/*
	buffer is the stream of characters (of the message) to be encrypted
	bufferSize is the size of the buffer
	file is the name of the cipherFile
*/
void encrypt(char *buffer, int bufferSize, char* file);

/*
	encrypts the given stream of characters using substitution
	Uses key from the user
	stream is the stream of characters to be substituted
	streamSize is the size of the stream
*/
void substitute(char *stream, int streamSize);

/*
	encrypts the given stream by using transportation
	stream is the stream of characters to be substituted
	streamSize is the size of the stream	
*/
void transport(char *stream, int streamSize);

int main()
{
	FILE *file;
	char *buffer;
	char filename[] = "text.txt";
	int size,i;
	char c;

	size=0, i=0;
	c='0';
	
	
	file = fopen(filename, "r");

	if(file==NULL){ perror("Error opening file"); return -1;}
	
	fseek(file, 0L, SEEK_END);
	size = ftell(file);
	fseek(file, 0L, SEEK_SET);
	buffer = (char*)malloc(size* sizeof(char));
	buffer[size]='\0';

	while((c=fgetc(file))!=EOF)
	{
		//printf("%c",buffer[i]);
		buffer[i++]=c;
		//printf("loop\n");
		printf("%c",c);
	}
	buffer[i]='\0';
	
	//fputs(buffer, stdout);
	fclose(file);
	
	encrypt(buffer,i, filename);
	//printf("%s\n",getFileNameForCipher(filename));
	return 1;

}

char* getCipherFileName(char *filename)
{
	int i,j;
	char * cipherFileName;
	
	i=0,j=0;
	
	cipherFileName = (char*)malloc(strlen(filename)*sizeof(char));
	
	cipherFileName[j++]='e';
	cipherFileName[j++]='n';
	cipherFileName[j++]='c';
	
	while(filename[i]!='.')
	{
		cipherFileName[j++]= filename[i++];
		//printf("%c", filename[i++]);
	}
	cipherFileName[j++]='.';
	cipherFileName[j++]='t';
	cipherFileName[j++]='x';
	cipherFileName[j++]='t';
	cipherFileName[j]='\0';
	
	return cipherFileName;
}


void encrypt(char *buffer, int bufferSize, char* file)
{
	FILE *cipherFile;
	int i;
	
	cipher = malloc(bufferSize* sizeof(char));
	cipherFile= fopen("enctest.txt","w");
	
	if(cipherFile==NULL)
	{
		perror("Error could not open file!\n");
		exit(1);
	}
	
	 transport(buffer, bufferSize);
	 substitute(cipher, bufferSize);
	
	for(i=0; i<bufferSize; i++) printf("%c",cipher[i]);
	fputs(cipher, cipherFile);
	//substitute(buffer, bufferSize);
	
	fclose(cipherFile);
	free(buffer);

}

void substitute(char *stream, int streamSize)
{
	char key[20], finalKey;
	int i, size;
	
	printf("%s", "Enter key for encryption:");
	fgets(key,20, stdin);
	
	size=strlen(key);
	finalKey=key[0];
	for(i=1; i< size; i++)
		finalKey*= key[i];
	
	i=0;
	
	while(i<streamSize)
	{
		cipher[i]=(*stream++) +finalKey;
		printf("%c", cipher[i]);
		i++;
		//fputc(cipher, cipherFile);
		finalKey = (finalKey*5) ;
	    
	}
	cipher[i]='\0';
	

}


void transport(char *stream, int streamSize)
{
	int numRows, numColums, row, colum;
	
	//makes fixed 5 colums with the number of rows depending on the stream size
	numRows= ceil(streamSize/5);
	numColums = 5;
	row =0, colum=0;
	printf("%s", "here\n");
	while(colum<numColums)
	{	printf("%s", "main loop\n");
		row=0;
		while(row<numRows)
		{
			//printf("%s", "ins loop\n");
			cipher[(row*numColums)+colum]= (*stream++) ;
		
			row++;
		}
		
		colum++;
	}
	
	cipher[(row*numColums)+colum]='\0';
	puts(cipher);
		
	
}