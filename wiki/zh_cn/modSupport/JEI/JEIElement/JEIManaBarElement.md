# JEIManaBarElement

继承 [JEIElement](JEIElement.md), 因此 `JEIElement` 的全部可用 `Getter` 和 `Setter` 都可被使用

## 导包

```zenscript
import mods.randomtweaker.jei.JEIManaBarElement;
```

## ZenGetterAndZenSetter

| ZenGetter / ZenSetter  | 返回类型 | 描述 |
| :-------- | :----- | ------------------------------ |
| mana      | int    | 魔力条的魔力ֵ |
| log_multiple (没有 ZenSetter) | int | 最大魔力值默认与稀释魔力池的魔力值相同，该值为以10为底的实际最大魔力值扩大倍数的对数 |
