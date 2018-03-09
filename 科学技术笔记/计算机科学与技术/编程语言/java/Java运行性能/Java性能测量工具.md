# java性能研究

https://docs.oracle.com/javase/8/docs/platform/jvmti/jvmti.html

http://www.brendangregg.com/flamegraphs.html

http://jeremymanson.blogspot.hk/2010/07/why-many-profilers-have-serious.html

http://www.brendangregg.com/blog/2014-06-12/java-flame-graphs.html

```
perf stat -a -d sleep 10

apt install linux-tools-common
apt-get install linux-tools-4.4.0-98-generic linux-cloud-tools-4.4.0-98-generic linux-tools-generic linux-cloud-tools-generic

perf report -n --stdio

apt install systemtap-sdt-dev
```

http://www.brendangregg.com/index.html

https://github.com/jvm-profiling-tools/perf-map-agent

http://www.brendangregg.com/Slides/JavaOne2016_JavaFlameGraphs.pdf