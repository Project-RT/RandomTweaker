# Vanilla Expansion
添加了一些方法使其能快速使用crt
## IBlockPos Expansion

导包：

~~~zenscript
import crafttweaker.player.IPlayer;
~~~

| 方法                                             | 返回值      | 描述                               |
| :----------------------------------------------- | :---------- | ---------------------------------- |
| Static getAllInBox(IBlockPos from, IBlockPos to) | IBlockPos[] | 给出参数BlockPos所框选中的所有位置 |
| add(double x, double y, double z)                | IBlockPos   | 将参数的BlockPos偏移指定的参数     |
| add(int x, int y, int z)                         | IBlockPos   | 将参数的BlockPos偏移指定的参数     |
| up(Optional(1) int n)                            | IBlockPos   | 将参数的BlockPos偏移至上方         |
| down(@Optional(1) int n)                         | IBlockPos   | 将参数的BlockPos偏移至下方         |
| north(@Optional(1) int n)                        | IBlockPos   | 将参数的BlockPos偏移至北方         |
| south(@Optional(1) int n)                        | IBlockPos   | 将参数的BlockPos偏移至南方         |
| west(@Optional(1) int n)                         | IBlockPos   | 将参数的BlockPos偏移至西方         |
| east(@Optional(1) int n)                         | IBlockPos   | 将参数的BlockPos偏移至东方         |