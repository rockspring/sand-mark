# SIMD指令的应用

## 编译器针对各项SIMD指令的内置函数头文件

```
/*===---- xmmintrin.h - SSE intrinsics -------------------------------------===
/*===---- tmmintrin.h - SSSE3 intrinsics -----------------------------------===
/*===---- smmintrin.h - SSE4 intrinsics ------------------------------------===
/*===---- pmmintrin.h - SSE3 intrinsics ------------------------------------===
/*===---- nmmintrin.h - SSE4 intrinsics ------------------------------------===
/*===---- emmintrin.h - SSE2 intrinsics ------------------------------------===
/*===---- ammintrin.h - SSE4a intrinsics -----------------------------------===
```

```
/*===---- avx2intrin.h - AVX2 intrinsics -----------------------------------===
/*===---- avx512dqintrin.h - AVX512DQ intrinsics ---------------------------===
/*===---- avx512erintrin.h - AVX512ER intrinsics ---------------------------===
/*===---- avx512fintrin.h - AVX512F intrinsics -----------------------------===
/*===---- avx512vlbwintrin.h - AVX512VL and AVX512BW intrinsics ------------===
/*===---- avx512vlcdintrin.h - AVX512VL and AVX512CD intrinsics ---------------------------===
/*===---- avx512vldqintrin.h - AVX512VL and AVX512DQ intrinsics ------------===
/*===---- avx512vlintrin.h - AVX512VL intrinsics ---------------------------===
/*===---- avxintrin.h - AVX intrinsics -------------------------------------===
/*===------------- avx512bwintrin.h - AVX512BW intrinsics ------------------===
/*===------------- avx512cdintrin.h - AVX512CD intrinsics ------------------===
/*===------------- avx512ifmaintrin.h - IFMA intrinsics ------------------===
/*===------------- avx512ifmavlintrin.h - IFMA intrinsics ------------------===
/*===------------- avx512pfintrin.h - PF intrinsics ------------------===
/*===------------- avx512vbmiintrin.h - VBMI intrinsics ------------------===
/*===------------- avx512vbmivlintrin.h - VBMI intrinsics ------------------===
```

编程的时候引入如下头文件，这个文件会包含MMX、SSE、SSE2、SSE3、SSSE3、SSE4_1、SSE4_2、AVX、AVX2

```
/*===---- immintrin.h - Intel intrinsics -----------------------------------===
```

https://www.polyhedron.com/web_images/intel/productbriefs/3a_SIMD.pdf

https://llvm.org/devmtg/2014-10/Slides/Nis-AVX-512ArchPoster.pdf

https://software.intel.com/sites/landingpage/IntrinsicsGuide/

http://www.fizyka.umk.pl/~daras/mtm/26_IA32-1-sse.pdf

http://svmoore.pbworks.com/w/file/fetch/70583970/VectorOps.pdf

http://www.csd.uwo.ca/~moreno/cs3350_moreno/notes/simd_sse.pdf

http://www.engr.uconn.edu/~zshi/course/cse5302/student/mmx.pdf

https://computing.llnl.gov/tutorials/linux_clusters/intelAVXperformanceWhitePaper.pdf

https://passlab.github.io/CSE564/notes/lecture21_DLP_SIMDExtensionRoofline.pdf

https://software.intel.com/en-us/blogs/2013/avx-512-instructions

http://tech.sina.com.cn/roll/2017-11-14/doc-ifynrsrf4642801.shtml

http://tech.sina.com.cn/roll/2017-10-31/doc-ifynffnz3882146.shtml

https://www.zhihu.com/question/51649408

https://github.com/workhorsy/py-cpuinfo

https://cs.brown.edu/courses/cs033/docs/guides/x64_cheatsheet.pdf

https://www.intel.com/content/dam/www/public/us/en/documents/manuals/64-ia-32-architectures-software-developer-instruction-set-reference-manual-325383.pdf

https://db.in.tum.de/~finis/x86-intrin-cheatsheet-v2.2.pdf?lang=en

### Java调用native方法

http://barbie.uta.edu/~jli/Resources/Resource%20Provisoning&Performance%20Evaluation/85.pdf

http://cenalulu.github.io/linux/all-about-cpu-cache/

cat /sys/devices/system/cpu/cpu0/cache/index0/coherency_line_size

getconf LEVEL1_DCACHE_LINESIZE

一般是64

### AVX指令

256-bit vectors

```
/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/9.0.0/include/avxintrin.h
```

编程时包含immintrin.h

#### 数据类型

```__m256``` 表示一个单精度浮点数向量，存储8个单精度浮点数，占用256个比特。

#### 方法

```_mm256_set1_ps``` 构建一个单精度浮点数向量，存储8个单精度浮点数，占用256个比特，使用指定的浮点值初始化。

```__m256 _mm256_loadu_ps(float const *__p)``` 从__p指向的为对比的地址开始加载8个单精度浮点数到__m256中。

```__m256 _mm256_sub_ps(__m256 __a, __m256 __b)``` 向量__a减去向量__b，结果保存到__m256中。

```__m256 _mm256_mul_ps(__m256 __a, __m256 __b)``` 向量__a和向量__b元素一一对应相乘，结果保存到__m256中。

```__m256 _mm256_add_ps(__m256 __a, __m256 __b)``` 向量__a加上向量__b，结果保存到__m256中。

```_mm256_store_ps(float *__p, __m256 __a)``` 把单精度浮点数向量__a保存到__p指向的内存地址，这个地址指向的内存以32字节对齐。


#### 从256位抽取128位

```_mm256_extractf128_ps(V, M)``` 从256位的高12位或低128位抽取128位，构造一个新的__m128向量。如果M[0]比特位0，抽取bits [127:0]；如果如果M[0]比特位1，抽取bits [255:128]。

### 检测系统是否支持

使用如下宏检测是否支持256比特的AVX

```
#ifdef __AVX__
```

使用编译器的命令输出支持的宏

```
gcc -msse3 -dM -E - < /dev/null | egrep "SSE|AVX" | sort
clang -msse3 -dM -E - < /dev/null | egrep "SSE|AVX" | sort
gcc -dM -E - < /dev/null | egrep "SSE|AVX" | sort
gcc -march=knl -dM -E - < /dev/null | egrep "SSE|AVX" | sort
gcc -march=skylake-avx512 -dM -E - < /dev/null | egrep "SSE|AVX" | sort
for i in 4fmaps 4vnniw ifma vbmi vpopcntdq ; do echo "==== $i ====" ; gcc -mavx512$i -dM -E - < /dev/null | egrep "AVX512" | sort ; done
```

参考资料 https://stackoverflow.com/questions/28939652/how-to-detect-sse-avx-avx2-avx-512-availability-at-compile-time

### 128比特向量

```
/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/9.0.0/include/xmmintrin.h
```

以下头文件包含了乘积熔加指令

```
/Applications/Xcode.app/Contents/Developer/Toolchains/XcodeDefault.xctoolchain/usr/lib/clang/9.0.0/include/fmaintrin.h
```

#### 数据类型

ps -- packed single float
loadu -- load unaligned
set1 -- set replicate

```__m128``` 表示一个单精度浮点数向量，存储4个单精度浮点数，占用128个比特。

```_mm_set1_ps(float __w)``` 构建一个单精度浮点数向量，存储4个单精度浮点数，占用128个比特，使用指定的浮点值初始化。

```__m128 _mm_loadu_ps(const float *__p)```  从__p指向的为对比的地址开始加载8个单精度浮点数到__m128中。

```__m128 _mm_sub_ps(__m128 __a, __m128 __b)``` 向量__a减去向量__b，结果保存到__m128中。

```__m128 _mm_mul_ps(__m128 __a, __m128 __b)``` 向量__a和向量__b元素一一对应相乘，结果保存到__m128中。

```__m128 _mm_add_ps(__m128 __a, __m128 __b)``` 向量__a加上向量__b，结果保存到__m256中。

```_mm_store_ps(float *__p, __m128 __a)```  把单精度浮点数向量__a保存到__p指向的内存地址，这个地址指向的内存以16字节对齐。





