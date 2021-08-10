# IBlockPos Expansion

扩展 `IBlockPos` 所以 `IBlockPos` 对象可以直接使用以下方法

| 方法                                             | 返回值      | 描述                               |
| :----------------------------------------------- | :---------- | ---------------------------------- |
| static getAllInBox(from as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), to as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | [IBlockPos[]](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | 给出两个 pos 所框选中的所有位置 |
| add(x as double, y as double, z as double)                | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移指定的 xyz     |
| add(x as int, y as int, z as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移指定的 xyz     |
| up(Optional(1) n as int)                            | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移至上方 n 格    |
| down(@Optional(1) n as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移至下方 n 格    |
| north(@Optional(1) n as int)                        | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移至北方 n 格    |
| south(@Optional(1) n as int)                        | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移至南方 n 格    |
| west(@Optional(1) n as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移至西方 n 格    |
| east(@Optional(1) n as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | 将 pos 偏移至东方 n 格     |

**带有 static 修饰符的方法需要类来调用** (e.g. `IBlockPos.getAllInBox(posOne, posTwo);` )
