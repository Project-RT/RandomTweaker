# Aspect

Enables `CoT` to customize aspects when both `ThaumCraft` and `CoT` are installed

## Import

```zenscript
import mods.randomtweaker.cote.Aspect;
```

## Feild

| Feild | Type | Description |
| :--- | ---- | --- |
| tag | string | Unique name of this aspect |
| color | int | Color of this aspect |
| image | string | Path of aspect (Default path contenttweaker:textures/aspects/(all-lowercase)tag.png) |
| components | string[] | Which two aspects does this aspect craft from (fill in two aspects) |
| blend | int | ? |

## Methods

| Method | Description |
| :---- | :---- |
| register() | Register this aspect |

## Example

```zenscript
#loader contenttweaker
import mods.mods.contenttweaker.VanillaFactory;
import mods.randomtweaker.cote.Aspect;

var aspect as Aspect = VanillaFactory.createAspect("test", 0x4169E1);
aspect.register();
```
