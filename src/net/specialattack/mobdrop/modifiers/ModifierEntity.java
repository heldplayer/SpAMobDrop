
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class ModifierEntity implements IModifier {

    public final EntityType type;
    public double baseMoney = 0.0D;

    public ModifierEntity(EntityType type) {
        this.type = type;
    }

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 0) {
            if (entity.getType() == type) {
                return this.baseMoney;
            }
        }
        return original;
    }

    @Override
    public String modifyName(Entity entity, String original, int pass) {
        if (pass == 0) {
            if (entity.getType() == type) {
                return type.getName();
            }
        }
        return original;
    }

}
