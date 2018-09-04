#include <stdio.h>
#include <signal.h>
#include<stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int i=0;

void doSomething(char *name)
{
		for(;i<5;i++)
			printf("Looping for %s with value %d\n",name,i);
}

int main()
{
	int pid=fork();

	if(pid==0)
		doSomething("child");

	else
		doSomething("parent");

}