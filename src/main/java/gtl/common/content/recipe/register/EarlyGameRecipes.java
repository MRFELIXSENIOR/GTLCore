package gtl.common.content.recipe.register;

import gregtech.api.recipes.GTRecipeHandler;
import gregtech.api.recipes.ModHandler;
import gregtech.api.recipes.RecipeMaps;
import gregtech.api.unification.OreDictUnifier;
import gregtech.api.unification.material.Materials;
import gregtech.api.unification.ore.OrePrefix;
import gregtech.common.items.MetaItems;

import gtl.api.metaitem.GTLMetaItem;
import gtl.common.content.item.GTLMetaItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EarlyGameRecipes {
    public static void init() {
        removeRecipes();
        registerRubberRecipes();
    }

    //please fold this abomination
    private static void registerVulcanizingAgentRecipes() {
        ItemStack[][] vulcanizingAgentRecipes = {
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Ash, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(4)
                },
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Coal, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Ash, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(5)
                },
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Carbon, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Ash, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(6)
                },
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Charcoal, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(2)
                },
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Coal, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(3)
                },
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Carbon, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(4)
                },
                {
                        OreDictUnifier.get(OrePrefix.dust, Materials.Sulfur, 1),
                        OreDictUnifier.get(OrePrefix.dust, Materials.Ash, 1),
                        GTLMetaItems.VulcanizingAgent.getStackForm(2)
                },
        };

        for (ItemStack[] vulcanizingAgentRecipe : vulcanizingAgentRecipes) {
            int resultLocation = vulcanizingAgentRecipe.length - 1;
            ItemStack[] itemStacks = new ItemStack[resultLocation];
            //get everything except the recipe result
            System.arraycopy(vulcanizingAgentRecipe, 0, itemStacks, resultLocation, resultLocation);

            ModHandler.addShapelessRecipe(
                    "vulcanizing_agent",
                    vulcanizingAgentRecipe[resultLocation],
                    itemStacks
            );

            RecipeMaps.MIXER_RECIPES.recipeBuilder()
                    .inputs(itemStacks)
                    .output(vulcanizingAgentRecipe[resultLocation].getItem())
                    .buildAndRegister();

        }
    }

    private static void registerRubberRecipes() {
        registerVulcanizingAgentRecipes();

        ModHandler.addShapelessRecipe(
                "crude_latex_sludge",
                GTLMetaItems.CrudeLatexSludge.getStackForm(2),
                MetaItems.STICKY_RESIN.getStackForm(1), new ItemStack(Items.CLAY_BALL, 1)
        );

        ModHandler.addShapelessRecipe(
                "raw_rubber_mix",
                GTLMetaItems.CrudeRubberMix.getStackForm(2),
                GTLMetaItems.VulcanizingAgent.getStackForm(1), GTLMetaItems.CrudeLatexSludge.getStackForm(1)
        );

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(GTLMetaItems.CrudeRubberMix, 1)
                .input(MetaItems.SHAPE_MOLD_INGOT)
                .output(OrePrefix.ingot, Materials.Rubber)
                .buildAndRegister();

        RecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .input(GTLMetaItems.CrudeRubberMix, 1)
                .input(MetaItems.SHAPE_MOLD_PLATE)
                .output(OrePrefix.plate, Materials.Rubber)
                .buildAndRegister();
    }

    private static void removeRecipes() {
        GTRecipeHandler.removeRecipesByInputs(RecipeMaps.CENTRIFUGE_RECIPES, MetaItems.STICKY_RESIN.getStackForm());
    }
}