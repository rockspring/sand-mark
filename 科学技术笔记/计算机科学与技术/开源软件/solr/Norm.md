字段：title

# metadata
format 6
offset 43
count 886874
#nested
	format 4
	offset 221770
	count 3508
	#nested
		format 1
		offset 229683
		count 3508
		null

PATCHED_TABLE

# data

# offset 43

packedIntsVersion VInt 2
formatID VInt 1
bitsPerValue VInt 2
=>size=2^bitsPerValue
ordsSize VInt 3
#循环出现ordsSize次如下数据
decode[0] Byte 114
decode[1] Byte 115
decode[2] Byte 116

接下来是PackedInts格式的数据，通过如下方法获取读取器对象
public static Reader getReaderNoHeader(DataInput in, Format format, int version,
      int valueCount, int bitsPerValue)