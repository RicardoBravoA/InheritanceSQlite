package com.rba.databasehandler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.rba.databasehandler.model.entity.DemoEntity;
import com.rba.databasehandler.storage.database.DemoDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    private DemoDatabase demoDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        demoDatabase = new DemoDatabase(this);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
                demoDatabase.addDemo(new DemoEntity("1", "Hola 1"));

                Log.i("xx- data", new Gson().toJson(demoDatabase.getDemo()));

                break;
            default:
        }
    }
}
