#include <iostream>
#include <string>
#include <queue>
#include <map>

using namespace std;

struct Node{
    string value;
    Node * left;
    Node * right;
};

class DisjoinSets {
public:
    map<Node*, Node*> fatherMap;
    map<Node*, int> rankMap;
    
    DisjoinSets() {
    }
    
    void makeSets(Node *head) {
        fatherMap.clear();
        rankMap.clear();
        preOrderMake(head);
    }
    
    Node * findFather(Node *n) {
        Node *father = fatherMap.at(n);
        if (father != n) {
            father = findFather(father);
        }
        fatherMap.insert(std::pair<Node*, Node*>(n, father));//做压缩
        return father;
    }
    
    void unionSet(Node *a, Node *b) {
        if (a == nullptr || b == nullptr) {
            return;
        }
        Node * aFather = findFather(a);
        Node * bFather = findFather(b);
        
        if (aFather != bFather) {
            int aFatherRank = rankMap.at(aFather);
            int bFatherRank = rankMap.at(bFather);
            
            if (aFatherRank < bFatherRank) {
                fatherMap.insert(std::pair<Node *, Node *>(aFather, bFather));
            } else if (aFatherRank > bFatherRank) {
                fatherMap.insert(std::pair<Node *, Node *>(bFather, aFather));
            } else {
                fatherMap.insert(std::pair<Node *, Node *>(bFather, aFather));
                rankMap.insert(std::pair<Node *, int>(aFather, aFatherRank+1));
            }
        }
    }
    
private:
    void preOrderMake(Node *head) {
        if(head == nullptr) {
            return;
        }
        
        fatherMap.insert(std::pair<Node*, Node*>(head, head));
        rankMap.insert(std::pair<Node *, int>(head, 0));
        preOrderMake(head->left);
        preOrderMake(head->right);
    }
};

void printLevel(int level, string value) {
    for (int i=0; i < level; i++) {
        printf("-");
    }
    printf(" %s\n", value.c_str());
}

Node * reconstructTree(queue<string> &nodeValueQueue, int *level, Node **o1, Node **o2) {
    (*level)++;
    printLevel(*level, nodeValueQueue.front());
    if (nodeValueQueue.empty()) {
        (*level)--;
        return nullptr;
    }
    
    string nodeValue = nodeValueQueue.front();
    nodeValueQueue.pop();
    if (nodeValue == "#") {
        (*level)--;
        printLevel(*level, "");
        return nullptr;
    }//构造空节点
    
    Node *head = new Node;
    head->value = nodeValue;
    
    if (nodeValue == "6") {
        *o1 = head;
    }
    
    if (nodeValue == "8") {
        *o2 = head;
    }
    
    head->left = reconstructTree(nodeValueQueue, level, o1, o2);
    head->right = reconstructTree(nodeValueQueue, level, o1, o2);
    
    (*level)--;
    printLevel(*level, "");
    return head;
}

Node * lowestAncestor(Node * head, Node *o1, Node *o2) {
    if (head == nullptr || head == o1 || head == o2) {
        return head;
    }
    
    Node * left = lowestAncestor(head->left, o1, o2);
    Node * right = lowestAncestor(head->right, o1, o2);
    
    if (left !=nullptr && right != nullptr) {
        return head;
    }
    
    return left != nullptr ? left : right;
}

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    
    string treeStr = "1!2!4!#!#!5!#!#!3!6!#!#!7!8!#!#!#!";
    queue<string> nodeValueQueue;
    int start = 0;
    int len = 0;
    for (int i=0; i < treeStr.length(); i++) {
        if (treeStr.at(i) == '!') {
            string nodeValue = treeStr.substr(start, len);
            nodeValueQueue.push(nodeValue);
            start = i+1;
            len = 0;
            continue;
        }
        len++;
    }
    
    int level = 0;
    Node *o1 = nullptr;
    Node *o2 = nullptr;
    Node *head = reconstructTree(nodeValueQueue, &level, &o1, &o2);
    
    //printf("%s\n", head->value.c_str());
    Node * lowestAncestorNode = lowestAncestor(head, o1, o2);
    printf("lowestAncestor=%s\n", lowestAncestorNode->value.c_str());
    
    DisjoinSets disjoinSets;
    disjoinSets.makeSets(head);
    disjoinSets.unionSet(o1, o2);

    return 0;
}
