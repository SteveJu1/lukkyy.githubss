---
layout:     post
title:      "网络开发常用cmd命令 "
date:       2016-12-02 
categories: Web
tags: web cmd
---





##                           **网络常用命令**

### ping

​       主要的功能是用来检测网络的连通情况和分析网络速度。

> ``工作在 TCP 层，ping 只能证明网络是否通达，即数据可否传送到指定主机，并不能证明主机上是`
> 否开放某个端口` 
>
> `Ping 127.0.0.1(本地默认地址，可修改)，如果无法Ping通，表明本地TCP/IP协议不能正常工作，localhost 是一个域名，ipv4中指向 127.0.0.1 这个地址。`
>
> `Ping本网网关或本网IP地址，也可以检查检查硬件设备，本机与本地网络连接是否正常;`

### Telnet

​        Telnet协议是TCP/IP协议家族中的一员，是Internet远程登陆服务的标准协议和主要方式。它为用户提供了在本地计算机上完成远程主机工作的能力。

​        “端口号”这个数字标识机器上需要通信的某一个程序 

> `     每一台机器都有从 0~65535 个端口号，其中的每一个数字，可供一个程序通信用，通常情况下 0~1024 的端口要尽量避免使用---我们称它为知名端口，例如打开网页时，则连结上的是服务器上的 80 端口，在地址栏不需要输入这个端口号，是因为它是默认的` 

​          要测试服务器上是否开放了某个端口，可以使用 telnet 命令，连结对方的端口；如果能连结上，则证明对方的端口是打开的 

​         使用Telnet 命令来测试 80 端口是否打开，例如telnet taobao.com 80

> 1. Windows 7提示：telnet不是内部或外部命令，怎么办？一般只有Windows 7才会出现这种情况
> 2. 开始　→　控制面板　→　程序和功能　→　打开或关闭Windows功能，在这里就可以看到“telnet服务器”和“telnet客服端”。

> [telnet 命令使用方法](https://www.cnblogs.com/ylcms/p/7250129.html)
>
> [在命令提示符（cmd）下怎样复制粘贴](https://jingyan.baidu.com/article/1876c852bcab82890b13768f.html)

### **netstat**

​        事实上，我们的电脑无时不客在背后默默的通信着，当然这包含你机器上的木马和病毒。想知道机器正在与哪些机器通着信？：可以在命令行输入 netstat 命令查看，常用的是输入netstat -an,如果格式如下图示： 

![](C:\Users\Qi\Desktop\netstat.PNG)

![](C:\Users\Qi\Desktop\捕获.JPG)

​         这个命令会打印出你机器与其它服务器建立的 tcp 连结或 udp 连结信息。输出的数据分为四列，第一列说明是 tcp 还是 udp，第二列说明连结所使用的本地地址，由一个 IP 和端口组成；第三列说明目标机器的地址，也是由一个 IP 和端口组成，其中的 0.0.0.0 和 127.0.0.1 指的是本地地址；最后一列，是连结状态的说明，只有 TCP 是面向连结的，所以 Proto 为 tcp 的才有state 说明，当 State 为 LISTENING 时，表示本地打开了端口 

> `netstat -a  列出所有的端口，包括监听的和未监听、tcp和UDP 
> netstat -t 列出所有的tcp协议的端口
> netstat -ua 列出所有的UDP协议的端口`

​      端口状态说明

> 1、LISTENING状态：  FTP服务启动后首先处于侦听（LISTENING）状态。
> 2、ESTABLISHED状态： ESTABLISHED的意思是建立连接。表示两台机器正在通信。
> 3、CLOSE_WAIT：   对方主动关闭连接或者网络异常导致连接中断，这时我方的状态会变成CLOSE_WAIT 此时我方要调用close()来使得连接正确关闭
> 4、TIME_WAIT：一般指的是己断开的连结 。
> 5、SYN_SENT状态：　 SYN_SENT状态表示请求连接，当你要访问其它的计算机的服务时首先要发个同步信号给该端口，此时状态为SYN_SENT，如果连接成功了就变为 ESTABLISHED，SYN_SENT状态非常短暂。根据TCP协议定义的3次握手断开连接规定,发起socket主动关闭的一方 socket将进入TIME_WAIT状态,

### ipconfig

> ipconfig /all： 显示所有网络适配器(无线网、本地连接（网线）、蓝牙等)的完整的配置信息。与直接ipconfig 相比，它信息更全更多，如IP是否动态分配、显示网卡的物理地址等。
> ipconfig /release命令： 进行释放电脑的ip地址，这时候会断网
> ipconfig /renew命令： 重新获取ip地址，可以连上网了

### tracert

可以列出网络经过的路由节点，以及它在网络中每一跳的延迟

sniffer/抓包工具