# Custom JEI

导包：

~~~zenscript
import mods.jei.JEI;
~~~

| 方法                                                         | 返回值             | 备注                                                         |
| :----------------------------------------------------------- | :----------------- | ------------------------------------------------------------ |
| createJEIPanel(String uid, String localizationKey)           | JEIPanel           |                                                              |
| createJEIBackground(int width, int heigh)                    | JEIBackground      |                                                              |
| createJEIBackground(String resourceName, int u, int v, int width, int heigh) | JEIBackground      |                                                              |
| createLiquidSlot(boolean isInput, int x, int y, int width, int heigh, int capacityMb, boolean showCapacity, @Optional(valueBoolean = true) boolean hasBase) | JEILiquidSlotImpl  | hasBase则为是否创建那个固定的流体槽，但流体槽必须要根据固定的宽高创建（eg：16 * 16，43 * 16， 16 * 34） |
| createLiquidSlot(boolean isInput, int x, int y, @Optional(valueBoolean = true) boolean hasBase) | JEILiquidSlotImpl  | hasBase则为是否创建那个固定的流体槽，但流体槽必须要根据固定的宽高创建（eg：16 * 16，43 * 16， 16 * 34） |
| createItemSlot(boolean isInput, int x, int y, @Optional(valueBoolean = true) boolean hasBase) | JEIItemSlot        | hasBase则为是否创建那个固定的物品槽                          |
| createJEIRecipe(IIngredient[] inputs, IIngredient[] outputs) | JEIRecipe          |                                                              |
| createJEIRecipe(IIngredient[] inputs)                        | JEIRecipe          |                                                              |
| createJEIItemInputElement(int x, int y)                      | JEIItemElement     |                                                              |
| createJEIItemOutputElement(int x, int y)                     | JEIItemElement     |                                                              |
| createJEIFluidElement(int x, int y, int width, int heigh)    | JEIFluidElement    |                                                              |
| createJEIFontInfoElement(int x, int y, String info, int color) | JEIFontInfoElement |                                                              |
| createJEIArrowElement(int x, int y, int direction)           | JEIArrowElement    | direaction参数为四个箭头，可填0-3                            |
| createJEICustomElement(int x, int y, int width, int heigh, int u, int v, String texture) | JEICustomElement   | texture的格式为modid:路径                                    |

# JEIPanel

自定义JEI面板。

导包：

~~~zenscript
import mods.randomtweaker.JEIPanel;
~~~
| ZenGetter       | 返回值        |
| :-------------- | :------------ |
| uid             | String        |
| localizationKey | String        |
| modid           | String        |
| icon            | IItemStack    |
| JEIBackground   | JEIBackground |
| recipeCatalysts | IItemStack[]  |
| JEISlots        | JEISlot[]     |
| JEIRecipes      | JEIRecipe[]   |
| JEIElements     | JEIElement[]  |

| 方法                                             | 返回值 | 备注                                                   |
| :----------------------------------------------- | :----- | ------------------------------------------------------ |
| setModID(String modid)                           | void   | 显示的模组名                                           |
| setIcon(IItemStack icon)                         | void   | 显示在最上面的物品                                     |
| setJEIBackGroup(JEIBackground JEIBackground)     | void   | 设置背景（可以自定义图片）                             |
| setJEIBackGroup(int width, int heigh)            | void   | 设置背景（基本）                                       |
| setRecipeCatalysts(IItemStack[] recipeCatalysts) | void   | 设置左侧显示的全部物品                                 |
| setJEISlots(JEISlot[] JEISlots)                  | void   | 设置槽位                                               |
| setJEIRecipes(JEIRecipe[] JEIRecipes)            | void   | 设置配方（必须要和配方对应，否则出任何问题不给予修复） |
| setJEIElements(JEIElement[] JEIElements)         | void   | 设置元素                                               |
| addJEISlot(JEISlot JEIISlot)                     | void   | 添加槽位                                               |
| addRecipeCatalyst(IItemStack recipeCatalyst)     | void   | 添加显示在左侧的物品                                   |
| addJEIRecipe(JEIRecipe JEIRecipe)                | void   | 添加配方                                               |
| addJEIElement(JEIElement JEIElement)             | void   | 添加元素                                               |
| register()                                       | void   | 注册                                                   |

# JEIBackground

JEI的背景设置，可以仅设置宽高。

导包：

~~~zenscript
import mods.randomtweaker.JEIBackground;
~~~

| ZenGetter    | 返回值 |
| :----------- | :----- |
| resourceName | String |
| u            | int    |
| v            | int    |
| width        | int    |
| heigh        | int    |

# JEISlot

在JEI上存放数据的槽位，目前仅支持流体和物品槽的渲染。

导包：

~~~zenscript
import mods.randomtweaker.JEISlot;
~~~

| ZenGetter | 返回值  |
| :-------- | :------ |
| isInput   | boolean |
| x         | int     |
| y         | int     |
| hasBase   | boolean |

## JEILiquidSlot

继承自`JEISlot`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEILiquidSlot;
~~~

| ZenGetter    | 返回值  |
| :----------- | :------ |
| width        | int     |
| heigh        | int     |
| capacityMb   | int     |
| showCapacity | boolean |

## JEIItemSlot

继承自`JEISlot`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEIItemSlot;
~~~

# JEIElement

导包：

~~~zenscript
mods.randomtweaker.JEIElement;
~~~

渲染在JEI上的元素，流体槽，物品槽的框都是自此渲染。

| ZenGetter                                                    | 返回值 |
| :----------------------------------------------------------- | :----- |
| u                                                            | int    |
| v                                                            | int    |
| x                                                            | int    |
| y                                                            | int    |
| width                                                        | int    |
| heigh                                                        | int    |
| texture (default : "randomtweaker:textures/gui/jei/jei_default.png") | String |

## JEIFontInfoElement

继承自`JEIElement`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEIFontInfoElement;
~~~

| ZenGetter | 返回值 |
| :-------- | :----- |
| info      | string |
| color     | int    |

## JEIArrowElement

继承自`JEIElement`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEIArrowElement;
~~~

| ZenGetter | 返回值 | 备注                              |
| :-------- | :----- | --------------------------------- |
| direction | int    | direaction参数为四个箭头，可填0-3 |

## JEIFluidElement

继承自`JEIElement`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEIFluidElement;
~~~

## JEIItemElement

继承自`JEIElement`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEIItemElement;
~~~

## JEICustomElement

继承自`JEIElement`，因此`JEISlot`的全部`Getter`都可被使用。

导包：

~~~zenscript
mods.randomtweaker.JEICustomElement;
~~~

---

例子：

```zenscript
var keyJEI as JEIPanel = JEI.createJEIPanel("keys", "key");
keyJEI.setJEIBackGroup(JEI.createJEIBackground(150, 50));
keyJEI.addRecipeCatalyst(<minecraft:stone:3>);
keyJEI.addRecipeCatalyst(<minecraft:stone:1>);
keyJEI.addJEISlot(JEI.createItemSlot(true, 16, 18));
keyJEI.addJEISlot(JEI.createItemSlot(false, 80, 18));
keyJEI.addJEIElement(JEI.createJEIFontInfoElement(50, 18, 0));
keyJEI.addJEIElement(JEI.createJEIFontInfoElement(100, 18, "fontInfo", 0x52575B));
keyJEI.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple>], [<minecraft:stone>]));
keyJEI.addJEIRecipe(JEI.createJEIRecipe([<minecraft:gold_ingot>], [<minecraft:stone>]));
keyJEI.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 4], [<minecraft:stone>]));
keyJEI.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 5], [<minecraft:stone>]));
keyJEI.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 6], [<minecraft:stone>]));
keyJEI.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 7], [<minecraft:stone>]));
keyJEI.register();


var keyJEI1 as JEIPanel = JEI.createJEIPanel("keys1", "key1");
keyJEI1.setJEIBackGroup(JEI.createJEIBackground(150, 50));
keyJEI1.addRecipeCatalyst(<minecraft:apple>);
keyJEI1.addRecipeCatalyst(<minecraft:stick>);
keyJEI1.addJEISlot(JEI.createItemSlot(true, 16, 18));
keyJEI1.addJEISlot(JEI.createItemSlot(false, 50, 18));
keyJEI1.addJEISlot(JEI.createLiquidSlot(true, 100, 18, 16, 34, 1000, false));
keyJEI1.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 3, <liquid:water> * 100], [<minecraft:stick> * 20]));
keyJEI1.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 3, <liquid:lava> * 100], [<minecraft:stick> * 20]));
keyJEI1.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 3, <liquid:purified_water> * 100], [<minecraft:stick> * 20]));
keyJEI1.addJEIRecipe(JEI.createJEIRecipe([<minecraft:apple> * 3, <liquid:rubber> * 100], [<minecraft:stick> * 20]));
keyJEI1.register();
```

