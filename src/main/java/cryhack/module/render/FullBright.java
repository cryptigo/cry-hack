package cryhack.module.render;

import cryhack.module.Mod;
import cryhack.module.settings.NumberSetting;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

import java.util.Objects;

import static org.lwjgl.glfw.GLFW.*;

public class FullBright extends Mod {

    public FullBright() {
        super("FullBright", "Allows you to see in the dark", Category.RENDER);
        this.setKey(GLFW_KEY_G);
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            mc.player.addStatusEffect(new StatusEffectInstance(Objects.requireNonNull(StatusEffects.NIGHT_VISION), Integer.MAX_VALUE, 1, false, false, false));
        }
        super.onTick();
    }

    @Override
    public void onDisable() {
        if (mc.player != null) {
            mc.player.removeStatusEffect(Objects.requireNonNull(StatusEffects.NIGHT_VISION));
        }
        super.onDisable();
    }
}
