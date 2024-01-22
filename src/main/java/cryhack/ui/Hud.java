package cryhack.ui;

import cryhack.module.Mod;
import cryhack.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;

import java.awt.*;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;

public class Hud {

    private static MinecraftClient mc = MinecraftClient.getInstance();

    public static void render(MatrixStack matrices, float tickDelta) {
        renderClientInfo(matrices);
        renderArrayList(matrices);

    }

    public static void renderArrayList(MatrixStack matrices) {
        int index = 0;
        int sWidth = mc.getWindow().getScaledWidth();
        int sHeight = mc.getWindow().getScaledHeight();

        List<Mod> enabled = ModuleManager.INSTANCE.getEnabledModules();

        enabled.sort(Comparator.comparingInt(m -> (int)mc.textRenderer.getWidth(((Mod)m).getDisplayName())).reversed());

        for (Mod mod : enabled) {
            mc.textRenderer.drawWithShadow(matrices, mod.getDisplayName(), (sWidth - 4) - mc.textRenderer.getWidth(mod.getDisplayName()), 10 + (index * mc.textRenderer.fontHeight), -1);
            index++;
        }
    }

    public static void renderClientInfo(MatrixStack matrices) {
        // Draw the first part of the text
        mc.textRenderer.drawWithShadow(matrices, "Cry", 5, 5, Color.red.getRGB());

        // Calculate the width of the "Cry" text
        int textWidth1 = mc.textRenderer.getWidth("Cry");

        // Draw the rest of the text starting from the end of the "Cry" text.
        mc.textRenderer.drawWithShadow(matrices, "Hack - v0.0.1 ", 5 + textWidth1 + 1, 5, Color.white.getRGB());

        // Draw the development tag in green
        int textWidth2 = textWidth1 + mc.textRenderer.getWidth("Hack v0.0.1 ") + 2;
        mc.textRenderer.drawWithShadow(matrices, "[DEVELOPMENT BUILD]", 5 + textWidth2 + 1, 5, Color.green.getRGB());
    }
}
