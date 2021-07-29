package sg.edu.rp.c346.id19004781.c347_ps11_taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Temporary
        setNotification("this is the name!", "description!!", 5);
    }

    private void setNotification(String name, String description, int seconds) {
        int notificationID = 888;
        int requestCode = 123;

//        NotificationManager notificationManager = (NotificationManager)
//                getSystemService(NOTIFICATION_SERVICE);
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            NotificationChannel channel = new
//                    NotificationChannel("default", "Default Channel",
//                    NotificationManager.IMPORTANCE_DEFAULT);
//
//            channel.setDescription("This is for default notification");
//            notificationManager.createNotificationChannel(channel);
//        }
//
//        Intent intent = new Intent(AddActivity.this,AddActivity.class);
//        PendingIntent pIntent = PendingIntent.getActivity
//                ( AddActivity.this, requestCode, intent,
//                        PendingIntent.FLAG_CANCEL_CURRENT);
//
//        // Bigtext
//        NotificationCompat.BigTextStyle bigText = new
//                NotificationCompat.BigTextStyle();
//        bigText.setBigContentTitle("Big Text – Long Content");
//        bigText.bigText("This is one big text" +
//                " - A quick brown fox jumps over a lazy brown dog "+
//                "\nLorem ipsum dolor sit amet, sea eu quod des");
//        bigText.setSummaryText("Reflection Journal?");
//
//        // Build notification
//        NotificationCompat.Builder builder = new
//                NotificationCompat.Builder(AddActivity.this, "default");
//        builder.setContentTitle(name);
//        builder.setContentText(description);
//        builder.setSmallIcon(android.R.drawable.btn_star_big_off);
//        builder.setContentIntent(pIntent);
//        builder.setStyle(bigText); // Bigtext
//        builder.setAutoCancel(true);
//
//        Notification n = builder.build();
//
//        // An integer good to have, for you to programmatically cancel it
//        notificationManager.notify(notificationID, n);




// ---

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, seconds);

        Intent intent1 = new Intent(AddActivity.this,
                ScheduledNotificationReceiver.class);

        intent1.putExtra("name", name);
        intent1.putExtra("description", description);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                AddActivity.this, requestCode,
                intent1, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager am = (AlarmManager)
                getSystemService(AddActivity.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                pendingIntent);



        finish();

    }
}