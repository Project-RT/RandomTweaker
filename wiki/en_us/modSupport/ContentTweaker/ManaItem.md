# ManaItem

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的物品  
因为 `ManaItem` 类继承 `Item` 类所以 `Item` 对象可用的所有功能也可用于 `ManaItem` 对象上

## 导包

```zenscrtpt
import mods.randomtweaker.cote.ManaItem;
```

| 字段 | 类型 | 描述 |
|:---------- |:---------- |----------- |
| maxItem | int (默认为 5w) | 最大魔力容量 |
| isNoExport | bool (默认 false) | 是否真正的输出魔力 |
| hasFull | bool (默认 false) | 是否创建填满魔力的魔力物品 |
| hasCreative | bool(默认 false) | 是否创建类似创造魔力石板的魔力物品 |
| canExportManaToPool | bool (默认 true) | 是否输出魔力到使用魔力的工具上 |
| canExportManaToItem | bool (默认 true) | 是否输出魔力到一个物品上 |
| canReceiveManaFromPool | bool (默认 true) | 是否接受来自魔力池的魔力 |
| canReceiveManaFromItem | bool (默认 true) | 是否接受来自物品的魔力 |
| register | void  | 注册此魔力物品 |

## 例子

```zenscript
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaItem;

var manaItem as ManaItem = VanillaFactory.createManaItem("mana_item", 50000);
manaItem.register();
```

## 本地化

本地化和物品的本地化方法一致
