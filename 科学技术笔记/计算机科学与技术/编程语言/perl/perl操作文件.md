# perl脚本输出文件的内容

```
#!/usr/bin/perl
#print $ARGV[0]."\n";

open MYFILE, $ARGV[0];

my $contents;
while(<MYFILE>) {
   $contents .= "$_";
}
print $contents;
close JFILE;
```



# 子函数

## 获取参数个数

```
@_
```

```
sub sub_example() {
	print @_."\n"
}

&sub_example('a');
```
