package bankin;

import java.util.Map;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;
import org.apache.camel.util.component.AbstractApiEndpoint;
import org.apache.camel.util.component.ApiMethod;
import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import bankin.api.sathishFileHello;
import bankin.api.sathishJavadocHello;
import bankin.internal.sathishApiCollection;
import bankin.internal.sathishApiName;
import bankin.internal.sathishConstants;
import bankin.internal.sathishPropertiesHelper;

/**
 * Represents a sathish endpoint.
 */
@UriEndpoint(firstVersion = "1", scheme = "sa", title = "sathish", syntax="sa:name", 
             consumerClass = sathishConsumer.class, label = "custom")
public class sathishEndpoint extends AbstractApiEndpoint<sathishApiName, sathishConfiguration> {

    @UriPath @Metadata(required = "true")
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public sathishEndpoint(String uri, sathishComponent component,
                         sathishApiName apiName, String methodName, sathishConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, sathishApiCollection.getCollection().getHelper(apiName), endpointConfiguration);

    }

    public Producer createProducer() throws Exception {
        return new sathishProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final sathishConsumer consumer = new sathishConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<sathishConfiguration> getPropertiesHelper() {
        return sathishPropertiesHelper.getHelper();
    }

    protected String getThreadProfileName() {
        return sathishConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO_FILE:
                apiProxy = new sathishFileHello();
                break;
            case HELLO_JAVADOC:
                apiProxy = new sathishJavadocHello();
                break;
            default:
                throw new IllegalArgumentException("Invalid API name " + apiName);
        }
    }

    @Override
    public Object getApiProxy(ApiMethod method, Map<String, Object> args) {
        return apiProxy;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
