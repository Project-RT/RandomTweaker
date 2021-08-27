# IManaBauble

同时加载了 `Botania` 和 `CoT` 时此类才会注册进 `CrT`

因为 `IManaBauble`
类继承 [IManaItem](../ManaItem/IManaItem.md)
类所以 `IManaBauble` 类可以使用 `IManaItem` 类所有可用的功能

## 导包

```zenscript
import mods.randomtweaker.item.IManaBauble;
```

## 转换

你可以对 [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)
类的实例使用 `isIManaBauble()` 方法判断其是否为 IManaBauble 类的实例, 如果是即可用 `asIManaBauble()` 方法将其转换

## Getter

| Getter | 返回类型 | 描述 |
| :----- | ---- | ----- |
| baubleType | string | 返回饰品的饰品类型 |
