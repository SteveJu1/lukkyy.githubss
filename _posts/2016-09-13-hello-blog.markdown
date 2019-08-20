---
layout:     post
title:      "个人博客 "
date:       2016-09-13 
categories: Other
tags: Blog
---


### 前言

​     Blog终于开通了，嘻嘻! 搭建个人博客，我觉得最大的好处是可以把沉淀的总结感悟写下来。写点自己真正想表达的东西。

​     前期在简书、博客园上都写过博客。觉得用户体验不太好，写了几篇就放弃了。不错就是界面太丑，广告还多。在GitHub上混迹久了，发现别人的博客挺炫酷的，一不做二不休，花一天搞一个吧！结果搞了几天！心累~。说下自己遇到的坑吧，只要坑避开了，搭建博客还是挺快的

---







### 正文

[先看看博客长啥样](https://github.com/lukkyy/GitHub.page)

接下来说说搭建这个博客的技术细节

Github Pages是类似于服务器作用的博客平台，常使用的方法有两种

####  [GitHub Pages](https://pages.github.com/) + [Jekyll](http://jekyllrb.com/) 

Jekyll 是GitHub Pages官方推荐的工具，说明文档是英文的，对一些人来说很不友好

```bash
jekyll new myblog  #命名为myblog
cd myblog # 进入myblog目录
# 在Jekyll自带的服务器上预览你的项目，默认的运行地址为http://localhost:4000
# bundle exec 表示在当前项目依赖的上下文环境中执行命令 jekyll serve
jekyll server
```



####  [GitHub Pages](https://pages.github.com/) + [hexo](https://hexo.io/zh-cn/)  

hexo是Theme最丰富的工具，界面普遍要更好看些，有中文文档

配置软件依赖：Node.js（[下载](https://nodejs.org/en/download/)）和Git（[下载](https://git-scm.com/download)）

在安装Hexo的目录下，运行Git（右键点击“Git Bash Here”）

```bash
$ git clone https://github.com/litten/hexo-theme-yilia.git themes/yilia
$ hexo generate
$ hexo server

$ npm install hexo-deployer-git --save
deploy:
  type: git
  repo: <repository url> #https://bitbucket.org/JohnSmith/johnsmith.bitbucket.io
  branch: [branch] #published
  message: [message]

$ hexo generate --deploy

```

这两个软件的安装配置过程可参照下面的博客，就是安装配置一些软件依赖，最坑的是在Windows环境下Jekyll官方推荐安装的Ruby + DevKit包一直出错，如果遇到这种情况直接安装没有DevKit的Ruby包就好了 

由于版本一直在更新，一些命令发生了改变，不能运行的话要查官方文档

Jekyll 博客搭建： https://www.jianshu.com/p/9f198d5779e6

hexo 博客搭建：https://www.jianshu.com/p/1c888a6b8297?utm_source=oschina-app



---

### 搭建

​     上面说了很多，对美观要求高的同学，可以根据上面的基础知识和Jekyll和hexo 的官方文档自己搭建博客，这需要有点web开发的基础（HTML，JS，css）

​     如果不想花太多时间精力，**可以不用看上面写的**，采用最简单的方式就好。推荐大家看下这篇文章，教我们如果最简单的搭建博客。

[小呼哥最简易的搭建博客方法](https://blog.csdn.net/hu2535357585/article/details/95253749 )

​    简单来说就是把别人的博客主题fork下来，改改配置文件，简单实用。然后用Github desktop上传博客。同时上点干货， 推荐一些不错的主题https://hexo.io/themes/

​    注意：博客的文章有固定的格式要求，必须放在 _post目录下，这是Jekyll解析成静态网页规定的：

​    文件名以`2016-11-01`这样形式的时间开头： 2016-11-01-hello.markdown  

​     在.markdown  文本里，要以下面的格式开头

```
---
layout:     post
title:      "cmd "
date:       2016-11-29 
header-img: "img/post-bg-1.png"
tags: 生活
---
```




### 后记

现在重新改了博客的主页，由于comment是用的disqus插件，要翻墙才能看到（蓝瘦）

十分感谢：

[小呼哥最简易的搭建博客方法](https://blog.csdn.net/hu2535357585/article/details/95253749  )

Hux大佬的模板哈

[Github+Jekyll 搭建个人网站详细教程](https://www.jianshu.com/p/9f71e260925d)