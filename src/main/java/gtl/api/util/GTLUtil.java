package gtl.api.util;

import gtl.common.GTLInfomation;

import net.minecraft.util.ResourceLocation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GTLUtil {
    public static final Logger GTLLogger = LogManager.getLogger("GTLCore");
    public static ResourceLocation toGTLName(String name) { return new ResourceLocation(GTLInfomation.ModID, name); }
}
