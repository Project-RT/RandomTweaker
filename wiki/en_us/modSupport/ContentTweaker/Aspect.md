# Aspect

同时安装了 `ThaumCraft` 和 `CoT` 时使 `CoT` 能够自定义要素

## 导包

```zenscript
import mods.randomtweaker.cote.Aspect;
```

| 字段 | 类型 | 描述 |
| :--- | ---- | --- |
| tag | string | 要素的唯一名称 |
| color | int | 要素的颜色 |
| image | string | 要素贴图的路径 (默认 contenttweaker:textures/aspects/全小写 tag.png, 没有 aspects 文件夹就自己创建一个, 想填写其他的路径请用 `:` 分割主文件名和路径) |
| components | string[] | 此要素由哪两种要素合成的 (只能填两种要素) |
| blend | int |  |

## Method

| 方法 | 类型 | 描述 |
|:---- |:---- |---- |
| register() | void | 注册此要素 |

## 例子

```zenscript
#loader contenttweaker
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Aspect;

var aspect as Aspect = VanillaFactory.createAspect("test", 0x4169E1);
aspect.register();

```
