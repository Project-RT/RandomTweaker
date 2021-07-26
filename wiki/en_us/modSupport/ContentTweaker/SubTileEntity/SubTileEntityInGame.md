# SubTileEntityInGame

## Import

```zenscript
import mods.randomtweaker.cote.SubTileEntityInGame;
```

| Getter | Type | Have Setter | Description |
| :----- | ---- | ------------ | ---- |
| data | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | √ | Get or set (note that it is set and not updated) the Data of the custom flower |

| Method | Type | Description |
| :----- | ---- | --- |
| sync() | void | Sync TileEntity data |
| typeOf() | string | Return the type of the custom flower |
| getCustomData() | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | Get the Data of the custom flower |
| setCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | Set the Data of the custom flower |
| updateCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | Update the Data of the custom flower |
| getMana() | void | Get the Mana of the custom flower |
| addMana(mana as int) | void | Add the Mana of the custom flower |
| setMana(mana as int) | void | Set the Mana of the custom flower |
| getRedstoneSignal() | int | Get the redstone signal of a custom flower |
| getPassiveDecayTicks() | int | Get cooldown time for last time of the custom flower produces mana |

## Get SubTileEntityInGame

You can use `worldObj.getSubTileEntityInGame(posObj)`
to get [SubTileEntityInGame](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/modSupport/ContentTweaker/SubTileEntity/SubTileEntityInGame.md)