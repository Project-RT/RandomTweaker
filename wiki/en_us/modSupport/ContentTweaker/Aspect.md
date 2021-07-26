# Aspect

Enables `CoT` to customize aspects when both `ThaumCraft` and `CoT` are installed

## Import

```zenscript
import mods.randomtweaker.cote.Aspect;
```

| Feild | Type | Description |
| :--- | ---- | --- |
| tag | string | Unique name of this aspect |
| color | int | Color of this aspect |
| image | string | Path to aspect texture (default contenttweaker:textures/aspects/all-lowercase tag.png, create one yourself if you don't have a folder, use `:` to split the main file name and path if you want to fill in another path) |
| components | string[] | Which two aspects does this aspect craft from (fill in only two aspects) |
| blend | int |  |

## Method

| Method | Type | Description |
|:---- |:---- |---- |
| register() | void | Register this aspect |

## Example

```zenscript
#loader contenttweaker
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Aspect;

var aspect as Aspect = VanillaFactory.createAspect("test", 0x4169E1);
aspect.register();

```
