# BaubleRenderHelper

The content of this chapter is highly recommended for players to test it on your own.

## Import

```zenscript
import mods.randomtweaker.BaubleRenderHelper;
```

## Static Methods

| Static Methods | Description |
| :------ | :------ |
| bindTexture(@Optional("minecraft:textures/atlas/blocks.png") resourceLocation as string) | resourceLocation is the path to the texture to be bound |
| defaultTransforms() | Reduce the rendering of the baubles to normal size (any rendering will work) |
| scale(x as double, y as double, z as double) | Stretch the scale of the baubles by x y z pixels|
| translate(x as double, y as double, z as double) | Offset the baubles by x y z pixels |
| rotate(angle as float, x as float, y as float, z as float) | Rotate the baubles, the first parameter is the angle, the next three parameters are angle * parameters |
| renderItem(stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/), @Optional("NONE") transformType as string) | Render items, The first parameter fills in the baubles to be rendered, The second parameter has the following `NONE`, `THIRD_PERSON_LEFT_HAND`, `THIRD_PERSON_RIGHT_HAND`, `FIRST_PERSON_LEFT_HAND`, `FIRST_PERSON_RIGHT_HAND`, `HEAD`, `GUI`, `GROUND`, `FIXED` |

### Used on `BODY`

| Static Methods | Description |
| :------ | :------ |
| translateToChest() | Renders the baubles to the player's chest correctly (usually called after the `rotateIfSneaking` method) |
| rotateIfSneaking(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | Whether or not baubles rotation is rendered normally when the player is sneaking |

### Used on `HEAD`

| Static Methods | Description |
| :------ | :------ |
| translateToFace() | Renders the baubles to the player's face correctly (usually called after the `translateToHeadLevel` method) |
| translateToHeadLevel(player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/)) | Render baubles to the player's head correctly (including when sneaking) |
