#include<stdio.h>
#include <locale.h>
#include<wchar.h>
#include<string.h>
#include <stdlib.h>

int main() {
	//汉字
	//unicode: \u6c49\u5b57
	//unicode: 27721 23383
	//unicode: 0b00000000 00000000 01101100 01001001 0b00000000 00000000 01011011 01010111
	//unicode: 0b00000000 00000000 0110 110001 001001 0b00000000 00000000 0101 101101 010111
	//wchar_t * pw = L"Hello!汉字" ;
	// 1110 0110  10 110001  10 001001
	// 1110 0101  10 101101  10 010111
	// 230 177 137 229 173 151

	//中文
	//\u4E2D \u6587
	wchar_t * pw = L"汉字" ;
	printf("%zu", wcslen (pw));
	setlocale(LC_ALL, "zh_CN.UTF-8");
	//wprintf(L"%ls", (wchar_t *)pw);
	wprintf(L"%lc", pw[0]);
	printf("%lu\n", sizeof(wchar_t));
	printf("%lu\n", sizeof(int));
	char *p = (char *)pw;
	printf("....\n");
	printf("%d\n", (int)(*pw++));
	printf("%d\n", (int)(*pw++));
	for (int i = 0; i < strlen(p); ++i)
	{
		printf("%d\n", p[i]);
	}

	//size_t wcsrtombs(char *restrict dst, const wchar_t **restrict src, size_t len, mbstate_t *restrict ps);
	char * utf8_bytes = (char *)malloc(6);
	pw = L"汉字" ;
	wcstombs(utf8_bytes, pw, 6);
	for (int i = 0; i < 6; ++i)
	{
		printf("%d\n", (char)(*utf8_bytes++) & 0xff);
	}
	
	return 0;
}