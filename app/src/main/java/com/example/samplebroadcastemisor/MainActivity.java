package com.example.samplebroadcastemisor;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Emisor";
    public static final String EXTRA_MOON_PHASE= "org.idnp.sampleintentbroadcatreceiver.MoonBroadcastReceiver.EXTRA_MOON_PHASE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSenMessage =findViewById(R.id.btnSendMessage);
        EditText edtMessage= findViewById(R.id.edtMessage);

        btnSenMessage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String message= edtMessage.getText().toString();
                sendMessage(message);
            }
        });

    }

    public void sendMessage(String message){
        Intent intent =new Intent();
        intent.setComponent(new ComponentName("org.idnp.samplebroadcastreceptor", "org.idnp.samplebroadcastreceptor.MoonBroadcastReceiver.EXTRA_MOON_PHASE"));
        intent.setAction(EXTRA_MOON_PHASE);
        intent.putExtra(EXTRA_MOON_PHASE,message);

        sendBroadcast(intent);
        Log.d(TAG, "Mensaje enviado");
    }
}