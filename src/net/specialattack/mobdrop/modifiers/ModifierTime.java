
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ModifierTime implements IModifier {

    public double modifier = 0.0D;
    public int startTime;
    public int endTime;

    public ModifierTime(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 2) {
            long time = player.getWorld().getTime();
            if (time > this.startTime && time <= this.endTime) {
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
