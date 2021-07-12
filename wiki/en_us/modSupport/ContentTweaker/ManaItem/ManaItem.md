# ManaItem

当同时加载了植物魔法和 CoT 时可以使 CoT 可以创建具有魔力 (Mana) 的物品  
因为 `ManaItem` 类继承 [Item](https://docs.blamejared.com/1.12/en/Mods/ContentTweaker/Vanilla/Creatable_Content/Item/) 类所以 `Item` 类可用的所有功能也可用于 `ManaItem` 类上

## 导包

```zenscrtpt
import mods.randomtweaker.cote.ManaItem;
```

| 字段 | 类型 | 描述 |
|:---------- |:---------- |----------- |
| maxItem | int (默认为 5w) | 最大魔力容量 |
| isNoExport | bool (默认 false) | 是否真正的输出魔力 |
| hasFull | bool (默认 false) | 是否创建填满魔力的魔力物品 |
| hasCreative | bool (默认 false) | 是否创建类似创造魔力石板的魔力物品 |

## Method

| 方法 | 类型 | 描述 |
|:---- |:---- |---- |
| register() | void | 注册此魔力物品 |

## 例子

```zenscript
#loader contenttweaker
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.ManaItem;

var manaItem as ManaItem = VanillaFactory.createManaItem("mana_item", 50000);
manaItem.register();
```

## 本地化

item.contenttweaker.物品ID.name
