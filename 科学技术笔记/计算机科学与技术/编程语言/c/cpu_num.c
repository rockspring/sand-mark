#include<stdio.h>
#include<unistd.h>

int main() {
       	int cpu_num; cpu_num = sysconf(_SC_NPROCESSORS_CONF);
       	printf("_SC_NPROCESSORS_CONF=%d\n",cpu_num);
       	cpu_num = sysconf(_SC_NPROCESSORS_ONLN);
       	printf("_SC_NPROCESSORS_ONLN=%d\n",cpu_num);
       	return 0;
}
/*
* - _SC_NPROCESSORS_CONF * The number of processors configured. *
* - _SC_NPROCESSORS_ONLN * The number of processors currently online (available).
*/