#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>

using namespace std;

bool building_height_cmp_func(tuple<int, int> one, tuple<int, int> another) {
    if (std::get<0>(one) < std::get<0>(another)) {
        return true;
    } else {
        return false;
    }
}

bool getSkyline(int buildings[][3], int len, int result[][2], int *result_len) {
    if(len < 0) {
        return false;
    }
    
    int* positions = new int[len*2];
    int j = 0;
    for(int i=0; i< len; ++i) {
        positions[j++] = buildings[i][0];
    }
    for(int i=0; i< len; ++i) {
        positions[j++] = buildings[i][1];
    }
    std::sort(positions, positions+len*2);
    // 依次处理每个可能作为轮廓线转角点的位置
    int k = 0;
    int result_index = 0;
    std::vector<tuple<int, int>> heap_vector(0);
    std::make_heap(heap_vector.begin(), heap_vector.end(), building_height_cmp_func);
    
    for(int i = 0; i < len * 2; ++i) {
        int position = positions[i];
        // 处理建筑起始坐标在当前观测坐标点之前的建筑
        while(k < len && buildings[k][0] <= position) {
            heap_vector.push_back(std::make_tuple(buildings[k][2], buildings[k][1]));
            std::push_heap(heap_vector.begin(), heap_vector.end(), building_height_cmp_func);
            k++;
        }
        //处理建筑结束坐标在当前观测坐标点之前的建筑，从heap中剔除
        while (!heap_vector.empty() && std::get<1>(heap_vector.front()) <= position) {
            std::pop_heap(heap_vector.begin(), heap_vector.end(), building_height_cmp_func);
            heap_vector.pop_back();
        }
        // 取得当前观测点的轮廓转角
        int height = 0;
        if (!heap_vector.empty()) {
            height = std::get<0>(heap_vector.front());
        }
        if (result_index ==0 || result[result_index-1][1] != height ) {
            result[result_index][0] = position;
            result[result_index++][1] = height;
        }
    }
    *result_len = result_index;
    return true;
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    int buildings[][3] = {
        {2,9,10},
        {3,7,15},
        {5,12,12},
        {15,20,10},
        {19,24,8}};
    int building_len = 5;
    int result_len = 0;
    
    int (*result)[2] = new int[building_len*2][2];
    getSkyline(buildings, building_len, result, &result_len);
    
    for(int i = 0; i< result_len; ++i) {
        cout << result[i][0] << ", " << result[i][1] << endl;
    }
    return 0;
}
