package sg.edu.rp.c346.id19004781.c347_ps11_taskmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTasks;
    Button btnAddTask;
    ArrayAdapter aa;
    ArrayList<Task> alTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTasks = findViewById(R.id.lvTasks);
        btnAddTask = findViewById(R.id.btnAddTask);

        DBHelper dbh = new DBHelper(MainActivity.this);
        alTasks = new ArrayList<>();
        alTasks = dbh.getAllTasks();
        dbh.close();

        aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alTasks);
        lvTasks.setAdapter(aa);

        btnAddTask.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, AddActivity.class);
            startActivity(i);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        alTasks = new ArrayList<>();
        DBHelper dbh = new DBHelper(MainActivity.this);
        alTasks.addAll(dbh.getAllTasks());
        dbh.close();
//        aa = new TaskAdapter(MainActivity.this, R.layout.row, alTasks);
        aa = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, alTasks);
        lvTasks.setAdapter(aa);
    }
}