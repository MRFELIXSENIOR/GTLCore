package gtl.common.content.fluid.register;

import gtl.api.fluid.GTLFluidBuilder;

import static gtl.common.content.fluid.GTLFluids.*;

public class EarlyGameFluids {
    public static void preInit() {
        Latex = new GTLFluidBuilder()
                .color(0xEFF2EF)
                .density(2.5)
                .gtlbuild("latex");

        PrecipitatedRubberConcentrate = new GTLFluidBuilder()
                .color(0x53555A)
                .density(1)
                .gtlbuild("precipitated_rubber_concentrate");
    }
}