class Bits
{
	public:
		virtual bool get(int index) = 0;
	private:
		int len;
};

class MutableBits : Bits
{
public:
	MutableBits();
	~MutableBits();

	virtual void clear(int index) = 0;

	/* data */
};

class BitSet
{
public:
	BitSet();
	~BitSet();

	virtual void set(int i) = 0;

	virtual void clear(int startIndex, int endIndex) = 0;

	virtual int cardinality() = 0;

	int approximateCardinality() {
	    return cardinality();
	}

	virtual int prevSetBit(int index) = 0;

	virtual int nextSetBit(int index) = 0;

	/* data */
};