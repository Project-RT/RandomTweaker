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
| log_multiple (no ZenSetter) | int | default max mana value is equal to the max mana value of dilute mana pool��it takes logarithm to the base 10 of max mana value |
