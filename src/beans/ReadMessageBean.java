package beans;

import BO.Message;
import BO.Message_handler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by Gustaf on 2016-11-25.
 */
@ManagedBean(name="readMessage")
@SessionScoped
public class ReadMessageBean {

    private ArrayList<Message> messages;

    public ArrayList<Message> getMessages() {
        String user = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userKey").toString();
        setMessages(Message_handler.getMessagesForUser(user));

        return messages;
    }

    public void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }
}
