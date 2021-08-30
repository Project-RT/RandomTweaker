# AuraChunk

自然灵气扩展, 方便 CrT 操控一个区块的灵气

## Import

```zenscript
import mods.randomtweaker.naturesaura.AuraChunk;
```

## Get AuraChunk Object

```zenscript
worldObj.getAuraChunk(pos as IBlockPos);
```

### Methods

| Method | Return Type | Description |
| :----- | :----- | :----- |
| drainAura(pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), amount as int, aimForZero as bool, simulate as bool) | int | 消耗给定 pos 的灵气数量, 返回消耗的灵气 (aimForZero 为 true 时如果灵气被消耗到负数则返回值为消耗前的灵气) |
| drainAura(pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), amount as int) | int | 同上只不过后两个参数是 false |
| storeAura(pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), amount as int, aimForZero as bool, simulate as bool) | int | 增加给定 pos 的灵气数量, 返回增加的灵气 (aimForZero 为 true 时如果灵气被增加到正数则返回值为增加前的灵气) |
| storeAura(pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), amount as int) | int | 同上只不过后两个参数是 false |
| getDrainSpot(pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | int | 返回给定 pos 的灵气数量 |

## IWorld Expansion

### 方法都被 static 修饰过, 意味着可以类调用

e.g IWolrd.getSpotAmountInArea(worldObj, posObj, 1)

or

e.g worldObj.getSpotAmountInArea(posObj, 1);

### IWorld Methods

| Method | Return Type | Description |
| :----- | :----- | :----- |
| getHighestSpot(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), radius as int, defaultSpot as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | 返回给定 `pos` 为中心 `radius` 为半径的范围内存储最多灵气的 `pos` 如果找不到或灵气小于等于 `0` 则返回  defaultSpot |
| getLowestSpot(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), radius as int, defaultSpot as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | 返回给定 `pos` 为中心 `radius` 为半径的范围内存储最少灵气的 `pos` 如果找不到或大于等于 `0` 则返回  defaultSpot |
| getSpotAmountInArea(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), radius as int) | int | 返回给定 `pos` 为中心 `radius` 为半径的范围内光点总和 |
| getAuraInArea(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), radius as int) | int | 返回给定 `pos` 为中心 `radius` 为半径的范围内的灵气总和 |
| triangulateAuraInArea(world as [IWorld](https://docs.blamejared.com/1.12/en/Vanilla/World/IWorld/), pos as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), radius as int) | int | 同上但使光点更具有观赏性也更消耗性能 |
