# BaubleRenderHelper

The content of this chapter is highly recommended for players to test it on your own.

## Import

```zenscript
import mods.randomtweaker.BaubleRenderHelper;
```

| Static Methods| Description |
|:------ | --- |
<<<<<<< HEAD:wiki/en_us/BaubleRenderHelper.md
| bindTexture(@Optional("minecraft:textures/atlas/blocks.png") resourceLocation as string) | resourceLocation is the path to the texture to be bound |
| defaultTransforms() | Reduce the rendering of the baubles to normal size (any rendering will work) |
| scale(x as double, y as double, z as double) | Stretch the scale of the baubles by x y z pixels|
| translate(x as double, y as double, z as double) | Offset the baubles by x y z pixels |
| rotate(angle as float, x as float, y as float, z as float) | Rotate the baubles, the first parameter is the angle, the next three parameters are angle * parameters |
| renderItem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional("NONE") transformType as string) | Render items, The first parameter fills in the baubles to be rendered, The second parameter has the following `NONE`, `THIRD_PERSON_LEFT_HAND`, `THIRD_PERSON_RIGHT_HAND`, `FIRST_PERSON_LEFT_HAND`, `FIRST_PERSON_RIGHT_HAND`, `HEAD`, `GUI`, `GROUND`, `FIXED` |
=======
| bindTexture(@Optional("minecraft:textures/atlas/blocks.png") resourceLocation as string) | resourceLocation 为要绑定的纹理的路径 |
| defaultTransforms() | 将饰品的渲染缩小到正常大小 (任何渲染都可以用) |
| scale(x as double, y as double, z as double) | 将饰品的比例拉伸 x y z 个像素|
| translate(x as double, y as double, z as double) | 将饰品偏移 x y z 个像素 |
| rotate(angle as float, x as float, y as float, z as float) | 旋转饰品, 第一个为角度, 后面三个参数为 angle * 参数 |
| renderItem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional("NONE") transformType as string) | 渲染物品 第一个参数填写要渲染的饰品 第二个参数有如下几种 `NONE`, `THIRD_PERSON_LEFT_HAND`, `THIRD_PERSON_RIGHT_HAND`, `FIRST_PERSON_LEFT_HAND`, `FIRST_PERSON_RIGHT_HAND`, `HEAD`, `GUI`, `GROUND`, `FIXED` |
>>>>>>> master:wiki/zh_cn/modSupport/ContentTweaker/ManaBauble/BaubleRenderHelper.md

## Used on `BODY`

| Static Methods| Description |
|:------ | --- |
| translateToChest() | Renders the baubles to the player's chest correctly (usually called after the `rotateIfSneaking` method) |
| rotateIfSneaking(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | Whether or not baubles rotation is rendered normally when the player is sneaking |

## Used on `HEAD`

| Static Methods| Description |
|:------ | --- |
| translateToFace() | Renders the baubles to the player's face correctly (usually called after the `translateToHeadLevel` method) |
| translateToHeadLevel(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | Render baubles to the player's head correctly (including when sneaking) |
