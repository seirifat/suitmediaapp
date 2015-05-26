package com.seirifat.suitmediaapp;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.seirifat.suitmediaapp.classes.GuestlistAdapter;
import com.seirifat.suitmediaapp.classes.guest_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Guest extends ActionBarActivity {


    AlertDialog.Builder builder;
    ArrayList<guest_model> listGm = new ArrayList<guest_model>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest);

        intent = getIntent();

        builder = new AlertDialog.Builder(this);
        final GridView gridView = (GridView)findViewById(R.id.gridView1);

        final ProgressDialog pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();

        RequestQueue queue = Volley.newRequestQueue(Guest.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest("http://dry-sierra-6832.herokuapp.com/api/people",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        pDialog.dismiss();
//                        Toast.makeText(Guest.this,jsonArray.toString(),Toast.LENGTH_SHORT).show();
                        for(int i = 0;i<jsonArray.length();i++){
                            try {
//                                Toast.makeText(Guest.this,jsonArray.getJSONObject(i).getString("name"),Toast.LENGTH_SHORT).show();
                                guest_model gm = new guest_model();
                                gm.setImageId(R.drawable.ic_launcher);
                                gm.setName(jsonArray.getJSONObject(i).getString("name"));
                                gm.setbDate(jsonArray.getJSONObject(i).getString("birthdate"));
                                listGm.add(gm);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        GuestlistAdapter guestAdapter = new GuestlistAdapter(Guest.this, R.layout.guestrow,listGm);
                        gridView.setAdapter(guestAdapter);
                        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                TextView tv=(TextView)parent.getChildAt(position).findViewById(R.id.tvBirthdate);
                                String teks = tv.getText().toString().substring(8);
                                String teksmobile;
                                int tglLahir = Integer.parseInt(teks);
                                if((tglLahir % 2) == 0 && (tglLahir % 3) == 0){
                                    teksmobile = "IOS";
                                }
                                else if((tglLahir % 2) == 0){
                                    teksmobile = "blackberry";
                                }
                                else if((tglLahir % 3) == 0){
                                    teksmobile = "android";
                                }
                                else {
                                    teksmobile = "feature phone";
                                }

//                                Toast.makeText(Guest.this,teksmobile,Toast.LENGTH_LONG).show();
                                intent.putExtra("retValue2",teksmobile);
                                setResult(RESULT_OK,intent);
                                finish();
                            }
                        });
                    }
                },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        pDialog.dismiss();
                        builder.setMessage("Cek koneksi internet atau API yang dipakai: \n"+volleyError.toString())
                                .setCancelable(false)
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                    }
                                });
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    }
                }
                );
        queue.add(jsonArrayRequest);




//        JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,"http://dry-sierra-6832.herokuapp.com/api/people",null,
//                new Response.Listener<JSONObject>() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        pDialog.dismiss();
//
//                    }
//                }, new Response.ErrorListener(){
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//        queue.add(jsonReq);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guest, menu);
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
