package bankin;

import org.apache.camel.util.component.AbstractApiProducer;

import bankin.internal.sathishApiName;
import bankin.internal.sathishPropertiesHelper;

/**
 * The sathish producer.
 */
public class sathishProducer extends AbstractApiProducer<sathishApiName, sathishConfiguration> {

    public sathishProducer(sathishEndpoint endpoint) {
        super(endpoint, sathishPropertiesHelper.getHelper());
    }
}
