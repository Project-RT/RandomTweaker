# JEIManaBarElement

继承 `JEIElement`, 因此 `JEISlot` 的全部可用 `Getter` 都可被使用

## 导包

```zenscript
import mods.randomtweaker.jei.JEIManaBarElement;
```

| ZenGetter / ZenSetter  | 返回值 | 备注 |
| :-------- | :----- | ------------------------------ |
| mana      | int    | mana 参数为魔力条的魔力值 |
| log_multiple（无ZenSetter） | int | 魔力条默认的最大魔力值与稀释魔力池的总魔力值相同，该值为的以10为底总魔力值扩大倍数的对数 |

