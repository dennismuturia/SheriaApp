package com.sheriaapp.dennis.sheriaapp.model;

import java.util.Date;

/**
 * Created by dennis on 10/24/17.
 */

public class ChatMessage {
    private String messageText;
    private String messageUser;
    private long messageTime;
    private boolean isSend;
    private String pushId;

    public ChatMessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;
        messageTime = new Date().getTime();
    }
    public ChatMessage() {}

    public String getMessageText() {
        return messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean send) {
        this.isSend = send;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
