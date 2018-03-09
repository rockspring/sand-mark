#include <iostream>
#include <fstream>

int main(int argc, char **argv) {
	float f = -3.5f;
	std::ofstream litter_endian("float_data_litter_endian.bin", std::ios::binary);
	litter_endian.write((char *)&f, sizeof(f));
	litter_endian.close();

	std::ofstream output_big_endian("float_data_big_endian.bin", std::ios::binary);
	char *fc = (char *)&f;
	
	output_big_endian.write(fc+3, 1);
	output_big_endian.write(fc+2, 1);
	output_big_endian.write(fc+1, 1);
	output_big_endian.write(fc, 1);
	output_big_endian.close();

	return 1;
}