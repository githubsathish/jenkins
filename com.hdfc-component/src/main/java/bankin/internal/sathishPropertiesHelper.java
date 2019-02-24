package bankin.internal;

import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import bankin.sathishConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for sathish component.
 */
public final class sathishPropertiesHelper extends ApiMethodPropertiesHelper<sathishConfiguration> {

    private static sathishPropertiesHelper helper;

    private sathishPropertiesHelper() {
        super(sathishConfiguration.class, sathishConstants.PROPERTY_PREFIX);
    }

    public static synchronized sathishPropertiesHelper getHelper() {
        if (helper == null) {
            helper = new sathishPropertiesHelper();
        }
        return helper;
    }
}
