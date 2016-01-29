package com.example.oskar.tabshare;

import android.content.ClipboardManager;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
Button _Button;
EditText _EditText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        _Button = (Button)this.findViewById(R.id.button);
        _EditText2 = (EditText)this.findViewById(R.id.editText2);
        
        _Button.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
            String ip;
                String url = _EditText2.getText().toString();
                try {
                    SendInformationToServer("192.168.0.23", 6000, url);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
            
            
        });
    }
    public static void SendInformationToServer(String ip, int port, String data) throws Exception {
        Socket clientSocket = new Socket(ip, port);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        outToServer.writeBytes(data + '\n');
        clientSocket.close();
    }
}
