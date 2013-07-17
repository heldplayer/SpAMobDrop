
package net.specialattack.mobdrop.modifiers;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;

public class ModifierWitherSkeleton implements IModifier {

    public double modifier = 0.0D;

    @Override
    public double getModified(Player player, Entity entity, double original, int pass) {
        if (pass == 2) {
            if (entity instanceof Skeleton && ((Skeleton) entity).getSkeletonType() == SkeletonType.WITHER) {
                return original * this.modifier;
            }
        }
        return original;
    }

    @Override
    public String modifyName(Entity entity, String original, int pass) {
        if (pass == 2) {
            if (entity instanceof Skeleton && ((Skeleton) entity).getSkeletonType() == SkeletonType.WITHER) {
                return "Wither " + original;
            }
        }
        return original;
    }

}
