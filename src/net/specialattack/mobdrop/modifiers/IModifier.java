
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public interface IModifier {

    public double getModified(Player player, Entity entity, double original, int pass);

    public String modifyName(Entity entity, String original, int pass);

}
