#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>

int main(){
	printf("Enter two integers and a character\n");
	char a,b;
	char c;
	int stat;
	scanf("%c %c\n",&a,&b);
	scanf("%c", &c);
	pid_t pid = fork();
	if(pid<0){
		printf("Error\n");
		return 0;
	}
	if (pid==0){
		printf("Switched to child process\n");
		execl("./server","server",&a,&b,&c,NULL);
	}
	else{
		int stat;
		printf("Inside Parent Process\n");
		waitpid(pid,&stat,0);
		printf("The result is %d\n",WEXITSTATUS(stat));
	}
	return 0;
}
	
