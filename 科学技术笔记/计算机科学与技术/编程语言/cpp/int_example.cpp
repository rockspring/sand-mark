#include <iostream>
#include <fstream>

int main(int argc, char **argv) {
	int n1 = 35;
	int n2 = -35;
	std::ofstream litter_endian("float_data_litter_endian.bin", std::ios::binary);
	litter_endian.write((char *)&n1, sizeof(n1));
	litter_endian.write((char *)&n2, sizeof(n2));
	litter_endian.close();

	std::ofstream output_big_endian("float_data_big_endian.bin", std::ios::binary);
	char *n1c = (char *)&n1;
	
	output_big_endian.write(n1c+3, 1);
	output_big_endian.write(n1c+2, 1);
	output_big_endian.write(n1c+1, 1);
	output_big_endian.write(n1c, 1);

	char *n2c = (char *)&n2;
	
	output_big_endian.write(n2c+3, 1);
	output_big_endian.write(n2c+2, 1);
	output_big_endian.write(n2c+1, 1);
	output_big_endian.write(n2c, 1);

	output_big_endian.close();

	return 1;
}