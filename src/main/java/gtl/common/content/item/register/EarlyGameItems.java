package gtl.common.content.item.register;

import gtl.api.metaitem.GTLMetaItem;

import static gtl.common.content.item.GTLMetaItems.*;

public class EarlyGameItems {
    public static void preInit() {
        VulcanizingAgent = GTLMetaItem.addItem("earlygame.vulcanizing_agent");
        CrudeLatexSludge = GTLMetaItem.addItem("earlygame.crudelatexsludge");
        CrudeRubberMix = GTLMetaItem.addItem("earlygame.cruderubbermixture");
    }
}