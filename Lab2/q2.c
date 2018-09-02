#include <unistd.h>		
#include <stdio.h>		
#include <fcntl.h>		

int main(int ac, char *av[])
{
  if ( ac < 2 ) return 0;

  int fd = open(av[1],O_RDONLY);
  int block_size=512;

  int size = lseek(fd, 0, SEEK_END);

  printf("Size of the file = %d\n", size);

  close(fd);
  
  return 0;
}
