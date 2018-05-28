## 用法

### expr expr1 : expr2

```
expr1 : expr2
     The ``:'' operator matches expr1 against expr2, which must be a basic regular expression.  The regular expression is anchored to the beginning of the string with an implicit ``^''.

     If the match succeeds and the pattern contains at least one regular expression subexpression ``\(...\)'', the string corresponding to ``\1'' is returned; otherwise the matching operator returns the number of characters matched.  If the match fails and the pattern
     contains a regular expression subexpression the null string is returned; otherwise 0.

Parentheses are used for grouping in the usual manner.
```

```
expr "lrwxr-xr-x  1 root  wheel  30  1 19 10:21 mysql -> mysql-5.7.21-macos10.13-x86_64" : '.* -> \(.*\)$'

```