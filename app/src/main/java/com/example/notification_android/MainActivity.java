package com.example.notification_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button Notification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Notification = findViewById(R.id.btn_Notification);

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O)
        {
            NotificationChannel notificationChannel = new NotificationChannel("My Notification" , "My Notification" , NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        Notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this , "My Notification");
                builder.setContentTitle("Notification");
                builder.setContentText("Hello , Notification comes from your Notification Application");
                builder.setSmallIcon(R.drawable.ic_baseline_notifications_24);
                builder.setAutoCancel(true);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(MainActivity.this);
                notificationManagerCompat.notify(1 , builder.build());
            }
        });
    }
}