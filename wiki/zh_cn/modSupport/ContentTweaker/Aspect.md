# Aspect

同时安装了 `ThaumCraft` 和 `CoT` 时使 `CoT` 能够自定义要素

## 导包

```zenscript
import mods.randomtweaker.cote.Aspect;
```

## 字段

| 字段 | 类型 | 描述 |
| :--- | ---- | --- |
| tag | string | 要素的唯一名称 |
| color | int | 要素的颜色 |
| image | [ResourceLocation](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Types/Resources/CTResourceLocation/) | 要素贴图的路径 (默认 contenttweaker:textures/aspects/(全小写 tag) tag.png) |
| components | string[] | 此要素由哪两种要素合成的 (只能填两种要素) |
| blend | int | ? |

## 方法

| 方法 | 描述 |
| :---- | :---- |
| register() | 注册此要素 |

## 例子

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Aspect;

var aspect as Aspect = VanillaFactory.createAspect("test", 0x4169E1);
aspect.register();
```
