#include <iostream>
#include <vector>
#include <stack>
#include <map>

using namespace std;

class Node {
public:
    int value;
    shared_ptr<Node> left;
    shared_ptr<Node> right;
    
    Node() {
    }
    
    Node(int data):value(data){
        //this->value = data;
    }
};

bool operator<(const shared_ptr<Node>& left, const shared_ptr<Node>& right){
    return left->value < right->value;
}

shared_ptr<Node> getMaxTree(int arr[], int len) {
    vector<shared_ptr<Node>> nArr;
    for (int i=0; i < len; i++) {
        nArr.push_back(make_shared<Node>(Node(arr[i])));
    }
    stack<shared_ptr<Node>> workStack;
    
    map<shared_ptr<Node>, shared_ptr<Node>> leftMaxMap;
    map<shared_ptr<Node>, shared_ptr<Node>> rightMaxMap;
    
    for (int i=0; i < nArr.size(); i++) {
        shared_ptr<Node> curNode = nArr.at(i);
        
        while (!workStack.empty()) {
            if (curNode->value < workStack.top()->value) {
                //workStack.push(curNode);
                break;
            } else {
                shared_ptr<Node> key = workStack.top();
                workStack.pop();
                if (workStack.empty()) {
                    leftMaxMap[key] = nullptr;
                } else {
                    shared_ptr<Node> value = workStack.top();
                    leftMaxMap[key] = value;
                }
            }
        }
        workStack.push(curNode);
    }
    
    while (!workStack.empty()) {
        shared_ptr<Node> key = workStack.top();
        workStack.pop();
        if (workStack.empty()) {
            leftMaxMap[key] = nullptr;
        } else {
            shared_ptr<Node> value = workStack.top();
            leftMaxMap[key] = value;
        }
    }
    
    for (map<shared_ptr<Node>, shared_ptr<Node>>::iterator iter = leftMaxMap.begin(); iter != leftMaxMap.end(); iter++) {
        shared_ptr<Node> key = iter->first;
        shared_ptr<Node> value = iter->second;
        if (value != nullptr) {
            cout << key->value << "->" << value->value << endl;
        } else {
            cout << key->value << "-> nullptr" << endl;
        }
    }
    cout << "..." << endl;

    
    //右边第一个最大值
    for (int i = nArr.size()-1; i >=0; i--) {
        shared_ptr<Node> curNode = nArr.at(i);
        
        while (!workStack.empty()) {
            if (curNode->value < workStack.top()->value) {
                //workStack.push(curNode);
                break;
            } else {
                shared_ptr<Node> key = workStack.top();
                workStack.pop();
                if (workStack.empty()) {
                    rightMaxMap[key] = nullptr;
                } else {
                    shared_ptr<Node> value = workStack.top();
                    rightMaxMap[key] = value;
                }
            }
        }
        workStack.push(curNode);
    }
    
    while (!workStack.empty()) {
        shared_ptr<Node> key = workStack.top();
        workStack.pop();
        if (workStack.empty()) {
            rightMaxMap[key] = nullptr;
        } else {
            shared_ptr<Node> value = workStack.top();
            rightMaxMap[key] = value;
        }
    }
    //打印
    for (map<shared_ptr<Node>, shared_ptr<Node>>::iterator iter = rightMaxMap.begin(); iter != rightMaxMap.end(); iter++) {
        shared_ptr<Node> key = iter->first;
        shared_ptr<Node> value = iter->second;
        if (value != nullptr) {
            cout << key->value << "->" << value->value << endl;
        } else {
            cout << key->value << "-> nullptr" << endl;
        }
    }
    cout << "..." << endl;
    
    shared_ptr<Node> head = nullptr;
    for (int i=0; i < nArr.size(); i++) {
        shared_ptr<Node> curNode = nArr.at(i);
        shared_ptr<Node> leftMax;
        try {
            leftMax = leftMaxMap.at(curNode);
        } catch (exception e) {
            leftMax = nullptr;
        }
        shared_ptr<Node> rightMax;
        try {
            rightMax = rightMaxMap.at(curNode);
        } catch (exception e) {
            rightMax = nullptr;
        }
        
        if (leftMax == nullptr && rightMax == nullptr) {
            head = curNode;
        } else if (leftMax == nullptr) {
            if (rightMax->left ==nullptr) {
                rightMax->left = curNode;
            } else {
                rightMax->right = curNode;
            }
        } else if (rightMax == nullptr) {
            if (leftMax->left == nullptr) {
                leftMax->left = curNode;
            } else {
                leftMax->right = curNode;
            }
        } else {
            shared_ptr<Node> parent = (leftMax->value < rightMax->value) ? leftMax : rightMax;
            if (parent->left ==nullptr) {
                parent->left = curNode;
            } else {
                parent->right = curNode;
            }
        }
    }
    
    return head;
    
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    int arr[] = {3, 4, 5, 1, 2};
    //Node node;
    vector<shared_ptr<Node>> nArr;
    make_shared<Node>(Node(1));
    map<shared_ptr<Node>, shared_ptr<Node>> leftMaxMap;
    shared_ptr<Node> head = getMaxTree(arr, sizeof(arr)/sizeof(int));
    Node node;

    return 0;
}
