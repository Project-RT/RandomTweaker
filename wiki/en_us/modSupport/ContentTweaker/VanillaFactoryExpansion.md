# VanillaFactory Expansion

## 导包
```zenscript
import mods.mods.contenttweaker.VanillaFactory;
```

| 方法                                                           | 返回值      | 描述                                            |
| :------------------------------------------------------------ | :--------- | ---------------------------------------------- |
| createPotion(unlocalizedName as string, color as int)         | Potion     | 创建一个 Potion                           |
| createPotionType(unlocalizedName as string, potion as Potion) | PotionType | 创建一个 PotionType 药水瓶属于这一类）         |
| createManaItem(unlocalizedName as string, @Optional(500000) manxMana as int) | ManaItem   | 创建一个 ManaItem 类的魔力物品                        |
| createManaBauble(unlocalizedName as string, @Optional(500000) manxMana as int) | ManaBauble   | 创建一个 Bauble 类的魔力饰品

~~别问我为什么没有实例~~  
~~你怎么用原版加工厂 (VanillaFactory) 创建物品流体就怎么创建上面那些~~