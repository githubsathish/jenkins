package bankin;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.util.component.AbstractApiComponent;

import bankin.internal.sathishApiCollection;
import bankin.internal.sathishApiName;

/**
 * Represents the component that manages {@link sathishEndpoint}.
 */
public class sathishComponent extends AbstractApiComponent<sathishApiName, sathishConfiguration, sathishApiCollection> {

    public sathishComponent() {
        super(sathishEndpoint.class, sathishApiName.class, sathishApiCollection.getCollection());
    }

    public sathishComponent(CamelContext context) {
        super(context, sathishEndpoint.class, sathishApiName.class, sathishApiCollection.getCollection());
    }

    @Override
    protected sathishApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return sathishApiName.fromValue(apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, sathishApiName apiName,
                                      sathishConfiguration endpointConfiguration) {
        sathishEndpoint endpoint = new sathishEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(sathishConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
