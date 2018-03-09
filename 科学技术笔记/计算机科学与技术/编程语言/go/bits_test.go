package main

import (
    "testing"
)

func Test_bits2words_1(t *testing.T) {
    if  bits2words(6) != 1 { //try a unit test on function
        t.Error("计算n个位用几个long类型的整数表示测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("计算n个位用几个long类型的整数表示测试通过了") //记录一些你期望记录的信息
    }
}

func Test_bits2words_2(t *testing.T) {
    if  bits2words(65) != 2 { //try a unit test on function
        t.Error("计算n个位用几个long类型的整数表示测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("计算n个位用几个long类型的整数表示测试通过了") //记录一些你期望记录的信息
    }
}

func Test_NewFixedBitSet(t *testing.T) {
    fixedBitSet := NewFixedBitSet(10)

    if fixedBitSet.numBits != 10 {
        t.Error("FixedBitSet构造函数测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("FixedBitSet构造函数测试通过了") //记录一些你期望记录的信息
    }

    if fixedBitSet.numWords != 1 {
        t.Error("FixedBitSet构造函数测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("FixedBitSet构造函数测试通过了") //记录一些你期望记录的信息
    }
}

func Test_NewFixedBitSet_length(t *testing.T) {
    fixedBitSet := NewFixedBitSet(10)

    if fixedBitSet.length() != 10 {
        t.Error("FixedBitSet构造函数测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("FixedBitSet构造函数测试通过了") //记录一些你期望记录的信息
    }
}

func Test_NewFixedBitSet_set(t *testing.T) {
    fixedBitSet := NewFixedBitSet(10)

    var expected bool

    for i := 0; i < fixedBitSet.length(); i++ {
        fixedBitSet.set(uint(i))
        expected = fixedBitSet.get(uint(i))

        if expected != true {
            t.Error("FixedBitSet构造函数测试没通过") // 如果不是如预期的那么就报错
        } else {
            t.Log("FixedBitSet构造函数测试通过了") //记录一些你期望记录的信息
        }
    }
}

func Test_NewFixedBitSet_get(t *testing.T) {
    fixedBitSet := NewFixedBitSet(10)

    fixedBitSet.set(1)
    expected := fixedBitSet.get(1)

    if expected != true {
        t.Error("FixedBitSet构造函数测试没通过") // 如果不是如预期的那么就报错
    } else {
        t.Log("FixedBitSet构造函数测试通过了") //记录一些你期望记录的信息
    }
}