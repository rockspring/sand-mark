
```
cat DataInputView.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep runtime
cat DataInputView.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep -v runtime


cat DataOutputView.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep runtime
cat DataOutputView.txt | tr ')' '\n' | awk '{print $1,$2,$3,$4,$5,$6}' | grep -v runtime
```