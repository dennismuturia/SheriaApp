package com.sheriaapp.dennis.sheriaapp.adapters;

import android.app.Activity;
import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.sheriaapp.dennis.sheriaapp.R;
import com.sheriaapp.dennis.sheriaapp.model.ChatMessage;

/**
 * Created by dennis on 10/24/17.
 */

public class MessageAdapter extends FirebaseListAdapter<ChatMessage>{
    private DatabaseReference mRef;
    private Context mContext;

    public MessageAdapter(Activity activity, Class<ChatMessage> modelClass, int modelLayout, Query ref, Context context) {
        super(activity, modelClass, modelLayout, ref);
        mRef = ref.getRef();
        mContext = context;
    }

    @Override
    protected void populateView(View v, ChatMessage model, int position) {
        //Get references to the views of list_item.xml
        TextView messageText = v.findViewById(R.id.message_text); // The actual message sent
        TextView messageUser = v.findViewById(R.id.message_user);
        TextView messageTime = v.findViewById(R.id.message_time);
        //Set their text

        messageText.setText(model.getMessageText());
        messageUser.setText(model.getMessageUser());

        //Format te data before showing it
        messageTime.setText(DateFormat.format("dd-mm-yyyy (hh:mm)",model.getMessageTime()));
    }

}