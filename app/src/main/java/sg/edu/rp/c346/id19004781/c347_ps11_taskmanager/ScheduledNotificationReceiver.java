package sg.edu.rp.c346.id19004781.c347_ps11_taskmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

public class ScheduledNotificationReceiver extends BroadcastReceiver {

    int reqCode = 12345;

    @Override
    public void onReceive(Context context, Intent intent) {
        String name = intent.getExtras().getString("name");
        String description = intent.getExtras().getString("description");

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new
                    NotificationChannel("default", "Default Channel",
                    NotificationManager.IMPORTANCE_DEFAULT);

            channel.setDescription("This is for default notification");
            notificationManager.createNotificationChannel(channel);
        }

        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, reqCode,
                i, PendingIntent.FLAG_CANCEL_CURRENT);


        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");
        NotificationCompat.BigTextStyle bigText = new NotificationCompat.BigTextStyle();

        bigText.setBigContentTitle("Whoa! I feel good, I knew that I would, now\n" +
                "I feel good, I knew that I would, now\n" +
                "So good, so good, I got you\n" +
                "Whoa! I feel nice, like sugar and spice\n" +
                "I feel nice, like sugar and spice\n" +
                "So nice, so nice, I got you\n" +
                "When I hold you in my arms\n" +
                "I know that I can't do no wrong\n" +
                "And when I hold you in my arms\n" +
                "My love won't do you no harm\n" +
                "And I feel nice, like sugar and spice\n" +
                "I feel nice, like sugar and spice\n" +
                "So nice, so nice, I got you\n" +
                "When I hold you in my arms\n" +
                "I know that I can't do no wrong\n" +
                "And when I hold you in my arms\n" +
                "My love can't do me no harm\n" +
                "And I feel nice, like sugar and spice\n" +
                "I feel nice, like sugar and spice\n" +
                "So nice, so nice, 'cause I got you\n" +
                "Whoa! And I feel good, I knew that I would, now\n" +
                "I feel good, I knew that I would\n" +
                "So good, so good, 'cause I got you\n" +
                "So good, so good, 'cause I got you\n" +
                "So good, so good, 'cause I got you\n" +
                "Hey\n" +
                "Oh-whoo");


        builder.setContentTitle("James Brown(I Feel Good song) Lyrics");
        builder.setContentText("James Joseph Brown (May 3, 1933 – December 25, 2006) was an American singer, songwriter, dancer, musician, record producer, and bandleader. The central progenitor of funk music and a major figure of 20th-century music, he is often referred to by the honorific nicknames \"Godfather of Soul\", \"Mr. Dynamite\", and \"Soul Brother No. 1\".In a career that lasted over 50 years, he influenced the development of several music genres.");
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setStyle(bigText);
        builder.setAutoCancel(true);
        builder.setLights(Color.GREEN, 69, 666);
        builder.setVibrate(new long[]{0, 666, 69, 420});
        Notification n = builder.build();
        notificationManager.notify(123, n);


    }
}