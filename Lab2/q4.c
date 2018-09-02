#include <stdio.h>
int main(int argc, char* argv[])
{
    FILE *fp_read, *fp_write;
    int counter = 1, i = 0;
    char ch;

    fp_read = fopen("hello.txt", "r");
    fp_write = fopen("hello.txt", "r+");

    if(!fp_read || !fp_write)
    {
        printf("File not present\n");
        exit(1);
    }

    fseek(fp_read, 0, SEEK_END);       
    int size = ftell(fp_read);             
    printf("Size = %d\n", size);           
    fseek(fp_read, 0, SEEK_SET);           

    while(counter < size)
    {
        ch = fgetc(fp_read);
        if(counter % 5 != 0)
        {
            fputc(ch, fp_write);
        }
        else
            i++;
        counter++;
    }

    fclose(fp_read);
    fclose(fp_write);
    printf("Trucate by %d bytes\n", i);
    return 0;
}
