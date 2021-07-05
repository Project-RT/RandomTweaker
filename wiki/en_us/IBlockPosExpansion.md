# IBlockPos Expansion

Extend the `IBlockPos` class so that the `IBlockPos` object can use the following methods

| Method                                     | Return                                                       | Description                    |
| :----------------------------------------------- | :---------- | ---------------------------------- |
| static getAllInBox(from as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/), to as [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)) | [IBlockPos[]](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/) | Give all positions in two pos blocked |
| add(x as double, y as double, z as double)                | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos by the specified xyz |
| add(x as int, y as int, z as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos by the specified xyz |
| up(Optional(1) n as int)                            | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos how many blocks up |
| down(@Optional(1) n as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos how many blocks down |
| north(@Optional(1) n as int)                        | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos how many blocks north |
| south(@Optional(1) n as int)                        | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos how many blocks south |
| west(@Optional(1) n as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos how many blocks west |
| east(@Optional(1) n as int)                         | [IBlockPos](https://docs.blamejared.com/1.12/en/Vanilla/World/IBlockPos/)   | Set pos how many blocks east |

**with static requires class call** (e.g. `IBlockPos.getAllInBox(posOne, posTwo);` )

