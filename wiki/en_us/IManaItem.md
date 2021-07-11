# IManaItem

同时加载了 `Botania` 和 `CoT` 时此类的才会注册进 CrT

## 导包

```zenscript
import mods.randomtweaker.item.IManaItem;
```

你可以对 [IMutableItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IMutableItemStack/)
类的实例使用 `isIManaItem()` 方法判断其是否为 IManaItem 类的实例, 如果是即可用 `asIManaItem()` 方法将其转换

| Getter | 返回值 | 描述 |
| :----- | ---- | ----- |
| mana | int | 当前 Mana 值|
| maxMana | int | 能容纳的最大 Mana |
| isNoExport | bool | 是否真正输出 Mana |
| hasFull | bool | 是否同时有填满 Mana 的物品 |
| hasCreative | bool | 是否同时有创造型物品 |
| canExportManaToPool | bool | 是否输出 Mana 到魔力池 |
| canExportManaToItem | bool | 是否输出 Mana 到使用 Mana 的物品上 |
| canReceiveManaFromPool | bool | 是否接受来自魔力池的 Mana |
| canReceiveManaFromItem | bool | 是否接受来自物品的 Mana |

## ZenMethod

updateMana(mana as int) void 增加 (e.g iManaItemObj.updateMana(1)) 或减少 (e.g iManaItemObj.updateMana(
-1)) 物品的 Mana
