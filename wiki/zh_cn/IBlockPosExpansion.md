# IBlockPos Expansion

扩展 `IBlockPos` 所以 `IBlockPos` 对象可以直接使用以下方法

| 方法                                             | 返回值      | 描述                               |
| :----------------------------------------------- | :---------- | ---------------------------------- |
| static getAllInBox(from as IBlockPos, to as IBlockPos) | IBlockPos[] | 给出参数 IBlockPos 所框选中的所有位置 |
| add(x as double, y as double, z as double)                | IBlockPos   | 将参数 IBlockPos 偏移指定的参数     |
| add(x as int, y as int, z as int)                         | IBlockPos   | 将参数 IBlockPos 偏移指定的参数     |
| up(Optional(1) n as int)                            | IBlockPos   | 将参数 IBlockPos 偏移至上方 n 格    |
| down(@Optional(1) n as int)                         | IBlockPos   | 将参数 IBlockPos 偏移至下方 n 格    |
| north(@Optional(1) n as int)                        | IBlockPos   | 将参数 IBlockPos 偏移至北方 n 格    |
| south(@Optional(1) n as int)                        | IBlockPos   | 将参数 IBlockPos 偏移至南方 n 格    |
| west(@Optional(1) n as int)                         | IBlockPos   | 将参数 IBlockPos 偏移至西方 n 格    |
| east(@Optional(1) n as int)                         | IBlockPos   | 将参数 IBlockPos 偏移至东方 n 格     |

**带有 static 修饰符的方法需要类来调用** (e.g. `IBlockPos.getAllInBox(posOne, posTwo);` )