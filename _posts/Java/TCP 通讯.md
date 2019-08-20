

TCP 通讯

先写下最简单的服务器怎么搭建



```
ServerSocket ssocket = new ServerSocket(14000);  // 服务器和端口号
Socket socket = ssocket.accept();  //服务器接受的套接字
//获取的数据和输出的数据
InputStream inputStream = socket.getInputStream; //套接字获取输入流
OutputStream outputStream = socket.getOutStream; //套接字 输出流
//可以把输入，输出流转成各种流，调用不同流的方法





```

