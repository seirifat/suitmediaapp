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
public class GuestlistAdapter extends ArrayAdapter<guest_model> {
    private List<guest_model> gm = null;

    public GuestlistAdapter(Activity mainActivity, int itemlistrow, List<guest_model> gm) {
        super(mainActivity,itemlistrow,gm);
        this.gm = gm;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v == null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.guestrow,null);
        }


        if(gm != null){
            ImageView imageView = (ImageView)v.findViewById(R.id.ivGambarGuest);
            TextView textView = (TextView)v.findViewById(R.id.tvNameGuest);
            TextView textView2 = (TextView)v.findViewById(R.id.tvBirthdate);

            imageView.setImageResource(gm.get(position).getImageId());
            textView.setText(gm.get(position).getName());
            textView2.setText(gm.get(position).getbDate());
        }

        return v;
    }
}
