# Loglg
这是一个功能强大的Log工具.感谢ZhaoKaiQiang强神的源码

[![](https://jitpack.io/v/changliugang/Loglg.svg)](https://jitpack.io/#changliugang/Loglg)
[![API](https://img.shields.io/badge/API-14%2B-green.svg?style=flat)](https://android-arsenal.com/api?level=14)

## 功能
1.总控全局的日志输出开关

2.多种方法方便输出各种格式日志

3.Json、Xml日志格式化

4.日志输出信息中展示其代码位置，点击跳转到日志代码

![](https://github.com/changliugang/Loglg/raw/master/art/loglg.gif)  

## 使用

1. 在项目跟目录下build.gradle中如下添加。
```
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
2. 在app下的build.gradle如下添加依赖。
```
dependencies {
	       compile 'com.github.changliugang:Loglg:v1.0.1'
}
```
3.初始化配置：
```
Loglg.init(BuildConfig.DEBUG);
```
在Application中的onCreate()中初始化，可控制debug时输出日志release不输出日志，并可以配置全局日志tag。两个参数分别是，控制日志输出和自定义全局tag。默认tag为Loglg。

![](https://github.com/changliugang/Loglg/raw/master/art/global_init.png)

## 日志输出格式
日志等级/日志tag:[(日志代码位置)#方法名]日志内容

## 各种形式的Log输出（d为例）
1.```Loglg.d();``` 无参调用，默认输出default_message

![](https://github.com/changliugang/Loglg/raw/master/art/no_arguments.png)

2.```Loglg.d(null);```使用系统的Log输出内容为空的话，会抛出空指针异常。而Loglg会输出null

![](https://github.com/changliugang/Loglg/raw/master/art/system_output_null.png)

![](https://github.com/changliugang/Loglg/raw/master/art/system_output_null_exception.png)

![](https://github.com/changliugang/Loglg/raw/master/art/loglg_output_null.png)

3.Loglg.d(LOG_MSG);输出一般日志

![](https://github.com/changliugang/Loglg/blob/master/art/common%20_log_output.png)

4.Loglg.d(TAG, LOG_MSG, "param1", "param2", this); 多条参数日志一起打印

![](https://github.com/changliugang/Loglg/raw/master/art/some_log_output_together.png)

5.Loglg.json(JSON);  Json格式字符串日志格式化输出

![](https://github.com/changliugang/Loglg/raw/master/art/Json_format_log.png)

6.Loglg.xml(XML); Xml格式字符串日志格式化输出

![](https://github.com/changliugang/Loglg/raw/master/art/Xml_format_log.png)

##Thanks

[凯哥][1]

[1]:http://blog.csdn.net/zhaokaiqiang1992 "凯哥"
