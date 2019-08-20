### **Java中错误与异常机制**

​        Java中有两种出错的情况：异常（Exception）和错误（Error），它们都是继承于Throwable 父类。

​         **Error（错误）**：一般是和java虚拟机相关的问题，比如系统崩溃、虚拟机出错、动态链接失败等，这些错误应用程序提前是不知道的，只有程序运行出错了才能处理

​         **Exception：**Exception类及其子类是Throwable的一种形式，它指出了合理的应用程序想要捕获的条件

-    SQLException：该异常提供关于数据库访问错误或其他错误的信息。
-    RuntimeException 是那些可能在 Java 虚拟机正常运行期间抛出的异常的超类
-    IOException：此类为异常的通用类，它是由失败的或中断的 I/O 操作生成的。

![](C:\Users\Qi\Desktop\yichang.gif)

```java
在类实例化时运行	
static String str = "test";  //
static {                     //静态块
		System.out.println("hello");
	}	
```

#### 1. 错误

```
Java中常见的代码错误
private Student stu = new Student();
          属性        不能new自己的对象 
```



#### **2. 异常机制**

Java的异常分为checked异常（编译时异常）和Runtime异常（运行时异常）两种。

Java异常机制主要依赖于try、catch、finally、throw、throws五个关键字。

```
异常对象包含的常用方法：
getMessage（）；返回该异常的详细描述字符
printStackTrace（）：将该异常的跟踪栈信息输出到标准错误输出。
printStackTrace（PrintStream s）：将该异常的跟踪栈信息输出到指定的输出流
getStackTrace（）：返回该异常的跟踪栈信息。
```



```java
错误和异常的例子：
public class Student {
	String name;
	int score;
	public void setScore(int score) throws ScoreException {//抛出异常用throws
		if(score < 0) {	
			throw new ScoreException("成绩不能为负数"); //抛出具体的异常，用throw
		}
		this.score = score;
	}
	public int study() throws ScoreException {
		try {                         //try正确才运行后面内容，否则直接跳转到catch里
			if(name.equals("张三")) {
			}
			score++;
			return score;
		} catch (Exception ex) {        //处理Exception后，抛出新的异常
			ex.printStackTrace(); 
//			throw new ScoreException(ex.getMessage());
		} catch (Throwable t) {         //catch的内容可以注释，直接运行finally
			t.printStackTrace();
		} finally {         //不管出没出错，finally代码始终被执行，可用来回收资源
			System.out.println("finally");
		}
		System.out.println("学习中。。。");  //若错误异常被抛出，下面的代码不执行
		return score;
	}

	public static void main(String[] args) throws ScoreException {
		Student stu = new Student();
		stu.name = "test";
		int score = stu.study();
		System.out.println("score="+score);
//		try {
//			stu.setScore(-10);
//		} catch (ScoreException e) {	
//			e.printStackTrace();
//		}
		try {
			new Student().study();
		} catch(Error err) {
			System.out.println(err.toString());//打印错误信息
       		err.printStackTrace();   //打印错误堆栈，可输出到文件
		}
	}
///另外一个类    
    public class ScoreException extends Exception {
	public ScoreException(String str) {
		super(str);
	}
}
}

```

