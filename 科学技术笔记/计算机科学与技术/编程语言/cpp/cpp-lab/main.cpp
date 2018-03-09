#include <iostream>
#include <vector>

using namespace std;

/**
 * 本代码由九章算法编辑提供。没有版权欢迎转发。
 * - 九章算法致力于帮助更多中国人找到好的工作，教师团队均来自硅谷和国内的一线大公司在职工程师。
 * - 现有的面试培训课程包括：九章算法班，系统设计班，九章强化班，Java入门与基础算法班
 * - 更多详情请见官方网站：http://www.jiuzhang.com/
 */

bool cmp(pair<int,int>&x, pair<int, int>&y) {
    return x.first != y.first ? x.first < y.first : x.second > y.second;
}

class Solution {
public:
    //第一个值为宽度,第二个值为高度
    int maxEnvelopes(vector<pair<int, int>>& envelopes) {
        int n = static_cast<int>(envelopes.size());
        if (n == 0) {
            return 0;
        }

        sort(envelopes.begin(), envelopes.end(), cmp);
        vector<int> dp(n), height(n+1, INT_MAX);
        for (int i = 0; i < n; i++) {
            //lower_bound,依次从前往后找,直到第一个不小于当前值的元素就停止
            int k = static_cast<int>(lower_bound(height.begin(), height.end(), envelopes[i].second) - height.begin()) ;
            dp[i] = k;
            height[k] = envelopes[i].second;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = max(ans, dp[i]);
        }
        return ans + 1;
    }
};

int main() {
    vector<int> a(3, 3);
    a.push_back(4);
    long k = lower_bound(a.begin(), a.end(), 4) - a.begin();
    cout << "k=" << k << endl;

    vector<pair<int, int>> envelopes(3);
    envelopes.push_back(make_pair(1,1));
    envelopes.push_back(make_pair(1,2));
    Solution solution;
    int max = solution.maxEnvelopes(envelopes);
    cout << max << endl;
    return 0;
}