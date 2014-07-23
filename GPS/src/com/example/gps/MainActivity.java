package com.example.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	TextView tv_latitude, tv_longitude;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
				
		tv_latitude = (TextView) findViewById(R.id.tv_latitude);
		tv_longitude = (TextView) findViewById(R.id.tv_longitude);
		
		LocationManager GZ_loc_manager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		
		LocationListener GZ_loc_listener = new GZ_LOCATION_LISTENER();
		
		GZ_loc_manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, GZ_loc_listener);
	}
	
	private class GZ_LOCATION_LISTENER implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			// TODO Auto-generated method stub
			
			double latitdue = location.getLatitude();
			double longitude = location.getLongitude();
			
			tv_latitude.setText(String.valueOf(latitdue));
			tv_longitude.setText(String.valueOf(longitude));
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}

}
