#include <iostream>
#include <string>
#include <set>

using namespace std;

class Person {
public:
    Person(const string& firstname, const string& lastname):firstname_(firstname), lastname_(lastname) {
    }
    string firstname() const;
    string lastname() const;
    
private:
    string firstname_;
    string lastname_;
};

string Person::firstname() const{
    return firstname_;
}

string Person::lastname() const {
    return lastname_;
}

class PersonSortCriterion {
public:
    bool operator() (const Person& p1, const Person& p2) const {
        return p1.lastname() < p2.lastname() || (p1.lastname() == p2.lastname() && p1.firstname() < p2.firstname());
    }
};

int main() {
    set<Person, PersonSortCriterion> coll;
    Person person("leqin", "zhou");
    coll.insert(person);
    person = Person("shuna", "sun");
    coll.insert(person);
    
    for (auto pos = coll.begin(); pos != coll.end(); ++pos) {
        cout << pos->lastname() << endl;
    }
    return 0;
}
