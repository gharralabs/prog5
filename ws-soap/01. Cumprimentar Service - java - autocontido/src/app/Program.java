package app;

import br.gharralabs.services.HelloServiceImpl;
import javax.xml.ws.Endpoint;


public class Program {

    public static void main(String[] args) {
        String url;
        url = "http://localhost:9999/api/hello";
        Endpoint.publish(url,new HelloServiceImpl());
    }

}
