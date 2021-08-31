# SubTileEntityInGame

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileEntityInGame;
```

## Getter

| Getter | 返回类型 | 是否有 Setter | 描述 |
| :----- | :----- | :----- | :----- |
| data | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | √ | 获取或者设置 (注意是设置不是更新) 自定义花的 Data |

## Methods

| Method | 返回类型 | 描述 |
| :----- | :----- | :----- |
| sync() | void | 同步 TileEntity 数据 (遇到什么奇奇怪怪的问题试试调用这个方法) |
| typeOf() | string | 返回自定义花的类型 |
| getCustomData() | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | 获取自定义花的 Data |
| setCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | 设置自定义花的 Data |
| updateCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | 更新自定义花的 Data |
| getMana() | int | 获取自定义花的 Mana |
| getMaxMana() | int | 获取自定义花的 MaxMana |
| addMana(mana as int) | void | 增加自定义花的 Mana |
| setMana(mana as int) | void | 设置自定义花的 Mana |
| getRedstoneSignal() | int | 获取自定义花的红石信号 |
| getPassiveDecayTicks() | int | 获取被动花产魔的冷却时间 |
| isValidBinding() | bool | ? |
| getBindingForCrT() | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | ? |

## 获取 SubTileEntityInGame

你可以用 `worldObj.getSubTileEntityInGame(posObj)` 来获取 [SubTileEntityInGame](SubTileEntityInGame.md)