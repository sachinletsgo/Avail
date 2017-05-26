package com.sachinletsgo.avail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.sachinletsgo.filecreate.WriteFile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WriteFile.init("/sdcard/MO123", MainActivity.this, "3.6", "MAC");

        ((TextView) findViewById(R.id.test)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WriteFile.appendLog(String.valueOf(Math.random()), true);
            }
        });
    }
}
