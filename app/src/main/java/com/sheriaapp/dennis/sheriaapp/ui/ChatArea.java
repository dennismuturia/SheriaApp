package com.sheriaapp.dennis.sheriaapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.github.library.bubbleview.BubbleTextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.sheriaapp.dennis.sheriaapp.Constants;
import com.sheriaapp.dennis.sheriaapp.R;
import com.sheriaapp.dennis.sheriaapp.adapters.MessageAdapter;
import com.sheriaapp.dennis.sheriaapp.model.ChatMessage;
import com.sheriaapp.dennis.sheriaapp.service.FetchChatService;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ChatArea extends AppCompatActivity implements View.OnClickListener{

    //TextView mConversation = (TextView)findViewById(R.id.conversation);
    private FirebaseListAdapter<ChatMessage> adapter;
    private ChatMessage chatMessage;
    private MessageAdapter messageAdapter;
    private ProgressBar spinner;
    private FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    @Bind(R.id.btn_send)
    ImageButton fab;
    @Bind(R.id.messageInput) EditText userInput;
    @Bind(R.id.list_of_messages)
    ListView messageListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_area);
        ButterKnife.bind(this);

        fab.setOnClickListener(this);
        //check if not signed in then navigate to SignIn Page

        displayChatMessage();
    }

    private void displayChatMessage() {
        String uid = user.getUid();
        Query query = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_CHAT)
                .child(uid);
        /* MessageAdapter is the custom adapter which makes it easier to set the ListView*/
        messageAdapter = new MessageAdapter(ChatArea.this, ChatMessage.class, R.layout.list_item, query, this);
        messageListView.setAdapter(messageAdapter);

    }

    @Override
    public void onClick(View view) {
        final String message = userInput.getText().toString();
        if (!message.equals("")) { // If statement ensures a message doesn't go blank
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user != null) {
                ChatMessage mChatMessage = new ChatMessage(message, String.valueOf(user.getEmail()));
                String uid = user.getUid();
                DatabaseReference chatRef = FirebaseDatabase
                        .getInstance()
                        .getReference(Constants.FIREBASE_CHILD_CHAT)
                        .child(uid);
                DatabaseReference pushRef = chatRef.push();
                String pushId = pushRef.getKey();
                mChatMessage.setPushId(pushId);
                mChatMessage.setSend(true);
                pushRef.setValue(mChatMessage);
            }
            watsonConversation(message); // Method to call on the Watson Service
            userInput.setText("");
        }
    }

    private void watsonConversation(String conversation) {
        if (!conversation.equals("")) {
            MessageRequest request = new MessageRequest.Builder()
                    .inputText(conversation)
                    .build();
            final FetchChatService watsonService = new FetchChatService();
            final TextView messageText = (BubbleTextView)findViewById(R.id.message_text);
            watsonService.watsonConversationService.message(Constants.SHERIAWORKSPACE, request)
                    .enqueue(new ServiceCallback<MessageResponse>() {
                        @Override
                        public void onResponse(MessageResponse response) {
                            final String outputText = response.getText().get(0);
                            /* Code to store the response on Firebase */
                            ChatMessage mChatMessage = new ChatMessage(outputText, "Lawman"); // Instantiating the model in order to store details onto Firebase.
                            String uid = user.getUid();
                            DatabaseReference chatRef = FirebaseDatabase
                                    .getInstance()
                                    .getReference(Constants.FIREBASE_CHILD_CHAT)
                                    .child(uid);
                            DatabaseReference pushRef = chatRef.push();
                            String pushId = pushRef.getKey();
                            mChatMessage.setPushId(pushId);
                            mChatMessage.setSend(false);
                            pushRef.setValue(mChatMessage);
                            Log.d("Bot:", String.valueOf(outputText));
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Log.d(String.valueOf(outputText), "myOutput");
                                    //messageText.setText(outputText);
                                }
                            });
                        }

                        @Override
                        public void onFailure(Exception e) {
                        }
                    });
        }
    }
}