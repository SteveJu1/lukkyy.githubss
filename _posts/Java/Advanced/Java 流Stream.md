

### Java 中的IO流（Stream）

​      在Java中按照读取/输出数据的长度可以分为字节流和字符流，字节流是按照一个字节一个字节的读取的；字符流是按照字符读取的，在Java中字节是8bit，字符的长度中文是两个字节，英文是一个字节。

常用到的流有以下几种，字符流有：FileReader，InputStreamReader，BufferReader 等

字节流有：FileInputStream，DataInputStream，ByteArrayInputStream，BufferedIutputSteam，printStream 等，下面画了Java中流的继承关系图。

![](C:\Users\Qi\Desktop\github_md\Java\Advanced\IO流.png)

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

