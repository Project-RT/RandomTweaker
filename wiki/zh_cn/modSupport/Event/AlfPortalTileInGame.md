# AlfPortalTileInGame

## 导包

```zenscript
import mods.randomtweaker.AlfPortalTileInGame;
```

## Getter

| Getter | 返回类型 | 描述 |
| :------- | :------- | :------- |
| world | [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/) | 获取精灵门所在的世界 |
| pos | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | 获取精灵门坐标 |
| data | [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/) | 获取精灵门的 data (e.g {ForgeData : {}}) |

## Setter

| Setter | 返回类型 | 描述 |
| :---- | :---- | :---- |
| data | void | 设置精灵门的 data |

## Methods

| Method | 返回类型 | 描述 |
| :---- | :---- | :---- |
| getInputList() | [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) | 获取精灵门内未被消耗的物品 (这是额外的轮, 不涉及植魔内部的合成判定) |
| setInputList(newList as [IItemStack[]](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 设置精灵门内未被消耗的物品 |
| clearInputList() | void | 清除精灵门内未被消耗的物品 |
| delInput(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 删除某个未被消耗的物品 |
| addInput(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 增加物品到 inputList |
| consumeMana(totalCost as int) | bool | 这次额外消耗多少 Mana |
| spawnItem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/)) | void | 生成物品 |
| setData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | 设置精灵门的 data |
| updateData(data as [IData](https://docs.blamejared.com/1.12/en/Vanilla/Data/IData/)) | void | 更新精灵门的 data |
| isEmpty() | bool | 返回精灵门的 data 是否为空 |

## 获取 BotaniaTileInGame 对象

你可以用 `worldObj.getAlfPortalTileInGame(pos as IBlockPos)` 获取 `AlfPortalTileInGame` 对象
