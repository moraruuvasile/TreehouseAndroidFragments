package com.example.TreehouseAndroidFragments.firstfragment;

import com.example.TreehouseAndroidFragments.R;


public class ListAdapter extends RecyclerAdapter {

	public ListAdapter(Object mListener) {
		super(mListener, false);
	}

	@Override
	protected int getLayOutID() {
		return R.layout.recy_list_item;
	}








}

