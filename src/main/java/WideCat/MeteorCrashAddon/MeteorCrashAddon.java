package WideCat.MeteorCrashAddon;

import WideCat.MeteorCrashAddon.modules.*;
import meteordevelopment.meteorclient.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.systems.modules.Category;
import net.minecraft.item.Items;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.lang.invoke.MethodHandles;
import meteordevelopment.meteorclient.MeteorClient;

public class MeteorCrashAddon extends MeteorAddon {
    public static final Logger LOG = LogManager.getLogger();
    public static final Category CATEGORY = new Category("Crash", Items.TNT.getDefaultStack());

    @Override
    public void onInitialize() {
        LOG.info("Initializing Meteor Crash Addon");

        MeteorClient.EVENT_BUS.registerLambdaFactory("widecat.meteorcrashaddon", (lookupInMethod, klass) -> (MethodHandles.Lookup) lookupInMethod.invoke(null, klass, MethodHandles.lookup()));

        Modules.get().add(new BoatCrash());
        Modules.get().add(new EntityCrash());
        Modules.get().add(new InvalidPositionCrash());
        Modules.get().add(new LoginCrash());
        Modules.get().add(new MovementCrash());
        Modules.get().add(new PacketSpammer());
        Modules.get().add(new SignCrash());
        Modules.get().add(new TryUseCrash());

    }

    @Override
    public void onRegisterCategories(){
        Modules.registerCategory(CATEGORY);
    }
}