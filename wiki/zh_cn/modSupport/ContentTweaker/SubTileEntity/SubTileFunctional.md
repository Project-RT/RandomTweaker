# SubTileFunctional

因为 `SubTileFunctional`
类继承 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)
类所以 `SubTileEntity` 所有可用的功能 `SubTileFunctional` 类都能用

如果有小功能花, 记得在 `resources/contenttweaker/textures/blocks` 目录下存放一张单独的贴图给小功能花 (贴图名 : unlocalizedName +
chibi.png)

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileFunctional;
```

## ZenProperty

请看 [SubTileEntity](https://github.com/ikexing-cn/RandomTweaker/blob/1.12/wiki/zh_cn/modSupport/ContentTweaker/SubTileEntity/SubTileEntity.md)

| 字段 | 类型 | 描述 |
|:---- |:--- |----- |
| hasMini | bool | 是否创建小型功能花 |
| miniRange | int | 小型功能花的工作范围 |

## ZenMethod

| 方法 | 类型 | 描述 |
|:---- |:--- |----- |
| register() | void | 注册此功能花 |

## 示例

```zenscript
#loader contenttweaker
import mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.SubTileFunctional;

var subTileFunctional as SubTileFunctional = VanillaFactory.createSubTileFunctional("test_1", 0xFFFFFF);
subTileFunctional.register();
```
