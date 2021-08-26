# Prop

Allow manipulation of a file for Map-style input and output (needs to be enabled in the configuration file)

## Import

```zenscript
import mods.randomtweaker.Prop;
```

## Methods

| Method | Return Type | Description |
| :----- | :----- | :---- |
| read(key as string) | string   | Read |
| write(key as string, value as string) | bool | Write |
| getAllKeys() | string[] | Read all Keys in the file |
