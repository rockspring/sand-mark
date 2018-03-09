using namespace std;

void max_heapify(int a[], int len, int i) {
    int leftIndex = 2*i;
    int rightIndex = 2*i + 1;
    
    int largest = a[i];
    int largestIndex = i;
    
    if (leftIndex<len &&  a[leftIndex] > largest) {
        largestIndex = leftIndex;
        largest = a[largestIndex];
    }
    
    if (rightIndex<len &&  a[rightIndex] > largest) {
        largestIndex = rightIndex;
        largest = a[largestIndex];
    }
    
    if (largestIndex != i) {
        // 需要交换
        a[largestIndex] = a[i];
        a[i] = largest;
        //交换了一个小的值，有可能违反原来的堆特性
        max_heapify(a, len, largestIndex);
    }
}

void build_max_heap(int a[], int len) {
    for (int i=len/2; i>=1; i--) {
        max_heapify(a, len, i);
    }
}

void heap_sort(int a[], int len) {
    build_max_heap(a, len);
    for (int i=len-1; i>=1; i--) {
        // 堆根的是最大值
        int largest = a[1];
        a[1] = a[i];
        a[i] = largest;
        // 堆结构被破坏了，调整
        max_heapify(a, i, 1);
    }
}

int main() {
    cout << "---build_max_heap---" << endl;
    int a[] = {0,4,1,3,2,16,9,10,14,8,7};
    build_max_heap(a, 11);
    for (int i=0; i<11; i++) {
        cout << a[i] << " ";
    }
    cout << endl;
    
    
    cout << "---heap_sort---" << endl;
    
    int b[] = {0,4,1,3,2,16,9,10,14,8,7};
    heap_sort(b, 11);
    for (int i=0; i<11; i++) {
        cout << b[i] << " ";
    }
    cout << endl;
    
    return 0;
}
