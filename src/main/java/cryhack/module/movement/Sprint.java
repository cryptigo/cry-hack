package cryhack.module.movement;

import cryhack.module.Mod;
import org.lwjgl.glfw.GLFW;

// TODO: Fix issue where player doesn't stop flying after the module is disabled

public class Sprint extends Mod {

    public Sprint() {
        super("Sprint", "Keeps your sprint", Category.MOVEMENT);
        this.setKey(GLFW.GLFW_KEY_V);
    }

    @Override
    public void onTick() {
        if (mc.player != null) {
            mc.player.setSprinting(true);
        }
        super.onTick();
    }
}
