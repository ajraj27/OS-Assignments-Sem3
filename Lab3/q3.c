#include <stdio.h>
#include <signal.h>
#include<stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

int main()
{
	int pid, state;
	printf("before the fork system call\n");

	pid=fork();
	if (pid != 0)
	{
		printf("Its a parent process\n");
		wait(&state);
	}
	else
	{
		printf("Its a child process\n");
	}
	printf("After fork state in decimal = %d\n",state);
	printf("After fork state in hexadecimal = %x\n",state);
	printf("PID child in decimal = %d \n", pid);
	printf("PID child in hexadecimal = %x \n", pid);

}
