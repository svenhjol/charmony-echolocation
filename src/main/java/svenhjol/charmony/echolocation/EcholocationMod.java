package svenhjol.charmony.echolocation;

import net.minecraft.resources.ResourceLocation;
import svenhjol.charmony.api.core.ModDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.api.core.Side;

@ModDefinition(
    id = EcholocationMod.ID,
    sides = {Side.Client, Side.Common},
    name = "Echolocation",
    description = "Library mod to show nearby entities and blocks.")
public final class EcholocationMod extends Mod {
    public static final String ID = "charmony-echolocation";
    private static EcholocationMod instance;

    private EcholocationMod() {}

    public static EcholocationMod instance() {
        if (instance == null) {
            instance = new EcholocationMod();
        }
        return instance;
    }

    public static ResourceLocation id(String path) {
        return ResourceLocation.fromNamespaceAndPath(ID, path);
    }
}