---
layout: post
title:  "WebSocket探究与应用"
categories: JavaScript
tags:  WebSocket 通信 协议
---

* content
{:toc}
### 数据类型

一个byte是8个二进制位，下面数字表示用了几个字节

char  2   note：Java中char 的字节数是根据字符集编码，默认的编码是Unicode，所以是2个字节，若用UTF8编码，英文1个字节，中文大多是3个字节，

int   4

String 是对象引用类型，字节数根据引用对象的字节

#### 包装类型

基本类型都有包装类型，他们之间的转换通过**自动装箱和拆箱**来实现



缓存池

new Integer（123）、 Integer.valueOf(123)的区别

new Integer（123）每次都会新建对象

 Integer.valueOf(123) 会使用缓存池的对象，多次调用时同一对象的地址引用

Integer 缓存池的大小默认为 -128~127。

## 参数传递

Java 的参数是**以值传递的形式**传入方法中，而不是引用传递。

以下代码中 Dog dog 的 dog 是一个**指针**，存储的是对象的地址。在将一个参数传入一个方法时，本质上是将**对象的地址以值的方式传递到形参**中。因此在方法中使指针引用其它对象，那么这两个指针此时指向的是完全不同的对象，在一方改变其所指向对象的内容时对另一方没有影响。

Java方法传递的是**指向地址的指针**，在方法体中 如果 new 了一个同名的对象，那指针就指向new的这个对象，如果在方法体内，这个地址下的内容改变了 如set（），那其他地方也会发生改变。



##### String 

是final类型，不可继承，实现是通过byte数组。

为什么要定义成final，有3点原因：

1.String类型经常要用hash值，final不可变，hash值也不可变

2.String类型在调用对象时，是从String pool中获取的，值不变，才能从Pool中获取得到

3.安全性，可以保证String定义的参数不可改变，比如在网络通信是，主机的IP地址用String保证不会连接到错误的主机上去。不可变的是**线程安全**



##### String，StringBuffer，StringBuild的区别?

- String不可变，

- StringBuffer，StringBuild可变

#### 字符串字面量

字符串**字面量**：String=  “ Hello world”，引号中的就是 字符串字面量，

字符串创建后不可改变（除了反射），会放在String pool中

**Note:**String pool（字符串常量池）：是用来放字符串对象**引用**的容器, Java中所有对象都用**堆**，包括字符串。

字符串的Intern（）方法，比如 str=“ Hello world”，它先看String pool有没有字符串“ Hello world”，没有就创建把看引用的字符串放到String pool中，返回的是字符串的引用；

```java
String s1 = new String("aaa");
String s2 = new String("aaa");
System.out.println(s1 == s2);           // false
如果采用new的方式，会创建对象，所以不一样
String s3 = s1.intern();
String s4 = s1.intern();
System.out.println(s3 == s4);           // true
Intern（）返回的是String pool中的引用，所以是一样的

String s5 = "bbb";
String s6 = "bbb";
System.out.println(s5 == s6);  // true
"bbb"属于字符串字面量，会自动地将字符串放入 String Pool 中，所以用的是同一个引用

new（ "bbb"）；
"bbb"会创建一个对象，放在String Pool，new会创建一个对象，所以这句话会有创建两个对象
```



## 继承

子类继承父类，可以使用父类的属性，方法，关键字是extend

子类可以重写父类的方法（over）

提到继承，有一些重要的访问修饰符，规定访问的权限：public， 不写，protected，  private

- private只在此类中可见，

- protected在继承类中（子类）可见：子类的的访问权限要不小于父类的访问权限，为了保证使用父类实例的地方要能使用子类的实例。
- 不加访问修饰符，表示包级可见
- public是任何地方都能使用

字段不能是公有的，若别的类想要调用公共的字段，使用setter和getter方法传递



### 抽象类和接口

#### 1.抽象类

抽象类和抽象方法用关键字abstract声明；抽象方法不写方法体，若类中有抽象方法，那类一定要声明成抽象类；抽象类最大的特点是不能实例化，必须通过子类继承抽象类来实例化。

#### 2.接口

接口类只定义方法名，不写方法体。具体的方法实现放在implement接口的类中，Java自带的接口有：Listener，MouseAction（）等

接口的成员（字段方法统称成员）必须是public，字段必须是static（只有一个对象）、final（不可改变）

**Note：**里氏替换原则，父类的对象全都可以替换成子类的对象。

**抽象类和接口的区别：**

1.类只能继承一个抽象类，可以实现多个接口

2.类的字段可以是多种访问类型，接口的字段只能是static和final

### super

- 调用父类的成员，比如 子类重写(override)了父类的方法，调用父类的方法用super，

- 调用父类的构造方法，完成初始化的工作，note：子类默认调用父类的不带参的构造方法，若调用带参的构造方法用super

### 重写（override）和重载（overload）

**重写**

发生在继承体系中（继承，接口），子类实现了与父类声明一样的方法（方法的参数个数和类型一样），唯一不同的是方法体（和返回值）

要求：子类方法访问权限要大于父类，可使用 @Override让编译器负责检查注解

**重载（overload）**

返回值不同，其它都相同不算是重载。

**equals（）和 ==**

==判断两个变量**是否为同一对象**，equals判断对象的**值是否等价**

























Java程序运行的过程

加载， 初始化



equals 

