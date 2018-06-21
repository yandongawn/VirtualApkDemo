package com.example.yandong.virtualhost;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.didi.virtualapk.PluginManager;

import java.io.File;

public class BaseApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
    }
}
