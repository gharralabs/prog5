package br.com.gharralabs.resources;
import java.util.*;
import javax.ws.rs.core.Application;
             
public class ApplicationJAXRS 
     extends Application{
    
    @Override
    public Map<String, Object> getProperties()
    {
        Map<String, Object> properties = new HashMap<>();
        properties.put("jersey.config.server.provider.packages",
                       "br.com.gharralabs.resources");
        return properties;
    }
}