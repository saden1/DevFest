package com.ballardview.devfest.places.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;

import com.ballardview.devfest.places.R;
import com.ballardview.devfest.places.model.PlaceType;

public class HorizontalListViewAdapter extends BaseAdapter {
	private PlaceType mPlaceType;
	private Activity mContainer;
	private int mLayoutId;

	public HorizontalListViewAdapter(Activity container, PlaceType placeType, int layoutId) {
		mPlaceType = placeType;
		mContainer = container;
		mLayoutId = layoutId;
	}

	public int getCount() {
		return mPlaceType.getCount();
	}

	public Object getItem(int position) {
		return mPlaceType.getItem(position);
	}

	public long getItemId(int position) {
		return mPlaceType.getItemId(position);
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View retval = LayoutInflater.from(parent.getContext()).inflate(
				mLayoutId, null);
		Button button = (Button) retval.findViewById(R.id.clickbutton);
		button.setOnClickListener(mOnButtonClicked);
		button.setText(mPlaceType.getText(position));

		return retval;
	}
	
	private OnClickListener mOnButtonClicked = new View.OnClickListener() {
		public void onClick(View v) {
			AlertDialog.Builder builder = new AlertDialog.Builder(mContainer);
			builder.setMessage("hello from " + v);
			builder.setPositiveButton("Cool", null);
			builder.show();
		}
	};

}
