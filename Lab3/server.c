#include<stdio.h>
#include<sys/types.h>
#include<sys/wait.h>
#include<unistd.h>

int main(int argc,char **argv){
	int res=0;
	int a,b;
	a=*argv[1]-'0';
	b=*argv[2]-'0';
	if(*argv[3]=='+')
		res = a+b;
	else
		res = abs(a-b);
	exit(res);
	return 0;
}
