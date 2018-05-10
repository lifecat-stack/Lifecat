# LifeCat-Ecosystem-of-album-system
# 基于互联网+的电子宠物式成长相册记录系统研发
The Album System : Web+Android+stm32 

  项目总地址：https://github.com/kevinten10/LifeCat-System

  Javaweb项目地址：https://github.com/kevinten10/JavaWeb-Album

  Android项目地址：https://github.com/kevinten10/Android-Album

  stm32项目地址：https://github.com/kevinten10/STM32-Album

  相关项目：

  linux云服务器以及mysql数据库搭建：https://github.com/kevinten10/Jsp-Servlet-Mysql

  python爬虫获取图片数据：https://github.com/kevinten10/PythonCrawler-Album

  python机器学习算法实现图片操作：https://github.com/kevinten10/Python-Image-Processing

  python机器学习算法笔记：https://github.com/kevinten10/Python-Machine-Learn
  
### 数据库设计：

需求分析：服务器基于linux系统，故在linux下使用关系型key-value数据库mysql进行数据结构设计。结合本项目的具体业务分析，数据库应满足用户的信息存储与安全性设计，以及图片的存储。同时鉴于图片所需空间较大，故在数据库中保存图片的路径，而图片信息存在服务器下的文件夹中。

数据表设计：数据库主要包含用户表、用户信息表、图片信息表。

（一）用户表user：包含四个字段，主键用户id，用户名username，用户密码password，用户权限level。

（二）用户信息表usermsg：包含六个字段，主键用户id，用户昵称nickname，用户性别sex，用户年龄age，用户生日birthday，用户邮箱email

（三）图片信息表upimage：包含五个字段，主键用户id，图片名称imagename，图片描述imagedescription，图片上传日期imagedate，图片存储路径imagepath。

 

### web开发设计

使用Intellijidea进行软件的开发，前端静态页面采用html+css+bootstrap实现，同时采用javascript+jQuery+Ajax进行了页面的动态脚本设置。后端基于MVC架构，表现层采用jsp进行动态页面开发，控制层采用servlet，模型层使用Javabean实现，实现了松耦合的设计，加入了表单验证机制，能够更有效地进行访问控制。Web容器使用tomcat部署，tomcat提供了多线程支持、生命周期管理以及安全性配置等功能，使得web应用具有健壮性。

主要页面：

产品官网：通过WordPress框架进行开发，进行产品的展示及宣传

相册主页：通过JavaScript进行动态的主页展示和用户的登录/注册功能

用户界面：通过JavaScript脚本将页面分为“用户信息”“成长寄语”“成长相册”三个模块，根据点击选择每次显示其中一个，用户可以在此进行设置信息、修改密码等操作，并通过链接访问到其他界面。

相册展示页面：通过访问数据库获取图片url，然后调用IO流将图片显示到界面。

主要功能：

用户登录/注册：通过jdbc操作user数据表，验证及更新用户账户信息

用户信息修改：通过jdbc操作usermsg数据表，能够设置用户的信息

图片上传：通过javaIO流，将要上传的图片以二进制流方式写入服务器文件夹，并在upimage数据表中存储图片在服务器上的路径。

图片展示：根据用户id从upimage数据表获取图片的存储路径，通过javaIO流方式将图片信息传输显示到前端显示页面。

 

### Android应用开发

APP基于Android平台，使用AndroidStudio开发，UI遵循MaterialDesign设计原则，结合使用了Android原生组件与GitHub上的开源组件。

主要界面：

欢迎界面：播放欢迎视频。

登录/注册：用户登录/注册的操作均会连接到数据库，进行同数据库的操作

主页面：跳转到其他页面，以及侧边栏显示用户信息

上传图片：取得用户权限后，可以读取本机内的图片库或使用摄像头进行拍照，最多选中9张照片进行上传。

相册：展示用户的图片库，基于卡片式布局，有效的进行界面的美观和管理

主要功能：

服务器通信：使用Http协议进行数据传输，通过开源库OkHttp进行实现，能够向服务器发送POST请求，服务器使用java部署，能够通过jdbc获取数据库信息并返回响应，从而实现图片的上传存储与下载功能。

图片展示：使用卡片式布局，实现良好的界面展示设计，实现Android图片显示功能。

用户信息安全验证：通过与数据库的交互，实现用户的登录与注册，确保用户信息的安全性

 
### 嵌入式相册系统

基于stm32芯片进行开发，采用480*320分辨率内置显存模块的LCD显示屏模块，使用stm32芯片内置的FSMC模拟8080接口时序从而驱动LCD。通过FatFS文件系统进行SD存储空间的管理。

主要功能：

展示图片：通过FatFS系统从已格式化为Fat32文件系统的SD卡中读取图片数据流，通过二进制流方式按照FSMC时序，以行的方式传输到LCD显示屏内置的显存中，传输完成后刷新缓冲区从而实现显示图片的功能。

通过循环进行图片的刷新播放，实现了自动循环播放的功能。程序使用C语言编写，使用stm32提供的库函数进行硬件配置与操作。


![image](https://img-blog.csdn.net/20180510163935680?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/2018051016395280?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164009484?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/2018051016401982?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164032456?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164042264?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164051236?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164058567?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164109872?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164119461?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164130325?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164138254?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164145128?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164152975?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)

![image](https://img-blog.csdn.net/20180510164200677?watermark/2/text/aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dzaDU5NjgyMzkxOQ==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70)
