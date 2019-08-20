package IOStudy;

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

//FileReader/InputStreamReader/BufferedReader
//FileInputStream，DataInputStream，ByteArrayInputStream，

//BufferedIutputSteam
//PrintStream
public class Test {
	//字符流
	public void readFile(String file) throws Exception {
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
		//读取一行内容
		String line = bufferedReader.readLine();
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
		FileInputStream fis = new FileInputStream("/Doc/test.txt");
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
//		t.readFile("/Doc/test.txt");
		
		t.test();
	}

}
