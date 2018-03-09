#include <typeinfo>
#include <iostream>
#include <vector>
#include <utility>

using namespace std;

class Matrix {
public:
    Matrix(int d);
    ~Matrix();
    Matrix(const Matrix& matrix);
    Matrix(Matrix&& matrix);
    Matrix& operator=(Matrix rhs);
    Matrix&& operator=(Matrix&& rhs);
    Matrix& operator+=(const Matrix& rhs);
    
    int *data;
};

Matrix::Matrix(int d) {
    data =new int;
    *data = d;
}

Matrix::~Matrix() {
    std::cout << "destroy " << data << endl;
    free(data);
}

Matrix::Matrix(const Matrix& matrix) {
    std::cout << "copy" << endl;
    this->data = new int;
    *(this->data) = *(matrix.data);
}

Matrix::Matrix(Matrix&& matrix) {
    std::cout << "move" << endl;
    this->data = matrix.data;
    matrix.data = nullptr;
}

Matrix& Matrix::operator=( Matrix rhs) {
    std::cout << "copy assignment" << endl;
    return *this;
}


Matrix&& Matrix::operator=(Matrix&& rhs) {
    std::cout << "move assignment" << endl;
    return std::move(*this);
}


Matrix& Matrix::operator+=(const Matrix& rhs)
{
    *this->data += *rhs.data;
    return *this;
}

Matrix                                     // by-value return
operator+(Matrix&& lhs, const Matrix& rhs)
{
    lhs += rhs;
    return std::move(lhs);             // move lhs into return value
    //return lhs;                        // copy lhs into return value
}

void testMove(Matrix&& matrix) {
    
}

void testCopy(Matrix matrix) {
    
}

void test() {
    Matrix matrix(1);
    std::cout << matrix.data << endl;
    const Matrix matrix2(2);
    std::cout << matrix2.data << endl;
    Matrix matrix3 = std::move(matrix) + matrix2;
    std::cout << matrix3.data << endl;
    //*matrix.data = 10;
}

void test1() {
    Matrix matrix(1);
    testMove(std::move(matrix));
    //testMove();
    testCopy(matrix);
}

int main() {
    //test();
    test1();
}
