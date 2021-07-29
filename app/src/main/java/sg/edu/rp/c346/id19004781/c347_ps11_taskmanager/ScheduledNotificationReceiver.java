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

        // Bigtext
        NotificationCompat.BigTextStyle bigText = new
                NotificationCompat.BigTextStyle();
        bigText.setBigContentTitle(name + " (bigtext)");
        bigText.bigText(description + " (bigtext)\n");

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.rare_penguin);

        // build notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "default");
        builder.setContentTitle(name);
        builder.setContentText(description);
        builder.setSmallIcon(android.R.drawable.ic_dialog_info);
        builder.setContentIntent(pIntent);
        builder.setStyle(bigText); // Bigtext
        builder.setStyle(new NotificationCompat.BigPictureStyle()
                .bigPicture(bitmap)
                .bigLargeIcon(null)); // Image
        builder.setAutoCancel(true);

        Notification n = builder.build();
        notificationManager.notify(123, n);


    }
}