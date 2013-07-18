
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ModifierPermission implements IModifier {

    public final EntityType type;
    public double modifier = 1.0D;
    public String permission;

    public ModifierPermission(EntityType type, String permission) {
        this.type = type;
        this.permission = permission;
    }

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 1) {
            if (entity.getType() == this.type && player.hasPermission("mobdrop.bounty." + this.permission)) {
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
