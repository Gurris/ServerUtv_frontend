package beans;

import BO.Message;
import BO.Message_handler;
import BO.User;
import BO.User_handler;

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
        dropdown.clear();
        List<User> usrList = User_handler.getAllUsers();
        for(int i=0; i<usrList.size(); i++){
            if(!usrList.get(i).getUsername().equals(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userKey").toString())) {
                //Do not add yourself.
                dropdown.add(usrList.get(i));
            }
        }
        return dropdown;
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
        Message msg = new Message();
        msg.setMessage(messageToSend);
        msg.setFromUser(User_handler.findUserByName(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userKey").toString()));
        msg.setToUser(User_handler.getUserById(toUser));

        Message_handler.sendMessageToId(msg);
    }

}
