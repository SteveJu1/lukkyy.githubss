---
layout:     post
title:      "Java 中的IO流（Stream） "
date:       2016-12-16 
categories: Java
tags: Java 
---

​      在Java中按照读取/输出数据的长度可以分为字节流和字符流，字节流是按照一个字节一个字节的读取的；字符流是按照字符读取的，在Java中字节是8bit，字符的长度中文是两个字节，英文是一个字节。







常用到的流有以下几种，字符流有：FileReader，InputStreamReader，BufferReader 等

字节流有：FileInputStream，DataInputStream，ByteArrayInputStream，BufferedIutputSteam，printStream 等，下面画了Java中流的继承关系图。

![](https://lukkyy.github.io/assets/java/basic/IO流.png)

（通过API文档统计的所有IO流，有些流不是输入输出流都有。知道原因的麻烦告诉我哈）

为什么有这么多种Stream的类型呢？每种Stream的类型能调用的方法都不一样，根据不同的需要调用不同类型的Stream。

下面记录了一些用到过得IO流，方便理解

```java
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;

public class IOStream {
	//字符流
	public void ReaderWriter throws Exception {
//		FileReader fr = new FileReader(file);
//		int c = fr.read();
//		while(c != -1) {
//			System.out.print((char)c);
//			c = fr.read();
//		}
//		fr.close();
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis, "gbk");
		BufferedReader bufferedReader = new BufferedReader(isr);
		
		String line = bufferedReader.readLine();//读取一行内容
		while(line != null) {
			System.out.println(line);
			line = bufferedReader.readLine();
		}
		bufferedReader.close();
		isr.close();
		fis.close();
	}
	
	//数据流
	public void testDataStream() throws Exception {
		FileInputStream fis = new FileInputStream("D:/1.txt");
		DataInputStream dataInputStream = new DataInputStream(fis);
		
		//从流中读取我们想要的数字
		int n = dataInputStream.readInt();
		dataInputStream.readLong();
		dataInputStream.readLine();
		
		byte[] buffer = new byte[1024]; 
		//不一定能填满
		dataInputStream.read(buffer);
		
		//字节数组流：字节和流之间做转换的
		byte[] recvBytes = new byte[2048];
		//把字节转成了留
		ByteArrayInputStream bis = new ByteArrayInputStream(recvBytes);
		//把字节流封装成数据流
		DataInputStream dis = new DataInputStream(bis);
		int type = dis.readInt();
		int x1 = dis.readInt();
		int y1 = dis.readInt();
		
		//发送
		//创建一个字节数组输出流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		//封装成数据输出流
		DataOutputStream dos = new DataOutputStream(bos);
		int xx1=200,yy1=300,type2=1;
		dos.writeInt(type2);
		dos.writeInt(xx1);
		dos.writeInt(yy1);
		//....
		//提取我们要发送的数据
		byte[] sendBytes = bos.toByteArray();
	
		//填满buffer
		dataInputStream.readFully(buffer);		
		dataInputStream.close();
		fis.close();
	}
	
	public void test() throws Exception {
		Dog dog = new Dog();
		dog.name = "凯撒机房网络";
		dog.height = 123;
	
		FileOutputStream fos = new FileOutputStream("/Doc/obj.dat",false);
		ObjectOutputStream os = new ObjectOutputStream(fos);
		os.writeObject(dog);
		os.close();
		fos.close();
	}

	public static void main(String[] args) throws Exception {
		Test t = new Test();	
		t.test();
	}

}

```

## **Java中File操作与File流**

###   一 、File

   Java中的File对象代表的是电脑中实际存在的**文件和目录**。

​    File对象创建成功后，可以使用方法操作文件,

```java
例如:
  File fileExample = new File ();
  File[] files = fileExample.listFiles(); //若File对象是目录，可获取目录下的所有文件和目录
  System.out.println(fileExample.getAbsolutePath()); 
  if(fileExample.isDirectory()){
  	getdir(file1);
  }
```
```
mkdir()创建单个目录，上一级目录必须存在；mkdirs()创建目录，上一级目录若不存在，会创建
getPath()，获取文件的路径；
getName()获取文件名字；
getParentFile()，获取文件的父路径名字，即获取这个文件的上一层目录；
exists()，判断文件是否存在；
createNewFile()，创建文件，不是目录；
list()，返回指定的目录里面包含的文件和目录，返回一个字符串数组；
listFiles()，返回一个抽象路径名数组，也就是包含文件目录和文件目录的抽象路径，通过getName()和getAbsolutePath()来获取名字和路径；
delete()删除此文件或目录。
```

[File的方法列表](https://www.runoob.com/java/java-file.html)

###  二、File流

​        流分为 InputStream 和 OutputStream（都是抽象类，无法直接操作），FileInputStream FileOutputStream分别继承于输入流和输出流，可用来对二进制**文件**进行操作。类似的还有ByteArrayInputStream、ByteArrayOutputStream流等等，用来处理**字节**

​     使用流要做异常抛出处理，完了流要关闭 .close（）

#### 1. FileInputStream

​        FileInputStream 流被称为文件输入流，意思指对文件数据以字节的形式进行读取操作。

```
FileInputStream的方法:
read（），从输入流中读取一个数据字节；
read（byte[] b）,从此输入流中将最多b.length个字节的数据读入一个byte数组中；read（byte[] b,int off，int len），从输入流中将最多len个字节的数据读入byte数组中；
```

```java
FileInputStream读取文件的两种方式：
public void readFile(File file) throws Exception{
	FileInputStream inputStream = new FileInputStream(file);
//        按照一个一个字节的拷贝
		int c = inputStream.read(); //-128：127 
		while(c!=-1){
			System.out.print((char)c);
		    c =inputStream.read();		// 不会覆盖掉原来的内容，在末尾继续添加
		}
//        按照数组长度拷贝    
		byte[] buffer = new byte[(int) file.length()];
		int c = inputStream.read(buffer); 
		System.out.print(new String(buffer,"GBK"));
    
		inputStream.close();	
}
notes：int c = inputStream.read(); read字节为什么返回int型变量？
    若返回int为-1相当于是告诉文件已经结束读取了
```

当输出流文件不存在的时候，会自动创建文件，当输入流文件不存在时，会报错。所以，使用输入流时，要确定文件是否存在。

#### 2. FileOutputStream

```

write（byte[] b），将b.length个字节从指定byte数组写入此文件输出流中；
write(byte [] b，int off，int len)，将指定byte数组中从偏移量off开始的len个字节写入此文件输出流；
write（int b），将指定字节写入此文件输出流；
```



```Java
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamOperate {
	//递归遍历文件夹
	public void print(File f) {
		if(f==null||f.isFile()){
			System.out.println(f.getAbsolutePath());
//			f.getTotalSpace();//占用空间
//			f.length();//文件大小
//			f.delete();//删除这个文件
		}else{
//			File[] file = f.listFiles();
//			if(file !=null){
//			for(File files :file){
//				System.out.println(files);
//			}
//			}
			File file2 = new File("/");
			String[] arr = file2.list();
			for(String str : arr) {
				System.out.println(str);
			}
		}
	}

// 从输入流中读取b.length个字节到字节数组中，返回读入缓冲区的总字节数，若到达文件末尾，则返回-1
public void copy(File file1,File file2) throws Exception{
		FileInputStream inputStream = new FileInputStream(file1);
		FileOutputStream outputStream = new FileOutputStream(file2);
		byte[] buffer = new byte[1024];  	//批量读写数据，提高性能
		int c=inputStream.read(buffer);
		while(c!=-1){
		outputStream.write(buffer, 0, buffer.length);
		c = inputStream.read(buffer);
		}	
		inputStream.close();
		outputStream.close();
	}
 //文件加密
	String passwd = "klwej;lwjfq;welfjqw";
	public void copy1(File srcFile, File destFile) throws Exception {
		FileInputStream inputStream = new FileInputStream(srcFile);
		FileOutputStream outputStream = new FileOutputStream(destFile);
		
		int c = inputStream.read();
		while(c != -1) {
			//写数据时改变byte的值
			for(int i=0; i<passwd.length(); i++) {
				c += passwd.charAt(i);
			}
			
			outputStream.write(c);
			c = inputStream.read();
		}	
		inputStream.close();
		outputStream.close();
	}
	        
    public static void main(String[] args) throws Exception {
    	  StreamOperate operate = new StreamOperate(); 
    	  File file2 = new File("D:\\lanjie");
    	  File parent=file2.getParentFile();
    	  if(!parent.exists()){
    		  parent.mkdirs();
    	  }
    	  //获取文件夹下文件的路径   //1、文件夹 D:\lanjie
    	  getdir(file2);	  
    	  }
       	operate.copy(new File("D:/test1.txt"), file2);       	 
        operate.readFile(new File("D:/test1.txt"));
	
		}
}
```


