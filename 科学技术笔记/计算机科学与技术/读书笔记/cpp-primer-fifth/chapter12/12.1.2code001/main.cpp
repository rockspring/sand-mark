#include <iostream>
#include <vector>
#include <new>

using namespace std;

int main() {
    int *pi = new int;
    string *ps = new string;
    cout << *pi << endl;
    cout << *ps << endl;

    {
        int *pi = new int(1024);
        string *ps = new string(10, '9');

        vector<int> *pv = new vector<int>{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        cout << *pi << endl;
        cout << *ps << endl;
        cout << pv->front() << endl;
    }

    {
        string *ps1 = new string;
        string *ps = new string();
        int *pi1 = new int;
        int *pi2 = new int();
    }

    {
        auto p1 = new auto("abc");

        cout << *p1 << endl;
    }

    {
        const int *pci = new const int(1024);
        const string *pcs = new const string;

        cout << "pci=" << *pci << endl;
    }

    {
        int *p1 = new int;
        int *p2 = new (nothrow) int;
    }

    {
        int i, *pi1 = &i, *pi2 = nullptr;
        double *pd = new double(33), *pd2 = pd;
        //delete i;
        //delete pi1;
        delete pd;
        //delete pd2;
        delete pi2;
    }

    {
        const int *pci = new const int(1024);
        delete pci;
    }

    {
        class Foo {};

        Foo *fp = new Foo();
    }

    return 0;
}