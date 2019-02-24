package bankin;

import org.apache.camel.Processor;
import org.apache.camel.util.component.AbstractApiConsumer;

import bankin.internal.sathishApiName;

/**
 * The sathish consumer.
 */
public class sathishConsumer extends AbstractApiConsumer<sathishApiName, sathishConfiguration> {

    public sathishConsumer(sathishEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
