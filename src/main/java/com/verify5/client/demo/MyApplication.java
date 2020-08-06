package com.verify5.client.demo;

import android.app.Application;
import android.content.Context;

import com.verify5.client.proxy.V5ClientManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        V5ClientManager.init(this);
    }


}
