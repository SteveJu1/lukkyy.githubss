---
layout: post
title:  "WebSocket探究与应用"
categories: JavaScript
tags:  WebSocket 通信 协议
---

* content
{:toc}
## 数据类型

一个byte是8个二进制位，下面数字表示用了几个字节

char  2   note：Java中char 的字节数是根据字符集编码，默认的编码是Unicode，所以是2个字节，若用UTF8编码，英文1个字节，中文大多是3个字节，

int   4

String 是对象引用类型，字节数根据引用对象的字节