package com.seirifat.suitmediaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class EventAndGuest extends Activity {

    private Intent intent;
    private String name;
    private Button btnEvent;
    private Button btnGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_and_guest);
        intent = getIntent();
        name = intent.getStringExtra("dataNama");
        TextView tvNama = (TextView)findViewById(R.id.tvNama);
        tvNama.setText(name);

        btnGuest = (Button)findViewById(R.id.btnGuest);
        btnGuest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iguest = new Intent(EventAndGuest.this,Guest.class);
                iguest.putExtra("s","s");
                startActivityForResult(iguest, 2);
            }
        });
        btnEvent = (Button)findViewById(R.id.btnEvent);
        btnEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEvent = new Intent(EventAndGuest.this,Event.class);
                iEvent.putExtra("s","s");
                startActivityForResult(iEvent, 1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 1){
            String msg = data.getStringExtra("retValue");
            btnEvent.setText(msg);
//            Toast.makeText(EventAndGuest.this,msg,Toast.LENGTH_SHORT).show();
        }
        else if(resultCode == RESULT_OK && requestCode == 2){
            String msg = data.getStringExtra("retValue2");
            btnGuest.setText(msg);
            Toast.makeText(EventAndGuest.this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_and_guest, menu);
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
}
