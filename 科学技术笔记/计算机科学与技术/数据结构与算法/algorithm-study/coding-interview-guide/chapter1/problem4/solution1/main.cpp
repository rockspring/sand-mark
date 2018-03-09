#include <iostream>
#include <string>
#include <queue>

using namespace std;

class Pet {
public:
    Pet(string type) {
        this->type = type;
    }
    
    string getPetType() {
        return type;
    }
    
private:
    string type;
};

class Dog : public Pet {
public:
    Dog():Pet("dog") {
    }
};

class Cat : public Pet {
public:
    Cat():Pet("cat") {
    }
};

class PetEnterQueue {
public:
    PetEnterQueue(Pet *pet, long count):pet(pet), count(count) {
    }
    
    Pet * getPet() {
        return pet;
    }
    
    long getCount() {
        return count;
    }
    
    string getEnterPetType() {
        return pet->getPetType();
    }
private:
    Pet *pet;
    long count;
};

class DogCatQueue {
public:
    void add(Pet *pet) {
        if (pet->getPetType() == "dog") {
            dogQueue.push(PetEnterQueue(pet, count++));
        } else if (pet->getPetType() == "cat") {
            catQueue.push(PetEnterQueue(pet, count++));
        } else {
            throw exception();
        }
    }
    
    Pet * pollAll() {
        if (!dogQueue.empty() && !catQueue.empty()) {
            if (dogQueue.front().getCount() < catQueue.front().getCount()) {
                PetEnterQueue  enterPet = dogQueue.front();
                dogQueue.pop();
                return enterPet.getPet();
            } else {
                PetEnterQueue  enterPet = catQueue.front();
                catQueue.pop();
                return enterPet.getPet();
            }
        } else if (!dogQueue.empty()) {
            PetEnterQueue  enterPet = dogQueue.front();
            dogQueue.pop();
            return enterPet.getPet();
        } else if (!catQueue.empty()) {
            PetEnterQueue  enterPet = catQueue.front();
            catQueue.pop();
            return enterPet.getPet();
        } else {
            throw exception();
        }
    }
    
    Dog * pollDog() {
        if (!dogQueue.empty()) {
            PetEnterQueue  enterPet = dogQueue.front();
            dogQueue.pop();
            return (Dog *)enterPet.getPet();
        }else {
            throw exception();
        }
    }
    
    Cat * pollCat() {
        if (!catQueue.empty()) {
            PetEnterQueue  enterPet = catQueue.front();
            catQueue.pop();
            return (Cat *)enterPet.getPet();
        }else {
            throw exception();
        }
    }
    
    bool isEmpty() {
        return dogQueue.empty() && catQueue.empty();
    }
    
    bool isDogQueueEmpty() {
        return dogQueue.empty();
    }
    
    bool isCatQueueEmpty() {
        return catQueue.empty();
    }
private:
    queue<PetEnterQueue> dogQueue;
    queue<PetEnterQueue> catQueue;
    long count;//分配一个ID，后到的id比先到的id大，就实现了先后次序
};

int main() {
    cout << "sizeof(int)=" << sizeof(int) << endl;
    
    DogCatQueue dogCatQueue;
    dogCatQueue.add(new Dog());
    dogCatQueue.add(new Dog());
    dogCatQueue.add(new Cat());
    
    Dog * dog = dogCatQueue.pollDog();
    cout << dog->getPetType() << endl;

    return 0;
}
