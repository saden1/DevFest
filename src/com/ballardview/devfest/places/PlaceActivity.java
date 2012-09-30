package com.ballardview.devfest.places;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class PlaceActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_place);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_place, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.bumpplace:
			Toast.makeText(this, "Place Bumped!", Toast.LENGTH_LONG).show();
		case R.id.addevent:
			Toast.makeText(this, "Add Event!", Toast.LENGTH_LONG).show();
		case R.id.viewevent:
			Intent intent = new Intent(this, EventActivity.class);
    		startActivity(intent);
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
