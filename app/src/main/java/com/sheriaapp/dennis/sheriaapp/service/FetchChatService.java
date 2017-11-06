package com.sheriaapp.dennis.sheriaapp.service;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.sheriaapp.dennis.sheriaapp.Constants;


/**
 * Created by dennis on 10/16/17.
 */

public class FetchChatService {
    public ConversationService  watsonConversationService = new ConversationService("2017-05-06", Constants.SHERIAPUSERNAME, Constants.SHERIAPASSWORD);
}
