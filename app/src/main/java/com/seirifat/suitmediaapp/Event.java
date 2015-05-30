package com.seirifat.suitmediaapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.seirifat.suitmediaapp.classes.EventListAdapter;
import com.seirifat.suitmediaapp.classes.event;

import java.util.ArrayList;
import java.util.List;


public class Event extends Activity {

    ListView list;
    Intent intent;

    List<event> listEvent = new ArrayList<event>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        intent = getIntent();

//        for (int i=1;i<=10;i++) {
//            event ev = new event(R.drawable.photo01, "Event "+i, "10 Mei 2015");
//            listEvent.add(ev);
//        }
        event ev = new event();
        ev.setDrawableId(R.drawable.ic_launcher);
        ev.setName("Let Success Make The Noise");
        ev.setDate("Nov 09 2014");
        listEvent.add(ev);
        event ev2 = new event();
        ev2.setDrawableId(R.drawable.ic_launcher);
        ev2.setName("Semangat Tahun Baru");
        ev2.setDate("Oct 21 2014");
        listEvent.add(ev2);
        event ev3 = new event();
        ev3.setDrawableId(R.drawable.ic_launcher);
        ev3.setName("Work Hard In Smile");
        ev3.setDate("Jun 14 2014");
        listEvent.add(ev3);
//        event ev4 = new event(R.drawable.ic_launcher, "Event ", " Mei 2015");
//        listEvent.add(ev4);
//        event ev5 = new event(R.drawable.ic_launcher, "Event ", " Mei 2015");
//        listEvent.add(ev5);
//        event ev6 = new event(R.drawable.ic_launcher, "Event ", " Mei 2015");
//        listEvent.add(ev6);
//        event ev7 = new event(R.drawable.ic_launcher, "Event ", " Mei 2015");
//        listEvent.add(ev7);

        EventListAdapter adapter = new EventListAdapter(Event.this,R.layout.mylist,listEvent);
        list = (ListView)findViewById(R.id.theList);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                TextView tv=(TextView)parent.getChildAt(position).findViewById(R.id.Itemname);
                TextView tv=(TextView)view.findViewById(R.id.Itemname);
                String teks = tv.getText().toString();
                intent.putExtra("retValue",teks);
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        RelativeLayout rlBtn = (RelativeLayout)findViewById(R.id.rlBtnBckEvnt);
        rlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
