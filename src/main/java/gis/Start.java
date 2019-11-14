package gis;

import gis.app.NdsResponse2;
import gis.client.Client;
import gis.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Client client = context.getBean("client", Client.class);
        NdsResponse2 resp = client.getResponse("7736520080");
        client.printResp(resp);
    }
}
