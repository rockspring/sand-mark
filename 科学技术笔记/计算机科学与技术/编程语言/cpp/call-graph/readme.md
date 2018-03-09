安装llvm

clang++ -S -emit-llvm main.cpp -o - | opt -analyze -dot-callgraph


dot -Tpng -ocallgraph.png callgraph.dot