package com.example.gpstrack;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.location.*;
import android.content.Context;
import android.widget.*;


public class MainActivity extends Activity {
	
	Button btnShowLocation;
	GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnShowLocation = (Button) findViewById(R.id.button1);
		btnShowLocation.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				gps = new GPSTracker(MainActivity.this);
                if(gps.canGetLocation())
{
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                     Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();    
                }
else
{
	gps.showSettingsAlert();
}

				
			}
		});

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
