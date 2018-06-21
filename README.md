# VirtualApkDemo
滴滴插件化开源项目简单集成使用
#VirtualHost是宿主项目   VirtualPlugin是插件项目

#VirtualHost项目配置如下
#project build.gridle 部分如下
    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.2'
        classpath 'com.didi.virtualapk:gradle:0.9.8.3'
    }
#application build.gradle.
apply plugin: 'com.didi.virtualapk.host'
#Compile application build.gradle.
compile 'com.didi.virtualapk:core:0.9.5'

#VirtualPlugin项目配置如下
#project build.gridle
dependencies {
    classpath 'com.didi.virtualapk:gradle:0.9.8.3'
}
#build.gradle.
apply plugin: 'com.didi.virtualapk.plugin'

virtualApk {
    packageId = 0x6f             // The package id of Resources.
    targetHost='source/host/app' // The path of application module in host project  此处一定要更改为宿主项目的目录下.
    applyHostMapping = true      // [Optional] Default value is true. 
}
