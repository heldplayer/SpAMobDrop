
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

public class ModifierZombieVillager implements IModifier {

    public double modifier = 0.0D;

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 2) {
            if (entity instanceof Zombie && ((Zombie) entity).isVillager()) {
                return original * this.modifier;
            }
        }
        return original;
    }

    @Override
    public String modifyName(Entity entity, String original, int pass) {
        if (pass == 2) {
            if (entity instanceof Zombie && ((Zombie) entity).isVillager()) {
                return original + " Villager";
            }
        }
        return original;
    }

}
