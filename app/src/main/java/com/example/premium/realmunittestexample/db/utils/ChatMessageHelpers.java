package com.example.premium.realmunittestexample.db.utils;

import android.support.annotation.NonNull;

import com.example.premium.realmunittestexample.db.tables.ChatMessageDetail;

import java.io.Serializable;

import io.realm.Realm;

public class ChatMessageHelpers implements Serializable, Cloneable {

    public static int addChatMessage(Realm myRealm, final ChatMessageDetail messageDetailInfo) {
        int noOfRecordInserted = 0;
        boolean isInTx = true;

        try {
            if (myRealm == null) {
                isInTx = false;
                myRealm = Realm.getDefaultInstance();
            }
            myRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(@NonNull Realm realm) {
                    realm.insertOrUpdate(messageDetailInfo);
                }
            });
            noOfRecordInserted = noOfRecordInserted + 1;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (!isInTx && myRealm != null) {
                myRealm.close();
            }
        }

        return noOfRecordInserted;
    }
}
