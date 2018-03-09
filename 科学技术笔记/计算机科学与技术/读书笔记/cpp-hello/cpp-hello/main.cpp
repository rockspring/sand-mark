//
//  main.cpp
//  cpp-hello
//
//  Created by zlq on 4/19/16.
//  Copyright © 2016 zlq. All rights reserved.
//

#include <iostream>

//#include <folly/futures/Future.h>
//#include <boost/utility.hpp>
//using namespace folly;
using namespace std;

namespace {
    void foo(int x) {
        // do something with x
        ::cout << "foo(" << x << ")" << endl;
    }
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    int32_t a = 100;
    int64_t b = (int64_t)a;
    std::cout << b;
    foo(1);
    
    /*cout << "making Promise" << endl;
     Promise<int> p;
     Future<int> f = p.getFuture();
     f.then(foo);
     cout << "Future chain made" << endl;
     
     // ... now perhaps in another event callback
     
     cout << "fulfilling Promise" << endl;
     p.setValue(42);
     cout << "Promise fulfilled" << endl;*/
    return 0;
}

