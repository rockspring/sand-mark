#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int maxRecFromBotton(int height[], int len) {
    if (height == nullptr || len == 0) {
        return 0;
    }
    
    int maxArea = 0;
    stack<int> stack;
    
    for (int i=0; i<len; i++) {
        while (!stack.empty() && height[i] <= height[stack.top()]) {
            int j = stack.top();
            stack.pop();
            int k = stack.empty() ? -1 : stack.top();
            int curArea = (i - k - 1) * height[j];
            maxArea = max(maxArea, curArea);
        }
        
        stack.push(i);
    }
    
    while (!stack.empty()) {
        int j = stack.top();
        stack.pop();
        int k = stack.empty() ? -1 : stack.top();
        int curArea = (len - k - 1) * height[j];
        maxArea = max(maxArea, curArea);
    }
    
    return maxArea;
}


int maxRecSize(vector<vector<int>> &map) {
    if (map.size() == 0 || map.at(0).size() == 0) {
        return 0;
    }
    
    int maxArea = 0;
    int height[map.at(0).size()];
    for (int i=0; i<sizeof(height)/sizeof(int); i++) {
        height[i] =0;
    }
    for (int i=0; i<map.size(); i++) {
        for (int j=0; j<map.size(); j++) {
            height[j] = map.at(i).at(j) == 0 ? 0 : height[j] + 1;
        }
        maxArea = maxRecFromBotton(height, sizeof(height)/sizeof(int));
    }
    
    return maxArea;
}


int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    vector<int> line1 = {1, 0, 1, 1};
    vector<int> line2 = {1, 1, 1, 1};
    vector<int> line3 = {1, 1, 1, 0};
    
    vector<vector<int>> map = {line1, line2, line3};
    
    int maxAreaSize = maxRecSize(map);
    
    cout << "maxArea=" << maxAreaSize << endl;
    
    return 0;
}
