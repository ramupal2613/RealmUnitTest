package com.example.premium.realmunittestexample;


import com.example.premium.realmunittestexample.db.tables.ChatMessageDetail;
import org.powermock.api.mockito.PowerMockito;
import io.realm.Realm;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;


public class MockSupport {

    public static Realm mockRealm() {
        mockStatic(Realm.class);

        Realm mockRealm = PowerMockito.mock(Realm.class);

        when(mockRealm.createObject(ChatMessageDetail.class)).thenReturn(new ChatMessageDetail());
        when(Realm.getDefaultInstance()).thenReturn(mockRealm);

        return mockRealm;
    }
}