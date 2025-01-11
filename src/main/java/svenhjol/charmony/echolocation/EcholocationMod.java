package svenhjol.charmony.echolocation;

import net.minecraft.resources.ResourceLocation;
import svenhjol.charmony.core.annotations.ModDefinition;
import svenhjol.charmony.core.base.Mod;
import svenhjol.charmony.core.enums.Side;

@ModDefinition(
    id = EcholocationMod.ID,
    sides = {Side.Client, Side.Common},
    name = "Echolocation",
    description = "")
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