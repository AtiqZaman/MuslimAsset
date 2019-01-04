package com.atiq.MuslimAsset;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.atiq.MuslimAsset.prayersActivityFiles.AppController;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivityPrayer extends AppCompatActivity {

    private static final String TAG = "tag";
    //url
    String url = "http://muslimsalat.com/mianwali.json?key=84260ed261bdbd456a62718944fdd125";;

    // Tag used to cancel the request
    String tag_json_obj = "json_obj_req";

    //progress Dialog
    ProgressDialog pDialog;

    TextView mFajarTv, mZuharTv, mAsarTv, mMagribTv, mIshaTv, mLocationTv, mDateTv;
    EditText mSearchEt;
    Button mSearchBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Prayers");


        //Starts Prayers timing code

        mFajarTv    = findViewById(R.id.fajarTv);
        mZuharTv    = findViewById(R.id.zuharTv);
        mAsarTv     = findViewById(R.id.asarTv);
        mMagribTv   = findViewById(R.id.magribTv);
        mIshaTv     = findViewById(R.id.ishaTv);
        mLocationTv = findViewById(R.id.locationTv);
        mDateTv     = findViewById(R.id.dateTv);
        mSearchEt   = findViewById(R.id.searchEt);
        mSearchBtn  = findViewById(R.id.searchBtn);

        //handle Button click
        mSearchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get text from edit text
                String mLocation = mSearchEt.getText().toString().trim();

                //validate if it is null or not
                if(mLocation.isEmpty()){
                    Toast.makeText(ActivityPrayer.this, "Please Enter Location", Toast.LENGTH_SHORT).show();
                }
                else {
                    url = "http://muslimsalat.com/"+mLocation+".json?key=84260ed261bdbd456a62718944fdd125";
                    //This function will get location
                    searchlocation();
                }
            }
        });

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d(TAG, response.toString());
                        //Toast.makeText(ActivityPrayer.this, response.toString(), Toast.LENGTH_SHORT).show();

                        //get data from json
                        try {
                            //get Location
                            String  country   = response.get("country").toString();
                            String  state     = response.get("state").toString();
                            String  city      = response.get("city").toString();
                            String  location  = country +", "+ state +", "+city;

                            //get date
                            String date = response.getJSONArray("items").getJSONObject(0).get("date_for").toString();


                            //get Namaz Timing
                            String mFajar = response.getJSONArray("items").getJSONObject(0).get("fajr").toString();
                            String mZuhr = response.getJSONArray("items").getJSONObject(0).get("dhuhr").toString();
                            String mAsar = response.getJSONArray("items").getJSONObject(0).get("asr").toString();
                            String mMagrib = response.getJSONArray("items").getJSONObject(0).get("maghrib").toString();
                            String mIsha = response.getJSONArray("items").getJSONObject(0).get("isha").toString();

                            //Set this dat to textview
                            mFajarTv.setText(mFajar);
                            mZuharTv.setText(mZuhr);
                            mAsarTv.setText(mAsar);
                            mMagribTv.setText(mMagrib);
                            mIshaTv.setText(mIsha);
                            mLocationTv.setText(location);
                            mDateTv.setText(date);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(ActivityPrayer.this, "Error", Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                pDialog.hide();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

        //End Prayers timing code




        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(3);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.ic_quran:
                        Intent intent1 = new Intent(ActivityPrayer.this,MainActivityQuran.class);
                        startActivity(intent1);
                        break;
                    case R.id.ic_hadith:
                        Intent intent2 = new Intent(ActivityPrayer.this,MainActivityQuran.class);
                        startActivity(intent2);
                        break;
                    case R.id.ic_home:
                        Intent intent3 = new Intent(ActivityPrayer.this,ActivityHome.class);
                        startActivity(intent3);
                        break;
                    case R.id.ic_prayers:

                        break;
                    case R.id.ic_more:
                        Intent intent5 = new Intent(ActivityPrayer.this,ActivityMore.class);
                        startActivity(intent5);
                        break;
                }

                return false;
            }
        });

    }

    private void searchlocation() {
        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Loading...");
        pDialog.show();


        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        //Log.d(TAG, response.toString());
                        //Toast.makeText(ActivityPrayer.this, response.toString(), Toast.LENGTH_SHORT).show();

                        //get data from json
                        try {
                            //get Location
                            String  country   = response.get("country").toString();
                            String  state     = response.get("state").toString();
                            String  city      = response.get("city").toString();
                            String  location  = country +", "+ state +", "+city;

                            //get date
                            String date = response.getJSONArray("items").getJSONObject(0).get("date_for").toString();


                            //get Namaz Timing
                            String mFajar = response.getJSONArray("items").getJSONObject(0).get("fajr").toString();
                            String mZuhr = response.getJSONArray("items").getJSONObject(0).get("dhuhr").toString();
                            String mAsar = response.getJSONArray("items").getJSONObject(0).get("asr").toString();
                            String mMagrib = response.getJSONArray("items").getJSONObject(0).get("maghrib").toString();
                            String mIsha = response.getJSONArray("items").getJSONObject(0).get("isha").toString();

                            //Set this dat to textview
                            mFajarTv.setText(mFajar);
                            mZuharTv.setText(mZuhr);
                            mAsarTv.setText(mAsar);
                            mMagribTv.setText(mMagrib);
                            mIshaTv.setText(mIsha);
                            mLocationTv.setText(location);
                            mDateTv.setText(date);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        pDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(ActivityPrayer.this, "Error", Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                pDialog.hide();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

    }
}
