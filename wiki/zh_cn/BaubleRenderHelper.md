# BaubleRenderHelper

本章节内容十分推荐玩家自己上手测试一下

## 导包

```zenscript
import mods.randomtweaker.BaubleRenderHelper;
```

| 静态方法| 描述 |
|:------ | --- |
| bindTexture(@Optional("minecraft:textures/atlas/blocks.png") resourceLocation as string) | resourceLocation 为要绑定的纹理的路径 |
| defaultTransforms() | 将饰品的渲染缩小到正常大小 (任何渲染都可以用) |
| scale(x as double, y as double, z as double) | 将饰品的比例拉伸 x y z 个像素|
| translate(x as double, y as double, z as double) | 将饰品偏移 x y z 个像素 |
| rotate(angle as float, x as float, y as float, z as float) | 旋转饰品, 第一个为角度, 后面三个参数为 angle * 参数 |
| renderItem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional("NONE") transformType as string) | 渲染物品 第一个参数填写要渲染的饰品 第二个参数有如下几种 `NONE`, `THIRD_PERSON_LEFT_HAND`, `THIRD_PERSON_RIGHT_HAND`, `FIRST_PERSON_LEFT_HAND`, `FIRST_PERSON_RIGHT_HAND`, `HEAD`, `GUI`, `GROUND`, `FIXED` |

## 用于 `BODY` 上

| 静态方法| 描述 |
|:------ | --- |
| translateToChest() | 将饰品正确渲染到玩家的胸部 (通常调用在 `rotateIfSneaking` 方法之后) |
| rotateIfSneaking(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | 玩家潜行时是否正常渲染饰品旋转 |

## 用于 `HEAD` 上

| 静态方法| 描述 |
|:------ | --- |
| translateToFace() | 将饰品正确渲染到玩家的脸部 (通常调用在 `translateToHeadLevel` 方法之后) |
| translateToHeadLevel(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | 将饰品正确渲染到玩家的头部 (包括潜行时) |
