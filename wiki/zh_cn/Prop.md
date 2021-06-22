# Prop

允许对某个文件进行Map数据的存储（需在配置文件开启）

导包：

~~~zenscript
import mods.randomtweaker.Prop;
~~~

## Methons

| 方法                            | 返回值   |                       |
| :------------------------------ | :------- | --------------------- |
| read(String key)                | String   | 读取数据              |
| write(String key, String value) | boolean  | 写入数据              |
| getAllKeys()                    | String[] | 读取文件内全部的Key值 |
