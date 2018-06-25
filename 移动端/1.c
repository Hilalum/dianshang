#include<stdio.h>
struct Char
{
	char a[80];
}

main()
{
	int i;
	struct Char b[10];
	for(i=0;i<10;i++)
	{
		scanf("%s",&b[i].a);
	}
	for(i=0;i<10;i++)
	{
		printf("%s\n",b[i].a);
	}
}

