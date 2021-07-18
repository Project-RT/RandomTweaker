# SubTileEntityInGame

## 导包

```zenscript
import mods.randomtweaker.cote.SubTileEntityInGame;
```

| Getter | 类型 | 是否有 Setter | 描述 |
| :----- | ---- | ------------ | ---- |
| data | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | √ | 获取或者设置 (注意是设置不是更新) 自定义花的 Data |

| Method | 类型 | 描述 |
| :----- | ---- | --- |
| sync() | void | 同步 TileEntity 数据 |
| typeOf() | string | 返回 `generating` |
| getCustomData() | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | 获取自定义花的 Data |
| setCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | 设置自定义花的 Data |
| updateCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | 更新自定义花的 Data |
| getMana() | void | 获取自定义花的 Mana |
| addMana(mana as int) | void | 增加自定义花的 Mana |
| setMana(mana as int) | void | 设置自定义花的 Mana |
| getRedstoneSignal() | int | 获取自定义花的红石信号 |
| getPassiveDecayTicks() | int | 获取产魔的冷却时间 |

## 获取 SubTileEntityInGame

你可以用 `worldObj.getSubTileEntityInGame(posObj)`
来获取 [SubTileEntityInGame](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntityInGame.md)