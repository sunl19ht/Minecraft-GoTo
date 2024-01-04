# Minecraft 1.20.1 GoTo 传送插件(制作中...)

###### 插件介绍：这是一个Minecraft服务器的传送插件 实现普通玩家(无op权限)也可以使用类似原版tp指令的效果。
###### 使用环境：Jdk17，服务器核心spigot-1.20.1.jar，必备插件LuckPerms
* 使用教程
    * 下载 LuckPerms 插件 下载地址：<https://markdown.com.cn/basic-syntax/links.html>
    * 克隆此项目 git clone git@github.com:sunl19ht/Minecraft-GoTo.git
    * 使用 gradle 构建此项目，构建结果在 /build/libs/xxx.jar
    * 将xxx.jar放到服务端的plugins文件夹下
    * 运行服务端建议添加 -Dfile.encoding=UTF-8 参数 否则有可能产生中文乱码情况
    * 启动服务端
* LuckPerms 的设置 将需要传送的玩家添加到player权限组即可
    * 创建权限组： 打开服务器控制台，并输入以下命令： /lp creategroup player
    * 分配权限： 给 "player" 组分配相应的权限： /lp group player permission set goto.player true
    * 将玩家添加到权限组： 在服务器控制台或游戏内输入以下命令： /lp user <玩家名> parent add player

### 功能介绍
1. [传送到指定玩家] /goto <玩家名>
2. [关闭传送功能] /goto close
3. [开启传送功能] /goto open
