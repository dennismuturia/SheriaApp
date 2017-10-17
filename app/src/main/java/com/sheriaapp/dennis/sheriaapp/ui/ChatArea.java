package com.sheriaapp.dennis.sheriaapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;
import com.sheriaapp.dennis.sheriaapp.Constants;
import com.sheriaapp.dennis.sheriaapp.R;
import com.sheriaapp.dennis.sheriaapp.service.FetchChatService;


import butterknife.Bind;
import butterknife.ButterKnife;

public class ChatArea extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.conversation)TextView convesation;
    @Bind(R.id.user_input)EditText userInput;
    @Bind(R.id.sendButton)Button mButton;
    //TextView mConversation = (TextView)findViewById(R.id.conversation);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_area);

        ButterKnife.bind(this);

        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == mButton){
            String message = userInput.getText().toString();

            watsonConversation(message);
            userInput.setText("");
        }

    }

    private  void watsonConversation( String conversation){
        MessageRequest request = new MessageRequest.Builder()
                .inputText(conversation)
                .build();
        FetchChatService watsonService = new FetchChatService();

        final TextView messageText = (TextView) findViewById(R.id.conversation);

        watsonService.sheriaConversationService.message(Constants.SHERIAWORKSPACE, request)
                .enqueue(new ServiceCallback<MessageResponse>() {
                    @Override
                    public void onResponse(MessageResponse response) {
                        final String outputText = response.getText().get(0);
                        Log.d("Bot:", String.valueOf(outputText));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
//                                messageText.setText(Html.fromHtml("<p><b>Lexy:</b> " + outputText + "</p>"));
                                messageText.setText(outputText);
                            }
                        });
                    }

                    @Override
                    public void onFailure(Exception e) {
                    }

                });
    }
}

