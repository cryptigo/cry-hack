package cryhack.module;

import cryhack.module.Mod.Category;
import cryhack.module.movement.Flight;
import cryhack.module.movement.Sprint;
import cryhack.module.render.FullBright;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static final ModuleManager INSTANCE = new ModuleManager();
    private List<Mod> modules = new ArrayList<>();

    public ModuleManager() {
        addModules();
    }

    public List<Mod> getModules() {
        return modules;
    }

    public List<Mod> getEnabledModules() {
        List<Mod> enabled = new ArrayList<>();
        for (Mod mod : modules) {
            if (mod.isEnabled()) enabled.add(mod);
        }

        return enabled;
    }

    public List<Mod> getModulesInCategory(Category category) {
        List<Mod> categoryModules = new ArrayList<>();

        for (Mod mod : modules) {
            if (mod.getCategory() == category) {
                categoryModules.add(mod);
            }
        }
        return categoryModules;
    }

    private void addModules() {

        modules.add(new Flight());
        modules.add(new Sprint());
        modules.add(new FullBright());
    }
}
