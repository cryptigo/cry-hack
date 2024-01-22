package cryhack;

import cryhack.module.Mod;
import cryhack.module.ModuleManager;
import cryhack.ui.screens.clickgui.ClickGUI;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.glfw.GLFW;

public class Client implements ModInitializer {

    public static final Client INSTANCE = new Client();
    public Logger logger = LogManager.getLogger(Client.class);

    private MinecraftClient mc = MinecraftClient.getInstance();

    @Override
    public void onInitialize() {
        logger.info("Initialized client.");
    }

    public void onKeyPress(int key, int action) {
        if (action == GLFW.GLFW_PRESS) {
            for (Mod module : ModuleManager.INSTANCE.getModules()) {
                if (key == module.getKey()) module.toggle();
            }
        }
        // TODO: Check if the player is in-game or not
        if (key == GLFW.GLFW_KEY_RIGHT_SHIFT) {
            mc.setScreen(ClickGUI.INSTANCE);
        }
    }

    public void onTick() {
        if (mc.player != null) {
            for (Mod module : ModuleManager.INSTANCE.getEnabledModules()) {
                module.onTick();
            }
        }
    }
}
