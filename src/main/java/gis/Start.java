package gis;

import gis.app.NdsResponse2;
import gis.client.Client;
import gis.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Client client = context.getBean(Client.class);
        String inn;
        System.out.println("Введите ИНН:");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            inn = reader.readLine();
            NdsResponse2 resp = client.getResponse(inn);
            client.printResp(resp);
        }
        catch (IOException e){
            System.out.println("Не удалось считать ИНН");
        }
    }
}
//7736520080 - Мосэнергосбыт