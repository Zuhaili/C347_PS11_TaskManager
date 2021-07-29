package sg.edu.rp.c346.id19004781.c347_ps11_taskmanager;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AddActivity extends AppCompatActivity {

    Button btnAddTask, btnCancel;
    EditText etName, etDescription, etTime;
    int reqCode = 12345, dataSeconds;
    DBHelper dbh;
    String dataName, dataDescription;
    long inserted_id;
    AlarmManager am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btnCancel = findViewById(R.id.btnCancel);
        btnAddTask = findViewById(R.id.btnAddTask);
        etName = findViewById(R.id.etName);
        etDescription = findViewById(R.id.etDescription);
        etTime = findViewById(R.id.etTime);
//        initialize();

        btnAddTask.setOnClickListener(view -> {


            String name = etName.getText().toString();
            String description = etDescription.getText().toString();
            int time = Integer.parseInt(etTime.getText().toString());

            DBHelper dbh = new DBHelper(AddActivity.this);
            inserted_id = dbh.addTask(name, description);
            dbh.close();



            if (inserted_id != -1) {
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.SECOND, dataSeconds);

                Intent i = new Intent(AddActivity.this, ScheduledNotificationReceiver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(AddActivity.this, reqCode, i, PendingIntent.FLAG_CANCEL_CURRENT);

                AlarmManager am = (AlarmManager) getSystemService(Activity.ALARM_SERVICE);
                am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), pendingIntent);

                Toast.makeText(AddActivity.this, "A new task has been created!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btnCancel.setOnClickListener(view -> finish());
    }


//    public void initialize() {
//        dataName = etName.getText().toString();
//        dataDescription = etDescription.getText().toString();
//        dataSeconds = Integer.parseInt(etTime.getText().toString());
//        dbh = new DBHelper(AddActivity.this);
//        inserted_id = dbh.addTask(dataName, dataDescription);
//        dbh.close();
//    }
}