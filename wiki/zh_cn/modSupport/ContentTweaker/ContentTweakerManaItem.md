# ManaItem

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的物品

## 导包

```zenscrtip
import mods.randomtweaker.ManaItem;
```


| 字段        | 类型        | 描述         |
|:---------- |:---------- |----------- |
| maxItem    | int        | 最大魔力容量 |
| isNoExport | bool (默认 false) | 是否真正的输出魔力 |
| isCreative | bool (默认 false) | 是否属于创造型的魔力物品 (类似创造板魔力石板) |
| canExportManaToPool | bool (默认 true) | 是否输出魔力到使用魔力的工具上 | 
| canExportManaToItem | bool (默认 true) | 是否输出魔力到一个物品上      |
| canReceiveManaFromPool | bool (默认 true) | 是否接受来自魔力池的魔力   |
| canReceiveManaFromItem | bool (默认 true) | 是否接受来自物品的魔力    |
| register               | void (默认 true) | 注册此魔力物品           |

以上字段除了 maxItem 都有 getter 和 setter 方法 (maxItem 有 getter 方法)

```zenscrtip
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.ManaItem;

var manaItem as ManaItem = VanillaFactory.createManaItem("mana_item", 50000);
manaItem.register();
```

## 本地化
本地化和物品的本地化方法一致