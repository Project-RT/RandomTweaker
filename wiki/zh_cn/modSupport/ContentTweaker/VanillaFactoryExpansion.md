# VanillaFactory Expansion

## 导包

```zenscript
import mods.mods.contenttweaker.VanillaFactory;
```

| 方法                                                           | 返回值      | 描述 |
| :------------------------------------------------------------ | :--------- | ---- |
| createPotion(unlocalizedName as string, color as int)         | [Potion](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/Potion.md) | 创建一个 Potion |
| createPotionType(unlocalizedName as string, potion as Potion) | [PotionType](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/PotionType.md) | 创建一个 PotionType 药水瓶属于这一类 |
| createManaItem(unlocalizedName as string, @Optional(500000) manxMana as int) | [ManaItem](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaItem.md) | 创建一个魔力物品 |
| createManaBauble(unlocalizedName as string, @Optional(500000) manxMana as int, @Optional("RING") baubleType as string) | [ManaBauble](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/ManaBauble/ManaBauble.md) | 创建一个魔力饰品
| createSubTileGenerating(unlocalizedName, color as int) | [SubTileGenerating](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/zh_cn/modSupport/ContentTweaker/SubTileGenerating/SubTileGenerating.md) | 创建一个产魔花 |

~~别问我为什么没有实例~~  
~~你怎么用原版加工厂 (VanillaFactory) 创建物品就怎么创建上面那些~~
