# FloodgatePlayerRecognitionFix

> 修复使用Bukkit+Geyser+Floodgate时，基岩玩家被识别为Java玩家

对于 `bukkit` 单端，
当使用`Geyser`+`floodgate`玩家进入服务器时  
基岩玩家可能会被当作Java玩家进入服务器，UUID与名字都变为Java  
插件配置文件可以修复这个错误