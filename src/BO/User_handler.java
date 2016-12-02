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
import java.util.List;

/**
 * Created by Gurris on 2016-11-03.
 */
public class User_handler {

    public static boolean login(String username, String pass) {

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client c = Client.create(clientConfig);

        WebResource webResource = c.resource("http://172.16.83.23:8080" + "/Backend_war/user/getFromUsername/"+username);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        User usr = response.getEntity(new GenericType<User>(){});

        if(usr == null)
            return false;
        if (usr.getUsername().equalsIgnoreCase(username) && usr.getPassword().equals(pass))
            return true;
        else
            return false;

    }

    public static User findUserByName(String username){ // one user
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client c = Client.create(clientConfig);

        WebResource webResource = c.resource("http://172.16.83.23:8080" + "/Backend_war/user/getFromUsername/" + username);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        User usr = response.getEntity(new GenericType<User>(){});

        if(usr != null){
            ArrayList<Log> logs = Log_handler.getUserLogFromUId(usr.getId());
            if(!logs.isEmpty())
                usr.setLog(logs);

        }else{
            usr.setLog(null);
        }

        return usr;

    }

    public static List<User> getAllUsers(){
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client c = Client.create(clientConfig);

        WebResource webResource = c.resource("http://172.16.83.23:8080" + "/Backend_war/user/getAllUsers");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        ArrayList<User> users = response.getEntity(new GenericType<ArrayList<User>>(){});

        return users;
    }

    public static List<User> findUsersByName(String username){ // all users with name like username
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client c = Client.create(clientConfig);

        WebResource webResource = c.resource("http://172.16.83.23:8080" + "/Backend_war/user/findUsersByName/" + username);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        ArrayList<User> users = response.getEntity(new GenericType<ArrayList<User>>(){});

        return users;
    }

    public static User getUserById(int id){
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client c = Client.create(clientConfig);

        WebResource webResource = c.resource("http://172.16.83.23:8080" + "/Backend_war/user/getUserById/" + id);
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        User users = response.getEntity(new GenericType<User>(){});

        return users;
    }

    public static boolean registerUser(User user){

        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        WebResource webResource = client.resource("http://172.16.83.23:8080" + "/Backend_war/user/registerUser");
        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, user);


        if(response.getStatus() != 200)
            return false;

        return true;
    }

}