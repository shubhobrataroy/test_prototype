package com.roy.shubhobrata.undp_prototype;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.github.lzyzsd.circleprogress.CircleProgress;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        initializeComponents();
        //Updater

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    final_result.setProgress(counter++);
                    sensor1.setProgress(counter);
                    sensor2.setProgress(counter);
                    sensor3.setProgress(counter);
                } finally {
                    handler.postDelayed(this, 50);

                }
            }

        };

        runnable.run();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void initializeComponents ()
    {
        final_result = (CircleProgress) findViewById(R.id.circle_progress);
        sensor1 =  (CircleProgress) findViewById(R.id.circle_progress2);
        sensor2 =  (CircleProgress) findViewById(R.id.circle_progress3);
        sensor3 =  (CircleProgress) findViewById(R.id.circle_progress4);
        handler=new Handler();
        counter=0;
    }

      //Variables

    CircleProgress final_result;
    CircleProgress sensor1;
    CircleProgress sensor2;
    CircleProgress sensor3;
    private Handler handler;
    private int counter;
}
