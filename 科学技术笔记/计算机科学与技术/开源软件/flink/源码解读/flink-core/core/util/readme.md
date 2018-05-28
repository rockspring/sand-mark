
```
cat AbstractID.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep runtime
cat AbstractID.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep -v runtime


cat Collector.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep flink.runtime
cat Collector.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep runtime | grep -v flink.runtime | grep table
cat Collector.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep runtime | grep -v flink.runtime | grep streaming

cat Collector.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep -v runtime

cat MutableObjectIterator.txt | sed 's/()/_method/g' | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | awk -F "(" '{print $2,$1}' | sort -k 1 | grep -i -v test | grep -i -v ITCase | grep -i -v Anonymous
```