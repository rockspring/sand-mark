# Google C++ Test

https://github.com/google/googletest

独立性和可重复性

组织良好，反映被测试代码的结构

可移植性和可重用性

测试失败、失败信息丰富

单测试失败，其他测试继续

自动运行测试

速度快


# 基本概念

## 断言

成功

非致命性失败

致命性失败

一旦出现这种失败，终止该函数

## 测试

使用断言验证被测试代码的行为

## 测试场景（case）

包含多个测试

多个测试组织成一个测试场景，反映被测试代码的结构

## 测试程序

包含多个测试场景

# 断言

组装函数调用的宏

断言成对出现，ASSERT_*失败时，产生致命错误，终止测试函数，EXPECT_*失败时产生非致命性错误，函数继续执行


## 基本断言

ASSERT_TRUE(condition);

EXPECT_TRUE(condition);

ASSERT_FALSE(condition);

EXPECT_FALSE(condition);

## 二元比较

Fatal	assertion	Nonfatal	assertion	Verifies
ASSERT_EQ(expected, actual);	EXPECT_EQ(expected, actual);	expected == actual
ASSERT_NE(val1, val2);	EXPECT_NE(val1, val2);	val1 != val2
ASSERT_LT(val1, val2);	EXPECT_LT(val1, val2);	val1 < val2
ASSERT_LE(val1, val2);	EXPECT_LE(val1, val2);	val1 <= val2
ASSERT_GT(val1, val2);	EXPECT_GT(val1, val2);	val1 > val2
ASSERT_GE(val1, val2);	EXPECT_GE(val1, val2);	val1 >= val2

## 字符串比较

Fatal	assertion	Nonfatal	assertion	Verifies
ASSERT_STREQ(expected_str, actual_str);	EXPECT_STREQ(expected_str, actual_str);	the two C strings have the same content
ASSERT_STRNE(str1, str2);	EXPECT_STRNE(str1, str2);	the two C strings have different content
ASSERT_STRCASEEQ(expected_str, actual_str);	EXPECT_STRCASEEQ(expected_str, actual_str);	the two C strings have the same content, ignoring case
ASSERT_STRCASENE(str1, str2);	EXPECT_STRCASENE(str1, str2);	the two C strings have different content, ignoring case

# 简单测试

使用TEST()宏定义和命名一个测试

```
TEST(test_case_name, test_name) {
 ... test body ...
}

int Factorial(int n); // Returns the factorial of n

// Tests factorial of 0.
TEST(FactorialTest, HandlesZeroInput) {
  EXPECT_EQ(1, Factorial(0));
}

```

# 测试夹具

多个测试使用同样的数据配置

## 如何创建一个测试夹具

继承::testing::Test创建一个类

在类里定义任何想要的数据

如果有必要，编写SetUp()方法为每次测试创建对象

如果有必要，编写TearDown()方法为每次测试回收SetUp()方法中分配的资源

如果有必要，定义可重用的方法


## 如何使用一个测试夹具

使用TEST_F()定义测试，第一个参数为测试夹具类的名称

```
TEST_F(test_case_name, test_name) {
 ... test body ...
}
```

## 如何运作

TEST_F()中定义的每个测试，

创建一个全新的测试夹具

调用SetUp()方法初始化对象

运行测试

调用TearDown()方法销毁对象

删除测试夹具

# 如何调用测试

使用宏RUN_ALL_TESTS()调用所有测试