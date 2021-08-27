# VanillaFactory Expansion

## 导包

```zenscript
import mods.mods.contenttweaker.VanillaFactory;
```

| 方法 | 返回类型 | 描述 |
| :------------------ | :------------------ | :------------------ |
| createPotion(unlocalizedName as string, color as int) | [Potion](Potion/Potion.md) | 创建一个 Potion |
| createPotionType(unlocalizedName as string, potion as [Potion](Potion/Potion.md)) | [PotionType](Potion/PotionType.md) | 创建一个 PotionType 药水瓶属于这一类 |
| createManaItem(unlocalizedName as string, @Optional(500000) manxMana as int) | [ManaItem](ManaItem/ManaItem.md) | 创建一个魔力物品 |
| createManaBauble(unlocalizedName as string, baubleType as string, @Optional(500000) manxMana as int) | [ManaBauble](ManaBauble/ManaBauble.md) | 创建一个魔力饰品 |
| createManaUsingItem(unlocalizedName as string, @Optional(500000) manxMana as int) | [ManaUsingItem](ManaItem/ManaUsingItem.md) | 创建一个魔力工具 (实现 IManaUsingItem 的物品) |
| createSubTileGenerating(unlocalizedName, color as int) | [SubTileGenerating](SubTileEntity/SubTileGenerating.md) | 创建一朵产魔花 |
| createSubTileFunctional(unlocalizedName, color as int) | [SubTileFunctional](SubTileEntity/SubTileFunctional.md) | 创建一朵功能花花 |

~~别问我为什么没有实例~~

~~你怎么用原版加工厂 (VanillaFactory) 创建物品就怎么创建上面那些~~
