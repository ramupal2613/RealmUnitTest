package com.example.premium.realmunittestexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.premium.realmunittestexample.db.tables.ChatMessageDetail;
import com.example.premium.realmunittestexample.db.utils.ChatMessageHelpers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ChatMessageHelpers.addChatMessage(null, buidMessageInfo());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChatMessageDetail chatMessageDetail = ChatMessageHelpers.getChatMessageDetail(null);
                Log.e("Name",chatMessageDetail.getMESSAGE());
            }
        });
    }

    public ChatMessageDetail buidMessageInfo() {
        ChatMessageDetail chatMessageDetail = new ChatMessageDetail();
        chatMessageDetail.setJ_ID("9429533223");
        chatMessageDetail.setMESSAGE("Hiii");

        return chatMessageDetail;
    }

}
