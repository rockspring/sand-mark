
```
cat SourceFunction.txt | sed 's/()/_method/g' | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | awk -F "(" '{print $2,$1}' | sort -k 1 | grep -i -v test | grep -i -v ITCase | grep -i -v Anonymous
```