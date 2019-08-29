Tomcat

服务器调用数据库（）

Tomcat配置踩得坑，Tomcat可以客户端安装，和下载库，

出现环境变量安装错误的问题，解决方法 ：在cmd中运行，看出的错误在哪，根据错误提示安装，比按博客安装靠谱。https://blog.csdn.net/qq_40881680/article/details/83582484

先要开启服务器，比如Tomcat, 再让Java程序再服务器上运行（run on server）

比如新建了Dynamic Web Project项目web,项目下新建了html文件NewFile.html：就可以在浏览器访问这个网页（本地使用localhost:8080/web/NewFile.html）,html文件的格式如下：

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>title </title>
</head>
<body>
      body content
</body>
</html>
```