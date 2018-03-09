#include <stdio.h>
#include <fcntl.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

char readByte(int fd) {
	char char_byte = '\0';
	read(fd, &char_byte,1);

	return char_byte;
}

int readVInt(int fd) {
	char b = readByte(fd);

	if (b>=0) {
		return b;
	}
	int i = b & 0x7f;

	b = readByte(fd);

	i += (b & 0x7f) << 7;

	if (b >=0)
	{
		return i;
	}

	b = readByte(fd);


	i += (b & 0x7f) << 14;

	if(b>=0) {
		return i;
	}

	b = readByte(fd);

	i += (b & 0x7f) << 21;

	if (b>=0)
	{
		return i;
	}

	b = readByte(fd);

	i += (b & 0x0f) << 28;

	if ((b & 0xf0) ==0)
	{
		return i;
	}

	printf("%s\n", "read variable int error!");

	return 0;
}



 int readInt(int fd) {
	char a = readByte(fd);
	char b = readByte(fd);
	char c = readByte(fd);
	char d = readByte(fd);

	printf("%d\n", (int)a);
	printf("%d\n", (int)b);
	printf("%d\n", (int)c);
	printf("%d\n", (int)d);

	 int int_number = (a & 0xff)<<24;

	int_number += ( b & 0xff)<<16;
	int_number += ( c & 0xff)<<8;
	int_number += ( d & 0xff);


	return int_number;
}

long readLong(fd) {
	 int high = ( int)readInt(fd);
	printf("readLong--》high%d\n", high);
	printf("readLong--》high（unsigned long）%ld\n", ( long)high << 32);

	 int low = ( int)readInt(fd);
	printf("readLong--》low%d\n", low);
	printf("readLong--》low（unsigned long）%ld\n", ( long)high << 32);

	//printf("low%ld\n", (unsigned long)readInt(fd) & 0xFFFFFFFFL);
	return ((long)high << 32) | ((long)low & 0xFFFFFFFFL);

	//return 0;
}

char * readString(int fd) {
	int str_len = readVInt(fd);
	char *codec = malloc(str_len+1);
	ssize_t size = read(fd,codec,str_len);

	codec[str_len] = '\0';

	return codec;
}

void readSegmentInfos() {
	//文件名：segments_6djg
	int fd=open("/Users/zlq/Servers/solr/solr-5.0.0/server/solr/collection1/data/index/segments_6djg",O_RDONLY);
	printf("file_descriptor=%d\n", fd);

	printf("magic_number=0x%x\n", readInt(fd));
	printf("codec=%s\n", readString(fd));
	printf("version=%d\n", readInt(fd));

	/*
	-125
	-88
	-109
	-1
	40
	-17
	-50
	47
	-122
	-23
	110
	-38
	-86
	98
	23
	-24
	*/
	for (int i = 0; i < 16; ++i)
	{
		printf("ObjectID[%d]=%d\n",i, readByte(fd));
	}

	int suffixLength = readByte(fd);

	//expectedSuffix=6djg
	//utf-8字符串

	for (int i = 0; i < suffixLength; ++i)
	{
		printf("SuffixLength[%d]=%c\n",i, readByte(fd));
	}

	//version=19875856

	//printf("version high=%d\n", readInt(fd));
	//printf("version low=%d\n", readInt(fd));

	long version = readLong(fd);

	printf("version=%ld\n", version);

	//7526464
	unsigned int counter = readInt(fd);

	printf("counter=%d\n", counter);

	//7526464
	unsigned int numSegments = readInt(fd);

	printf("numSegments=%d\n", numSegments);

	for (int i = 0; i < numSegments; ++i)
	{
		printf("segName=%s\n", readString(fd));

		char hasID = readByte(fd);
		printf("hasID=%d\n", hasID);

		/*
		-125
		-88
		-109
		-1
		40
		-17
		-50
		47
		-122
		-23
		110
		-38
		-86
		98
		23
		-24
		*/
		for (int i = 0; i < 16; ++i)
		{
			printf("segmentID[%d]=%d\n",i, readByte(fd));
		}

		char * CodecName = readString(fd);
		printf("CodecName=%s\n", CodecName);

		long delGen = readLong(fd);
		printf("delGen=%ld\n", delGen);

		int delCount = readInt(fd);
		printf("delCount=%d\n", delCount);

		long fieldInfosGen = readLong(fd);
		printf("fieldInfosGen=%ld\n", fieldInfosGen);

		long dvGen = readLong(fd);
		printf("dvGen=%ld\n", dvGen);

		int set_count = readInt(fd);
		printf("set_count=%d\n", set_count);

		for (int i = 0; i < set_count; ++i)
		{
			printf("set[%d]=%s\n", i, readString(fd));
		}

		
		int numDVFields = readInt(fd);
		printf("numDVFields=%d\n", numDVFields);

		int map_count = readInt(fd);
		//map_count = readInt(fd);
		//map_count = readInt(fd);

		/*
		"timestamp" -> "1426585092477"
		"os" -> "Mac OS X"
		"os.version" -> "10.10.2"
		"mergeFactor" -> "21"
		"source" -> "merge"
		"lucene.version" -> "5.0.0"
		"os.arch" -> "x86_64"
		"mergeMaxNumSegments" -> "1"
		"java.version" -> "1.7.0_67"
		"java.vendor" -> "Oracle Corporation"
		*/

		for (int i = 0; i < map_count; ++i)
		{
			printf("key=%s\n", readString(fd));
			printf("value=%s\n", readString(fd));
		}
	}

	int FOOTER_MAGIC = readInt(fd);
	printf("FOOTER_MAGIC=%d\n", FOOTER_MAGIC);

	
	int algorithmID = readInt(fd);
	printf("algorithmID=%d\n", algorithmID);

	

	long actualChecksum = readLong(fd);
	printf("actualChecksum=%ld\n", actualChecksum);
}

void readSegmentInfo() {
	//文件名：_4hbgf.si
	int fd=open("/Users/zlq/Servers/solr/solr-5.0.0/server/solr/collection1/data/index/_4hbgf.si",O_RDONLY);
	printf("file_descriptor=%d\n", fd);

	printf("magic_number=0x%x\n", readInt(fd));
	printf("codec=%s\n", readString(fd));
	printf("version=%d\n", readInt(fd));

	/*
	-125
	-88
	-109
	-1
	40
	-17
	-50
	47
	-122
	-23
	110
	-38
	-86
	98
	23
	-24
	*/
	for (int i = 0; i < 16; ++i)
	{
		printf("ObjectID[%d]=%d\n",i, readByte(fd));
	}

	int suffixLength = readByte(fd);

	//expectedSuffix=6djg
	//utf-8字符串

	for (int i = 0; i < suffixLength; ++i)
	{
		printf("SuffixLength[%d]=%c\n",i, readByte(fd));
	}

	//version=19875856

	printf("version major=%d\n", readInt(fd));
	printf("version minor=%d\n", readInt(fd));
	printf("version bugfix=%d\n", readInt(fd));

	printf("docCount=%d\n", readInt(fd));

	char isCompoundFile = readByte(fd);
	printf("isCompoundFile=%d\n", isCompoundFile);

	int map_count = readInt(fd);
	//map_count = readInt(fd);
	//map_count = readInt(fd);

	/*diagnostics
	"timestamp" -> "1426585092477"
	"os" -> "Mac OS X"
	"os.version" -> "10.10.2"
	"mergeFactor" -> "21"
	"source" -> "merge"
	"lucene.version" -> "5.0.0"
	"os.arch" -> "x86_64"
	"mergeMaxNumSegments" -> "1"
	"java.version" -> "1.7.0_67"
	"java.vendor" -> "Oracle Corporation"
	*/

	for (int i = 0; i < map_count; ++i)
	{
		printf("key=%s\n", readString(fd));
		printf("value=%s\n", readString(fd));
	}

	int set_count = readInt(fd);
	printf("set_count=%d\n", set_count);

	for (int i = 0; i < set_count; ++i)
	{
		printf("set[%d]=%s\n", i, readString(fd));
	}

	map_count = readInt(fd);
	//map_count = readInt(fd);
	//map_count = readInt(fd);

	/*attributes
	*/

	for (int i = 0; i < map_count; ++i)
	{
		printf("key=%s\n", readString(fd));
		printf("value=%s\n", readString(fd));
	}

	int FOOTER_MAGIC = readInt(fd);
	printf("FOOTER_MAGIC=%d\n", FOOTER_MAGIC);

	
	int algorithmID = readInt(fd);
	printf("algorithmID=%d\n", algorithmID);

	

	long actualChecksum = readLong(fd);
	printf("actualChecksum=%ld\n", actualChecksum);
}

void readFieldInfos() {
	//文件名：_4hbgf.fnm
	int fd=open("/Users/zlq/Servers/solr/solr-5.0.0/server/solr/collection1/data/index/_4hbgf.fnm",O_RDONLY);
	printf("file_descriptor=%d\n", fd);

	printf("magic_number=0x%x\n", readInt(fd));
	printf("codec=%s\n", readString(fd));
	printf("version=%d\n", readInt(fd));

	/*
	-125
	-88
	-109
	-1
	40
	-17
	-50
	47
	-122
	-23
	110
	-38
	-86
	98
	23
	-24
	*/
	for (int i = 0; i < 16; ++i)
	{
		printf("ObjectID[%d]=%d\n",i, readByte(fd));
	}

	int suffixLength = readByte(fd);

	//expectedSuffix=6djg
	//utf-8字符串

	for (int i = 0; i < suffixLength; ++i)
	{
		printf("SuffixLength[%d]=%c\n",i, readByte(fd));
	}

	//头结束

	//size=368
	//fields_count

	int fields_count = readVInt(fd);

	printf("fields_count=%d\n", fields_count);

	const int STORE_TERMVECTOR = 0x1;
	const int OMIT_NORMS = 0x2;
	const int STORE_PAYLOADS = 0x4;

	for (int i = 0; i < fields_count; ++i)
	{
		char * name = readString(fd);
		printf("name=%s\n", name);

		int fieldNumber = readVInt(fd);
		printf("fieldNumber=%d\n", fieldNumber);

		char bits = readByte(fd);

		int storeTermVector = (bits & STORE_TERMVECTOR) != 0;
        int omitNorms = (bits & OMIT_NORMS) != 0;
        int storePayloads = (bits & STORE_PAYLOADS) != 0;

        printf("storeTermVector=%d\n", storeTermVector);
        printf("omitNorms=%d\n", omitNorms);
        printf("storePayloads=%d\n", storePayloads);

        char indexOptions = readByte(fd);

        switch(indexOptions) {
        	case 0:
        		printf("%s\n", "NONE");
        		break;
        	case 1:
        		printf("%s\n", "DOCS");
        		break;
        	case 2:
        		printf("%s\n", "DOCS_AND_FREQS");
        		break;
        	case 3:
        		printf("%s\n", "DOCS_AND_FREQS_AND_POSITIONS");
        		break;
        	case 4:
        		printf("%s\n", "DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS");
        		break;
        }

        //
        char docValuesType = readByte(fd);
        switch(docValuesType) {
        	case 0:
        		printf("%s\n", "NONE");
        		break;
        	case 1:
        		printf("%s\n", "NUMERIC");
        		break;
        	case 2:
        		printf("%s\n", "BINARY");
        		break;
        	case 3:
        		printf("%s\n", "SORTED");
        		break;
        	case 4:
        		printf("%s\n", "SORTED_SET");
        		break;
        	case 5:
        		printf("%s\n", "SORTED_SET");
        		break;
        }

        //
        long dvGen = readLong(fd);
        printf("dvGen=%ld\n", dvGen);

        //attributes
        int map_count = readInt(fd);

		for (int i = 0; i < map_count; ++i)
		{
			printf("key=%s\n", readString(fd));
			printf("value=%s\n", readString(fd));
		}
	}

	// footer

	int FOOTER_MAGIC = readInt(fd);
	printf("FOOTER_MAGIC=%d\n", FOOTER_MAGIC);

	
	int algorithmID = readInt(fd);
	printf("algorithmID=%d\n", algorithmID);

	

	long actualChecksum = readLong(fd);
	printf("actualChecksum=%ld\n", actualChecksum);
}

void readEntry(int fd) {
	int count = readVInt(fd);
	printf("readEntry count=%d\n", count);

	char format = readByte(fd);
	printf("readEntry format=%d\n", format);


	char offset = readLong(fd);
	printf("readEntry offset=%d\n", offset);

	int number ;

	switch(format) {
		case 2:
		case 3:
		case 1:
		case 0:
			printf("%s\n", "finish recurcive");
			//exit(-1);
			break;
		case 5:
		case 6:
		case 4:
			number = readVInt(fd);
			printf("readEntry number%d\n", number);
			readEntry(fd);
			break;
			//exit(-1);
	}
}

void readLucene50NormsMetadata() {
	//文件名：_4hbgf.fnm
	int fd=open("/Users/zlq/Servers/solr/solr-5.0.0/server/solr/collection1/data/index/_4hbgf.nvm",O_RDONLY);
	printf("file_descriptor=%d\n", fd);

	printf("magic_number=0x%x\n", readInt(fd));
	printf("codec=%s\n", readString(fd));
	printf("version=%d\n", readInt(fd));

	/*
	-125
	-88
	-109
	-1
	40
	-17
	-50
	47
	-122
	-23
	110
	-38
	-86
	98
	23
	-24
	*/
	for (int i = 0; i < 16; ++i)
	{
		printf("ObjectID[%d]=%d\n",i, readByte(fd));
	}

	int suffixLength = readByte(fd);

	//expectedSuffix=6djg
	//utf-8字符串

	for (int i = 0; i < suffixLength; ++i)
	{
		printf("SuffixLength[%d]=%c\n",i, readByte(fd));
	}

	//头结束

	//size=368
	//fields_count

	int field_number = readVInt(fd);
	printf("field_number=%d\n", field_number);

	while (field_number != -1) {
		readEntry(fd);
		field_number = readVInt(fd);
		printf("field_number=%d\n", field_number);
	}


	// footer

	int FOOTER_MAGIC = readInt(fd);
	printf("FOOTER_MAGIC=%d\n", FOOTER_MAGIC);

	
	int algorithmID = readInt(fd);
	printf("algorithmID=%d\n", algorithmID);

	

	long actualChecksum = readLong(fd);
	printf("actualChecksum=%ld\n", actualChecksum);

	/**
	address
	spellfield
	community_name
	proptags
	*/
}

void readLucene50NormsData() {
	//文件名：_4hbgf.fnm
	int fd=open("/Users/zlq/Servers/solr/solr-5.0.0/server/solr/collection1/data/index/_4hbgf.nvd",O_RDONLY);
	printf("file_descriptor=%d\n", fd);

	printf("magic_number=0x%x\n", readInt(fd));
	printf("codec=%s\n", readString(fd));
	printf("version=%d\n", readInt(fd));

	/*
	-125
	-88
	-109
	-1
	40
	-17
	-50
	47
	-122
	-23
	110
	-38
	-86
	98
	23
	-24
	*/
	for (int i = 0; i < 16; ++i)
	{
		printf("ObjectID[%d]=%d\n",i, readByte(fd));
	}

	int suffixLength = readByte(fd);

	//expectedSuffix=6djg
	//utf-8字符串

	for (int i = 0; i < suffixLength; ++i)
	{
		printf("SuffixLength[%d]=%c\n",i, readByte(fd));
	}

	exit(-1);

	//头结束

	//size=368
	//fields_count

	int field_number = readVInt(fd);
	printf("field_number=%d\n", field_number);

	while (field_number != -1) {
		readEntry(fd);
		field_number = readVInt(fd);
		printf("field_number=%d\n", field_number);
	}


	// footer

	int FOOTER_MAGIC = readInt(fd);
	printf("FOOTER_MAGIC=%d\n", FOOTER_MAGIC);

	
	int algorithmID = readInt(fd);
	printf("algorithmID=%d\n", algorithmID);

	

	long actualChecksum = readLong(fd);
	printf("actualChecksum=%ld\n", actualChecksum);

	/**
	address
	spellfield
	community_name
	proptags
	*/
}

int main() {

	//readSegmentInfo();
	//readFieldInfos();
	readLucene50NormsMetadata();
	readLucene50NormsData();
	//printf("numStoredFields=%d\n", readVInt(fd));

	
	//BufferedChecksumIndexInput(MMapIndexInput(path="/Users/zlq/Servers/solr/solr-5.0.0/server/solr/collection1/data/index/segments_6djg"))

	/** length in bytes of an ID */
    //public static final int ID_LENGTH = 16;

	/*char* buf = malloc(10000);
	ssize_t size = read(file_descriptor,buf,10000);

	printf("read_size=%d\n", (int)size);


	char a = buf[0];
	char b = buf[1];
	char c = buf[2];
	char d = buf[3];

	printf("%d\n", (int)a);
	printf("%d\n", (int)b);
	printf("%d\n", (int)c);
	printf("%d\n", (int)d);

	unsigned int magic_number = (unsigned int)a<<24;

	magic_number += (unsigned int)b<<16;
	magic_number += (unsigned int)c<<8;
	magic_number += (unsigned int)d;

	printf("magic_number=0x%x\n", magic_number);

	int codec_len = buf[4];

	printf("buf[4]=%d\n", codec_len);

	char *codec = malloc(codec_len+1);
	memcpy(codec, buf+5, codec_len);

	codec[codec_len]='\0';

	printf("codec=%s\n", codec);

	int version_point_start=4+1+codec_len;


	a = buf[version_point_start+0];
	b = buf[version_point_start+1];
	c = buf[version_point_start+2];
	d = buf[version_point_start+3];

	printf("%d\n", (int)a);
	printf("%d\n", (int)b);
	printf("%d\n", (int)c);
	printf("%d\n", (int)d);

	unsigned int version = (unsigned int)a<<24;

	version += (unsigned int)b<<16;
	version += (unsigned int)c<<8;
	version += (unsigned int)d;

	printf("version=%x\n", version);

	readVInt(file_descriptor);*/
}



void test() {
	unsigned char x = 0b10000001;

	printf("%d\n", x);
}