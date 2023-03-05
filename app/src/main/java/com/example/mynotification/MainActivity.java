package com.example.mynotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String TEXT = "Sample Text";
    String TITLE = "Sample Title";
    String CHANNEL_ID = "channel_1";
    String DESCRIPTION = "CHANNEL DESC";
    Button button1, button2;
    String TOAST_MSG = "No Notification";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.okay);
        button2 = findViewById(R.id.cancel);
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);


    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.okay:
                    showNotification();
                    break;
                case R.id.cancel:
                    showCncelToast();
                    break;
                default:
                    break;
            }
        }
    };

    public void showNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background).setContentTitle(TITLE).setContentText(TEXT);
        NotificationManager manager = (NotificationManager) getSystemService(NotificationManager.class);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Testing Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel.enableLights(true);
            channel.enableLights(true);
            channel.setDescription(DESCRIPTION);
            manager.createNotificationChannel(channel);
        }
        if (manager != null) {
            manager.notify(1, builder.build());
        }

    }

    public void showCncelToast() {
        Toast toast = Toast.makeText(getApplicationContext(), TOAST_MSG, Toast.LENGTH_SHORT);
        toast.show();
    }
}