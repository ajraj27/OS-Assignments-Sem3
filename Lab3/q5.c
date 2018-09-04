#include <stdio.h>
#include <signal.h>
#include<stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main()
{
	fork();
	fork();
	printf("My PID is %d and my PPID is %d\n",getpid(),getppid());
}