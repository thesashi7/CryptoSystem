#include <stdio.h>

char *text;

void decrypt(char *buffer, int bufferSize);
void reSubstitute(char *stream, int streamSize);
void reTransport(char *stream, int streamSize);

int main()
{
	FILE *file;
	char *buffer;
	char filename[] = "enctest.txt";
	int size,i;
	char c;

	size=0, i=0;
	c='0';
	
	printf("THis is a test\n");
	
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
		c = (c-5);
		buffer[i++]=c;
		//printf("loop\n");
		//printf("%c",i);
	}
	buffer[i]='\0';
	
	fputs(buffer, stdout);
	fclose(file);
	
	//encrypt(buffer,i, filename);
	//printf("%s\n",getFileNameForCipher(filename));
	return 1;



}


void decrypt(char *buffer, int bufferSize)
{
	FILE *file;

}


void reSubstitute(char *stream, int streamSize)
{

}


void reTransport(char *stream, int streamSize)
{


}