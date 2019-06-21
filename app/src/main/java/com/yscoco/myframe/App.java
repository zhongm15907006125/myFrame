package com.yscoco.myframe;

import android.app.Application;

/**
 * @author：ZhongM on 2019/6/15 15:52
 */
public class App extends Application {
    private static App sApp;
    String token;

    public static boolean isDebug() {
        return true;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        if (isDebug()) {

        }
    }

    public static App getInstance() {
        return sApp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
