# JEIManaBarElement

JEIManaBarElement extends from [JEIElement](JEIElement.md), so all available `Getters` and `Setter`
of `JEIElement` can be used

## Import

```zenscript
import mods.randomtweaker.jei.JEIManaBarElement;
```

## ZenGetterAndZenSetter

| ZenGetter / ZenSetter  | Return | Remarks |
| :-------- | :----- | ------------------------------ |
| mana      | int    | mana is the mana value in mana bar |
| log_multiple(no ZenSetter) | int | default max mana value is equal to the max mana value of dilute mana pool. And this value takes logarithm to the base 10 of mutilple of actual max mana value |
| mode      | int    | the mana bar mode. 1 to the original mode of botania, 0 to the more complex mode using log_multiple argument(btw, I really think this mode is more user-friendly. \_(:з」∠)\_) |
