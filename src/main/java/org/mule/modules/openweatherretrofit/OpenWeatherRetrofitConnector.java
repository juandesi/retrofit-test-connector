package org.mule.modules.openweatherretrofit;

import org.mule.api.annotations.Config;
import org.mule.api.annotations.Connector;
import org.mule.modules.openweatherretrofit.config.ConnectorConfig;

@Connector(name = "open-weather-retrofit", friendlyName = "OpenWeatherRetrofit")
public class OpenWeatherRetrofitConnector implements ServiceInterface
{

    @Config
    ConnectorConfig config;

    public ConnectorConfig getConfig()
    {
        return config;
    }

    public void setConfig(ConnectorConfig config)
    {
        this.config = config;
    }

    @Override
    public String weatherCoords(String lat, String lon, String id)
    {
        return config.getService().weatherCoords(lat, lon, id);
    }
}