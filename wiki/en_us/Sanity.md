# Sanity

A sanity checker, which displays a picture of the sanity value on the left side of the left hand,
with four levels to check the player's sanity value and display the different pictures. Also added a
crystal to check sanity value, combined with the CrT‘s event you can make the function you want.

For more, see [IPlayerExpansion](IPlayerExpansion.md#sanity)

## Import

```zenscript
import mods.randomtweaker.PlayerSanityChangeEvent;
```

## Extending IEventCancelable

The `PlayerSanityChangeEvent` event extends
the [IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/),
so their `methods`, `getters` and `setters` can all be called.

## Getter

| Getter  | Return Type |
| :------------- | :------ |
| player         | [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/) |
| sanity         | float   |
| originalSanity | int     |

## Call

You can use the `events` keyword to access this event.

| Event | Description |
| :------- | :-------- |
| onPlayerSanityChange(function(event as PlayerSanityChangeEvent) {}) | Triggered when the player's sanity value is modified (OriginalSanity value  isn’t triggered when it is modified) |
