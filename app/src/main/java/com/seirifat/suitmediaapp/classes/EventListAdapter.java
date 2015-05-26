package com.seirifat.suitmediaapp.classes;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.seirifat.suitmediaapp.R;

import java.util.List;

/**
 * Created by ORION on 5/22/2015.
 */
public class EventListAdapter extends ArrayAdapter<event> {
    private List<event> events = null;

    public EventListAdapter(Activity mainActivity, int itemlistrow, List<event> events) {
        super(mainActivity,itemlistrow,events);
        this.events = events;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.mylist,null);
        }


        if(events != null){
            ImageView imageView = (ImageView)v.findViewById(R.id.icon);
            TextView textView = (TextView)v.findViewById(R.id.Itemname);
            TextView textView2 = (TextView)v.findViewById(R.id.Itemdate);

            imageView.setImageResource(events.get(position).getDrawableId());
            textView.setText(events.get(position).getName());
            textView2.setText(events.get(position).getDate());
        }

        return v;
    }
}
