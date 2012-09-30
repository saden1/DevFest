package com.ballardview.devfest.places;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.ballardview.devfest.places.adapter.HorizontalListViewAdapter;
import com.ballardview.devfest.places.adapter.PlacesListAdapter;
import com.ballardview.devfest.places.model.PlaceType;
import com.ballardview.devfest.places.service.enums.GPlaceType;
import com.devsmart.android.ui.HorizontalListView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		
		HorizontalListView listview = (HorizontalListView) findViewById(R.id.place_type_list);
		listview.setGesture(new GestureDetector(this, listview.getGestureListener()));
		listview.setAdapter(mAdapter);
		Object current = listview.getSelectedItem();
		if (null == current) {
			listview.setSelection(0);
			current = listview.getSelectedItem();
		}
		ListView places = (ListView) findViewById(R.id.places_list);
		places.setAdapter(new PlacesListAdapter((GPlaceType) current, R.layout.place_summary));
    }

	private BaseAdapter mAdapter = new HorizontalListViewAdapter(this, new PlaceType(), R.layout.place_type_item);
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
    	switch(item.getItemId()) {
    	case R.id.viewplace:
    		Intent intent = new Intent(this, PlaceActivity.class);
    		startActivity(intent);
    	}
    	return super.onMenuItemSelected(featureId, item);
    }
}
