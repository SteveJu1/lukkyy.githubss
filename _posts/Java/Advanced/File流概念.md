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
