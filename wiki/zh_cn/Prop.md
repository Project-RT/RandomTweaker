# Prop

允许操作某个文件进行 Map 方式的输入输出 (需在配置文件开启)

导包：

~~~zenscript
import mods.randomtweaker.Prop;
~~~

## Methods

| 方法                            | 返回值   |                       |
| :------------------------------ | :------- | --------------------- |
| read(key as string)                | string   | 读取数据              |
| write(key as string, value as string) | bool  | 写入数据              |
| getAllKeys()                    | string[] | 读取文件内全部的Key值 |
