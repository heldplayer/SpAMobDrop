
package net.specialattack.mobdrop.modifiers;

import net.specialattack.mobdrop.SpAMobDrop;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ModifierSpawner implements IModifier {

    public double modifier = 0.0D;

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 2) {
            if (SpAMobDrop.instance.spawnedMobs.contains(entity)) {
                return original * this.modifier;
            }
        }
        return original;
    }

    @Override
    public String modifyName(Entity entity, String original, int pass) {
        return original;
    }

}
