#include <stdio.h>
#include <signal.h>
#include<stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main()
{
	int var;
	printf("Address value : %p\n",&var);

	while(1)
	{
		fork();
		fork();
		printf("After fork , Address value : %p\n",&var);
	}
}