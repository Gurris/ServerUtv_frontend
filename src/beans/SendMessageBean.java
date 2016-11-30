package beans;

import BO.Log;
import BO.User;
import BO.Message;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustaf on 2016-11-25.
 */
@ManagedBean(name="sendMessage")
@SessionScoped
public class SendMessageBean {

    private int toUser;
    private int fromUser;
    private String messageToSend;
    private ArrayList<User> dropdown = new ArrayList<>();

    public List<User> getUsers(){
        return null;
    }

    public int getToUser() {
        return toUser;
    }

    public void setToUser(int toUser) {
        this.toUser = toUser;
    }

    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int fromUser) {
        this.fromUser = fromUser;
    }

    public String getMessageToSend() {
        return messageToSend;
    }

    public void setMessageToSend(String messageToSend) {
        this.messageToSend = messageToSend;
    }

    public void sendMessage(){

    }

}
