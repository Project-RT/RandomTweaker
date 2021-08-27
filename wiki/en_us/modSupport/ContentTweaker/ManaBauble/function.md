# Function

## Import (second packet for functions with return values other than void, third packet for rendering)

```zenscript
import mods.randomtweaker.cote.BaubleFunction;
import mods.randomtweaker.cote.BaubleFunctionWithReturn;
import mods.randomtweaker.cote.PlayerBaubleRender;
```

## onWornTick

After wearing the bauble every Tick is called

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Current bauble

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  Wearer

```zenscript
manaBaubleObj.onWornTick = function((bauble, wearer) {

};
```

## canEquip

Decide if the bauble can be worn on

Need to return a bool value

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Current bauble

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  wearer

```zenscript
manaBaubleObj.canEquip = function((bauble, wearer) {
    return true;
};
```

## canUnEquip

Decide whether or not the bauble can be unworn

Need to return a bool value

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Current bauble

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  wearer

```zenscript
manaBaubleObj.canUnEquip = function((bauble, wearer) {
    return true;
};
```

## onEquipped

Called when the player is wearing an bauble

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Current bauble

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  wearer

```zenscript
manaBaubleObj.onEquipped = function((bauble, wearer) {
    
};
```

## onUnequipped

Called when the player is not wearing an bauble

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Current bauble

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  wearer

```zenscript
manaBaubleObj.onUnequipped = function((bauble, wearer) {
    
};
```

## willAutoSync

When the NBT or Damage of a bauble is changed, is the bauble automatically synced to the client (10 Tick sync once)

Need to return a bool value

* bauble as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Current bauble

* wearer
  as [IEntityLivingBase](https://docs.blamejared.com/1.12/en/Vanilla/Entities/IEntityLivingBase/)
  wearer

```zenscript
manaBaubleObj.willAutoSync = function((bauble, wearer) {
    return false;
};
```

## onPlayerBaubleRender

This function is used to render the bauble when it is in the player's bauble bar

Only simple rendering is currently available, For details of the rendering method, please
see [BaubleRenderHelper](BaubleRenderHelper.md)

* stack as [IItemStack](https://docs.blamejared.com/1.12/en/Vanilla/Items/IItemStack/) Bauble
* player as [IPlayer](https://docs.blamejared.com/1.12/en/Vanilla/Players/IPlayer/) Players who wear bauble
* renderType as string `HEAD` or `BODY`
* partialTicks as float How many Tick left until the next Tick (usually less than 1)

```zenscript
manaBaubleObj.onPlayerBaubleRender = function((stack, player, renderType, partialTicks) {
    
};
```
