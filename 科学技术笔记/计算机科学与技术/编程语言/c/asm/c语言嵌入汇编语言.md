# gcc嵌入汇编语言

https://cs.brown.edu/courses/cs033/docs/guides/x64_cheatsheet.pdf


```
// Otherwise use gcc-format assembler to implement the underlying instructions.
#define GETCPUID(a, b, c, d, a_inp, c_inp) \
  asm("mov %%rbx, %%rdi\n"                 \
      "cpuid\n"                            \
      "xchg %%rdi, %%rbx\n"                \
      : "=a"(a), "=D"(b), "=c"(c), "=d"(d) \
      : "a"(a_inp), "2"(c_inp))
#endif
```

cpuinfo。a，b，c，d。四个整数的数组，包含在 EAX、EBX、ECX 和 EDX 中返回的有关 CPU 支持的功能的信息。

function_id。a_inp。在 EAX 中传递的指定要检索的信息的代码。

subfunction_id。c_inp。在 ECX 中传递的指定要检索的信息的附加代码。

当 function_id 参数为 0 时，cpuInfo[0] 将返回由处理器支持的最高可用非扩展 function_id。 处理器制造商在 cpuInfo[1]、cpuInfo[2] 和 cpuInfo[3] 中进行编码。

输出操作数

```
"=a"(a), "=D"(b), "=c"(c), "=d"(d)
```

```
[ [asmSymbolicName] ] constraint (cvariablename)
```

## constraint

```
"=a"
```

### 存储方式

https://gcc.gnu.org/onlinedocs/gcc/Modifiers.html#Modifiers

6.45.3.3 Constraint Modifier Characters

### 存储位置

https://gcc.gnu.org/onlinedocs/gcc/Machine-Constraints.html#Machine-Constraints

x86 family—config/i386/constraints.md

## cvariablename

```
(a)
```

a为c语言中的变量名

