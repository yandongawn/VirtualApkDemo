package com.example.yandong.virtualhost;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.didi.virtualapk.PluginManager;
import com.tbruyelle.rxpermissions.RxPermissions;

import java.io.File;
import java.util.jar.Manifest;

import rx.functions.Action1;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxPermissions.getInstance(MainActivity.this).request(android.Manifest.permission.WRITE_EXTERNAL_STORAGE).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {

            }
        });

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pluginPath = Environment.getExternalStorageDirectory().toString() + "/Test.apk";
                Log.e(TAG, "onClick: \t" + pluginPath);
                File plugin = new File(pluginPath);
                try {
                    PluginManager.getInstance(MainActivity.this).loadPlugin(plugin);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // Given "com.didi.virtualapk.demo" is the package name of plugin APK,
                // and there is an activity called `MainActivity`.
                Intent intent = new Intent();
                intent.setClassName("com.example.yandong.virtualplugin", "com.example.yandong.virtualplugin.Main2Activity");
                startActivity(intent);
            }
        });
    }
}
