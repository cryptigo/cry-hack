package cryhack.module.movement;

import cryhack.module.Mod;
import cryhack.module.settings.BooleanSetting;
import cryhack.module.settings.ModeSetting;
import cryhack.module.settings.NumberSetting;
import org.lwjgl.glfw.GLFW;

public class Flight extends Mod {

    public NumberSetting speed = new NumberSetting("Speed", 0, 10, 1, 0.1);

    private int tickCounter = 0;

    public Flight() {
        super("Flight", "Allows you to fly", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_F);
        addSettings(speed);
    }

    @Override
    public void onTick() {
        if (mc.world == null || mc.player == null) return;
        float flySpeed = speed.getValueFloat();
        mc.player.getAbilities().flying = true;
        mc.player.getAbilities().allowFlying = true;
        mc.player.getAbilities().setFlySpeed(flySpeed / 10f);
        super.onTick();
    }

    @Override
    public void onDisable() {
        super.onDisable();

//        boolean creative = mc.player.isCreative();
//        mc.player.getAbilities().flying = false;
        mc.player.getAbilities().allowFlying = false;
    }

    private void resetKeyPresses() {
        mc.options.jumpKey.setPressed(false);
        mc.options.sprintKey.setPressed(false);
    }


}
