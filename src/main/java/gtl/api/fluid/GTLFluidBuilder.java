package gtl.api.fluid;

import gregtech.api.fluids.FluidBuilder;
import gregtech.api.fluids.FluidState;
import gregtech.api.fluids.attribute.FluidAttribute;
import gregtech.api.fluids.store.FluidStorageKey;

import gregtech.api.unification.material.Material;
import gtl.common.GTLInfomation;

import net.minecraftforge.fluids.Fluid;

import org.jetbrains.annotations.NotNull;

public class GTLFluidBuilder extends FluidBuilder {
    @Override public @NotNull GTLFluidBuilder name(@NotNull String name) { return (GTLFluidBuilder) super.name(name); }
    @Override public @NotNull GTLFluidBuilder translation(@NotNull String translationKey) { return (GTLFluidBuilder) super.translation(translationKey); }
    @Override public @NotNull GTLFluidBuilder state(@NotNull FluidState state) { return (GTLFluidBuilder) super.state(state); }
    @Override public @NotNull GTLFluidBuilder temperature(int temperature) { return (GTLFluidBuilder) super.temperature(temperature); }
    @Override public @NotNull GTLFluidBuilder color(int color) { return (GTLFluidBuilder) super.color(color); }
    @Override public @NotNull GTLFluidBuilder disableColor() { return (GTLFluidBuilder) super.disableColor(); }
    @Override public @NotNull GTLFluidBuilder density(int mcDensity) { return (GTLFluidBuilder) super.density(mcDensity); }
    @Override public @NotNull GTLFluidBuilder density(double density) { return (GTLFluidBuilder) super.density(density); }
    @Override public @NotNull GTLFluidBuilder luminosity(int luminosity) { return (GTLFluidBuilder) super.luminosity(luminosity); }
    @Override public @NotNull GTLFluidBuilder viscosity(int mcViscosity) { return (GTLFluidBuilder) super.viscosity(mcViscosity); }
    @Override public @NotNull GTLFluidBuilder viscosity(double viscosity) { return (GTLFluidBuilder) super.viscosity(viscosity); }
    @Override public @NotNull GTLFluidBuilder attribute(@NotNull FluidAttribute attribute) { return (GTLFluidBuilder) super.attribute(attribute); }
    @Override public @NotNull GTLFluidBuilder attributes(@NotNull FluidAttribute @NotNull... attributes) { return (GTLFluidBuilder) super.attributes(attributes); }
    @Override public @NotNull GTLFluidBuilder alternativeName(@NotNull String name) { return (GTLFluidBuilder) super.alternativeName(name); }
    @Override public @NotNull GTLFluidBuilder customStill() { return (GTLFluidBuilder) super.customStill(); }
    @Override public @NotNull GTLFluidBuilder customFlow() { return (GTLFluidBuilder) super.customFlow(); }
    @Override public @NotNull GTLFluidBuilder textures(boolean hasCustomStill, boolean hasCustomFlowing) { return (GTLFluidBuilder) super.textures(hasCustomStill, hasCustomFlowing); }
    @Override public @NotNull GTLFluidBuilder block() { return (GTLFluidBuilder) super.block(); }
    @Override public @NotNull GTLFluidBuilder disableBucket() { return (GTLFluidBuilder) super.disableBucket(); }

    @NotNull
    public Fluid gtlbuild(@NotNull String name, Material material, FluidStorageKey type) { return this.name(name).build(GTLInfomation.ModID, material, type); }

    @NotNull
    public Fluid gtlbuild(@NotNull String name, FluidStorageKey type) { return gtlbuild(name,null, type); }

    @NotNull
    public Fluid gtlbuild(@NotNull String name) { return gtlbuild(name, null); }
}