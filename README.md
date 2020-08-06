# V5验证-安卓原生SDK使用说明
## 1.添加权限
![alt 添加权限](./md-assess/1.jpg "添加权限")

```xml
<uses-permission android:name="android.permission.INTERNET"/>
<uses-permission android:name="android.permission.READ_PHONE_STATE" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

```
## 2.设置aar引用路径
![alt 设置aar引用路径](./md-assess/2.jpg "设置aar引用路径")
```
repositories {
	flatDir {
		dirs 'libs'   // aar目录
	}
}
```
## 3.导入aar包到libs目录，并且完成依赖设置

![alt 目录](./md-assess/3.jpg "目录")

![alt compile](./md-assess/4.jpg "compile")
## 4.依赖所需要的库
![alt compile](./md-assess/5.jpg "compile")
```
compile "com.orhanobut:hawk:2.0.1"
compile 'com.squareup.okhttp3:okhttp:3.12.1'
compile 'com.hjq:xxpermissions:6.5'
compile 'com.github.bumptech.glide:glide:3.7.0'

```
## 5.添加混淆规则
![alt proguard](./md-assess/6.jpg "proguard")

```
-keep class com.verify5.client.entity.V5JsBinder{*;}
```
## 6.在Application中初始化
![alt 初始化](./md-assess/7.jpg "初始化")

## 7.调用
![alt 调用](./md-assess/8.jpg "调用")
```java
V5VerifyClient.verify(MainActivity.this,options, new VerifyStateMonitor() {
	@Override
	public void onVerifyResult(String result) {
		msg.setText("The result is ："+result);
	 }
});

```







