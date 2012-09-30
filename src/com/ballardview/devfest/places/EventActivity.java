package com.ballardview.devfest.places;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class EventActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_event, menu);
        return true;
    }
    @Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
		case R.id.bumpevent:
			Toast.makeText(this, "Event Bumped!", Toast.LENGTH_LONG).show();
		case R.id.deleteevent:
			Toast.makeText(this, "Event Deleted!", Toast.LENGTH_LONG).show();
		}
		return super.onMenuItemSelected(featureId, item);
	}
}
