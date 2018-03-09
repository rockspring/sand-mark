int main() {
    vector<int> v = {1, 2, 3, 5};
    int sum = accumulate(v.begin(), v.end(), 0, plus<int>{});
    cout << sum << endl;
    
    int product = accumulate(v.begin(), v.end(), 1, multiplies<int>{});
    cout << product << endl;
    
    return 0;
}
