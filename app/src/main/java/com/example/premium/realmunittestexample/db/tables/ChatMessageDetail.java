package com.example.premium.realmunittestexample.db.tables;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by PREMIUM on 08-08-2018.
 */

public class ChatMessageDetail extends RealmObject {

    @PrimaryKey
    String J_ID;
    String MESSAGE;
    public ChatMessageDetail() {

    }

    public String getJ_ID() {
        return J_ID;
    }

    public void setJ_ID(String j_ID) {
        J_ID = j_ID;
    }

    public String getMESSAGE() {
        return MESSAGE;
    }

    public void setMESSAGE(String MESSAGE) {
        this.MESSAGE = MESSAGE;
    }
}
