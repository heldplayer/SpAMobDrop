
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Ageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

public class ModifierBaby implements IModifier {

    public double modifier = 0.0D;
    public boolean monster;

    public ModifierBaby(boolean monster) {
        this.monster = monster;
    }

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 2) {
            if (this.monster) {
                if (entity instanceof Zombie && ((Zombie) entity).isBaby()) {
                    return original * this.modifier;
                }
            }
            else {
                if (entity instanceof Ageable && !((Ageable) entity).isAdult()) {
                    return original * this.modifier;
                }
            }
        }
        return original;
    }

    @Override
    public String modifyName(Entity entity, String original, int pass) {
        if (pass == 2) {
            if (this.monster) {
                if (entity instanceof Zombie && ((Zombie) entity).isBaby()) {
                    return "Baby " + original;
                }
            }
            else {
                if (entity instanceof Ageable && !((Ageable) entity).isAdult()) {
                    return "Baby " + original;
                }
            }
        }
        return original;
    }

}
