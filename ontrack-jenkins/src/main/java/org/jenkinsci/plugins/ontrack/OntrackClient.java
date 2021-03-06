package org.jenkinsci.plugins.ontrack;

import com.google.common.base.Function;
import jenkins.model.Jenkins;
import net.ontrack.client.Client;
import net.ontrack.client.ControlUIClient;
import net.ontrack.client.ManageUIClient;
import net.ontrack.client.PropertyUIClient;
import net.ontrack.client.support.ClientFactory;
import net.ontrack.client.support.ControlClientCall;
import net.ontrack.client.support.ManageClientCall;
import net.ontrack.client.support.PropertyClientCall;
import org.apache.commons.lang3.StringUtils;

public final class OntrackClient {

    private OntrackClient() {
    }

    public static <T> T manage(final ManageClientCall<T> manageClientCall) {
        return OntrackClient.call(
                new Function<String, ManageUIClient>() {
                    @Override
                    public ManageUIClient apply(String url) {
                        return ClientFactory.create(url).manage();
                    }
                },
                new Function<ManageUIClient, T>() {
                    @Override
                    public T apply(ManageUIClient client) {
                        return manageClientCall.onCall(client);
                    }
                }
        );
    }

    public static <T> T property(final PropertyClientCall<T> propertyClientCall) {
        return OntrackClient.call(
                new Function<String, PropertyUIClient>() {
                    @Override
                    public PropertyUIClient apply(String url) {
                        return ClientFactory.create(url).property();
                    }
                },
                new Function<PropertyUIClient, T>() {
                    @Override
                    public T apply(PropertyUIClient client) {
                        return propertyClientCall.onCall(client);
                    }
                }
        );
    }

    public static <T> T control(final ControlClientCall<T> controlClientCall) {
        return OntrackClient.call(
                new Function<String, ControlUIClient>() {
                    @Override
                    public ControlUIClient apply(String url) {
                        return ClientFactory.create(url).control();
                    }
                },
                new Function<ControlUIClient, T>() {
                    @Override
                    public T apply(ControlUIClient client) {
                        return controlClientCall.onCall(client);
                    }
                }
        );
    }

    public static <C extends Client, T> T call(
            Function<String, C> clientFactory,
            Function<C, T> callFn) {
        // Gets the configuration
        OntrackConfiguration configuration = (OntrackConfiguration) Jenkins.getInstance().getDescriptor(OntrackConfiguration.class);
        // Gets the configuration data
        String url = configuration.getOntrackUrl();
        String user = configuration.getOntrackUser();
        String password = configuration.getOntrackPassword();
        // Controls the data
        if (StringUtils.isBlank(url)) {
            throw new IllegalStateException("ontrack URL global parameter must be defined");
        }
        if (StringUtils.isBlank(user)) {
            throw new IllegalStateException("ontrack User global parameter must be defined");
        }
        if (StringUtils.isBlank(password)) {
            throw new IllegalStateException("ontrack Password global parameter must be defined");
        }
        // Creates the client
        C client = clientFactory.apply(url);
        // Login
        client.login(user, password);
        try {
            // Performs the control
            return callFn.apply(client);
        } finally {
            client.logout();
        }
    }

}
