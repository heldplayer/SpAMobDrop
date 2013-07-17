
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ModifierChargedCreeper implements IModifier {

    public double modifier = 0.0D;

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 2) {
            if (entity instanceof Creeper && ((Creeper) entity).isPowered()) {
                return original * this.modifier;
            }
        }
        return original;
    }

    @Override
    public String modifyName(Entity entity, String original, int pass) {
        if (pass == 2) {
            if (entity instanceof Creeper && ((Creeper) entity).isPowered()) {
                return "Charged " + original;
            }
        }
        return original;
    }

}
