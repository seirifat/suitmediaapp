package com.seirifat.suitmediaapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.seirifat.suitmediaapp.classes.EventListAdapter;
import com.seirifat.suitmediaapp.classes.event;

import java.util.ArrayList;
import java.util.List;


public class Event extends ActionBarActivity {

    ListView list;
    Intent intent;

    List<event> listEvent = new ArrayList<event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        intent = getIntent();

        for(int i=1;i<=3;i++) {
            event ev = new event(R.drawable.ic_launcher, "Event "+i, i+" Mei 2015");
            listEvent.add(ev);
        }

        EventListAdapter adapter = new EventListAdapter(Event.this,R.layout.mylist,listEvent);
        list = (ListView)findViewById(R.id.theList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                TextView tv=(TextView)parent.getChildAt(position).findViewById(R.id.Itemname);
                String teks = tv.getText().toString();
                intent.putExtra("retValue",teks);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event, menu);
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
