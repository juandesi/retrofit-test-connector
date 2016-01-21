package org.mule.modules.openweatherretrofit.config;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.Connect;
import org.mule.api.annotations.ConnectionIdentifier;
import org.mule.api.annotations.Disconnect;
import org.mule.api.annotations.TestConnectivity;
import org.mule.api.annotations.ValidateConnection;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.param.ConnectionKey;
import org.mule.modules.openweatherretrofit.ServiceInterface;

import retrofit.RestAdapter;

@ConnectionManagement(friendlyName = "Configuration")
public class ConnectorConfig
{

    private ServiceInterface service;

    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String host)
            throws ConnectionException
    {
        RestAdapter retrofit = new RestAdapter.Builder()
                .setEndpoint(host)
                .setConverter(new PlainConverter())
                .build();

        service = retrofit.create(ServiceInterface.class);

    }

    @Disconnect
    public void disconnect()
    {
        service = null;
    }

    @ValidateConnection
    public boolean isConnected()
    {
        return service != null;
    }

    @ConnectionIdentifier
    public String connectionId()
    {
        return service.toString();
    }

    public ServiceInterface getService()
    {
        return service;
    }

    public void setService(ServiceInterface retrofit)
    {
        this.service = retrofit;
    }

}