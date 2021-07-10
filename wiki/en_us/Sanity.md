# Sanity

A sanity checker, which displays a picture of the sanity value on the left side of the left hand, with four levels to check the player's sanity value and display the different pictures. Also added a crystal to check sanity value, combined with the CrT‘s event you can make the function you want.

For more, see [IPlayerExpansion](https://github.com/ikexing-cn/RandomTweaker/blob/master/wiki/en_us/IPlayerExpansion.md)

## Import

~~~zenscript
import mods.randomtweaker.PlayerSanityChangeEvent;
~~~

## PlayerSanityChangeEvent

The `PlayerSanityChangeEvent` implement the following interfaces, so their `methods`, `getters` and `setters` can all be called.

[IEventCancelable](https://docs.blamejared.com/1.12/en/Vanilla/Events/Events/IEventCancelable/)

| Getter  | **Return Type** |
| :------------- | :------ |
| player         | [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/) |
| sanity         | float   |
| originalSanity | int     |

You can use the `events` keyword to access this event.

| Event                                                        | Description                                                  |
| ------------------------------------------------------------ | ------------------------------------------------------------ |
| onPlayerSanityChange(function(event as PlayerSanityChangeEvent) {}) | Triggered when the player's sanity value is modified (OriginalSanity value  isn’t triggered when it is modified ! ) |
