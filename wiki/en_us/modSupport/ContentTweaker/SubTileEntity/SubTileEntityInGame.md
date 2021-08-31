# SubTileEntityInGame

## Import

```zenscript
import mods.randomtweaker.cote.SubTileEntityInGame;
```

## Getter

| Getter | Return Type | Have Setter | Description |
| :----- | :----- | :----- | :----- |
| data | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | √ | Get or set (note that it is set and not updated) the Data of the custom flower |

## Methods

| Method | Return Type | Description |
| :----- | :----- | :----- |
| sync() | void | Sync TileEntity data (Try calling this method when you encounter any problems)|
| typeOf() | string | Return the type of the custom flower |
| getCustomData() | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | Get the Data of the custom flower |
| setCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | Set the Data of the custom flower |
| updateCustomData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | Update the Data of the custom flower |
| getMana() | int | Get the amount of mana of the custom flower |
| getMaxMana() | int | Get the max mana of the custom flower |
| addMana(mana as int) | void | Add the amount of mana of the custom flower |
| setMana(mana as int) | void | Set the amount of mana of the custom flower |
| getRedstoneSignal() | int | Get the redstone signal of a custom flower |
| getPassiveDecayTicks() | int | Get cooldown time for last time of the custom passive generation flower |
| isValidBinding() | bool | ? |
| getBindingForCrT() | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | ? |

## Get SubTileEntityInGame

You can use `worldObj.getSubTileEntityInGame(posObj)` to
get [SubTileEntityInGame](SubTileEntityInGame.md)
