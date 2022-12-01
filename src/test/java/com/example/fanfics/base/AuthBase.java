package com.example.fanfics.base;

import com.example.fanfics.models.users.AccountData;
import com.example.fanfics.settings.Settings;
import org.junit.Before;

public class AuthBase extends TestBase {
    protected static final AccountData user = new AccountData(
            Settings.getLogin(),
            Settings.getPassword()
    );

//    public static boolean init = false;
//
//    @Before
//    public void setUp() throws Exception {
//        if (!init) {
//            super.setUp();
//            applicationManager.getLoginHelper().login(user);
//            Thread.sleep(3);
//            applicationManager.getNavigationHelper().openProfilePage();
//            init = true;
//        }
//    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        applicationManager.getLoginHelper().login(user);
        Thread.sleep(3);
        applicationManager.getNavigationHelper().openProfilePage();
    }
}
