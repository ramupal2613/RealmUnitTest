package com.example.premium.realmunittestexample;

import com.example.premium.realmunittestexample.db.tables.ChatMessageDetail;
import com.example.premium.realmunittestexample.db.utils.ChatMessageHelpers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.rule.PowerMockRule;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import io.realm.Realm;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
@PowerMockIgnore({"org.mockito.*", "org.robolectric.*", "android.*"})
@PrepareForTest({Realm.class})
public class RealmUnitTest {

    @Rule
    public PowerMockRule rule = new PowerMockRule();

    Realm mockRealm;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockRealm = MockSupport.mockRealm();
    }


    @Test
    public void realmShouldBeMocked() {
        assertThat(Realm.getDefaultInstance(), is(mockRealm));
    }

    @Test
    public void insertMessage() {
        int result;
        result = ChatMessageHelpers.addChatMessage(null, getChatMessage());
        assertEquals(1, result);
    }

    private ChatMessageDetail getChatMessage() {
        ChatMessageDetail mstMessageDetail = new ChatMessageDetail();
        mstMessageDetail.setJ_ID("9429533223");
        mstMessageDetail.setMESSAGE("Hii");
        return mstMessageDetail;
    }

}
