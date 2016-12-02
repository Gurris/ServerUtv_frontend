package BO;


import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

/**
 * Created by Gurris on 2016-11-12.
 */
public class Log_handler {

    public static ArrayList<Log> getUserLogFromUId(int userId){

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://172.16.83.23:8080" + "/Backend_war/log/getUserLogFromUId/" + userId);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        ArrayList<Log> logs = new ArrayList<>();
        if(response.getStatus() != 200)
            return logs;
        else {
            logs = response.getEntity(new GenericType<ArrayList<Log>>(){});
        }
        return logs;
    }



    public static void addToUserLog(int toUser, int fromUser, String log_message){
        Log log = new Log();

        log.setToUserId(toUser);
        log.setFromUserId(fromUser);
        log.setLog_message(log_message);

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://172.16.83.23:8080" + "/Backend_war/log/addToUserLog");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, log);

    }

}
