package com.ballardview.devfest.places.adapter;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.ballardview.devfest.places.R;
import com.ballardview.devfest.places.service.PlacesSearchTask;
import com.ballardview.devfest.places.service.bean.GPlace;
import com.ballardview.devfest.places.service.bean.GPlacesList;
import com.ballardview.devfest.places.service.bean.SearchParams;
import com.ballardview.devfest.places.service.enums.GPlaceType;

public class PlacesListAdapter implements ListAdapter {

	private GPlaceType mPlaceType;
	private GPlacesList mList;
	private double mLat = 47.6105556;
	private double mLong = -122.3382552;
	private double mRadius = 3000;
	private int mLayoutId;
	private PlacesSearchTask mTask;
	private Set<DataSetObserver> mObservers = new HashSet<DataSetObserver>();

	public PlacesListAdapter(GPlaceType placeType, int layoutId) {
		mLayoutId = layoutId;
		setPlaceType(placeType);
	}
	public void setPlaceType(GPlaceType placeType) {
		mPlaceType = placeType;
		if (null == mPlaceType) {
			mPlaceType = GPlaceType.values()[0];
		}
		mList = null;
	}

	public int getCount() {
		if (null == getList()) {
			return 0;
		} else {
			return getList().getResults().size();
		}
	}

	public Object getItem(int position) {
		return getList().getResults().get(position);
	}

	public long getItemId(int position) {
		return new BigInteger(((GPlace) getItem(position)).getId(), 16).longValue();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View itemView = LayoutInflater.from(parent.getContext()).inflate(mLayoutId, null);
		itemView.setOnClickListener(null);
		TextView text = (TextView) itemView.findViewById(R.id.title);
		GPlace place = (GPlace) getItem(position);
		text.setText(place.getName());
		text = (TextView) itemView.findViewById(R.id.description);
		text.setText(place.getAddress());
		return itemView;
	}

	public int getViewTypeCount() {
		return 1;
	}

	public boolean hasStableIds() {
		return false;
	}

	public boolean isEmpty() {
		return (mList == null || mList.getResults().size() == 0);
	}

	private GPlacesList getList() {
		if (null == mList) {
			prepareList();
		}
		return mList;
	}
	
	private void prepareList() {
		if (null == mTask) {
			mTask = new PlacesSearchTask(this);
			mTask.execute(new SearchParams(mLat, mLong, mPlaceType.toString(), mRadius));
		}
	}
	public int getItemViewType(int position) {
		return R.layout.place_summary;
	}
	public void registerDataSetObserver(DataSetObserver observer) {
		mObservers.add(observer);		
	}
	public void unregisterDataSetObserver(DataSetObserver observer) {
		mObservers.remove(observer);
	}
	public boolean areAllItemsEnabled() {
		return mList != null;
	}
	public boolean isEnabled(int arg0) {
		return mList != null;
	}
	public void setList(GPlacesList result) {
		mList = result;
		for (DataSetObserver observer : mObservers) {
			observer.onChanged();
		}
	}
}
