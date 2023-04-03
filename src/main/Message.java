package main;

import java.io.Serializable;

public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    private String type;
    private String content;
    private String sender;
    private String recipient;

    public Message(String type, String content, String sender, String recipient) {
        this.type = type;
        this.content = content;
        this.sender = sender;
        this.recipient = recipient;
    }

    @Override
    public String toString() {
        return "{type='" + type + "', sender='" + sender + "', content='" + content + "', recipient='" + recipient + "'}";
    }

}
