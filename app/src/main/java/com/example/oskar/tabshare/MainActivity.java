package com.example.oskar.tabshare;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

import net.daedricwolf.clientTools.client;

public class MainActivity extends AppCompatActivity {
Button _Button;
Button _Button2;
EditText _EditText2;
static InetAddress _Servers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        _Button = (Button)this.findViewById(R.id.button);
        _Button2 = (Button)this.findViewById(R.id.button2);
        _EditText2 = (EditText)this.findViewById(R.id.editText2);

        _Button2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    client.FindServers(6000);
                    System.out.println(client.server);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });

        _Button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ip;
                String url = _EditText2.getText().toString();

                try {
                    client.SendInformationToServer(6000, url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        });
    }

}
