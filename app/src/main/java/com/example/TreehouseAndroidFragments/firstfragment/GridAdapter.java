package com.example.TreehouseAndroidFragments.firstfragment;


import com.example.TreehouseAndroidFragments.R;

public class GridAdapter extends RecyclerAdapter {

	public GridAdapter(Object mListener) {
		super(mListener, true);
	}

	@Override
	protected int getLayOutID() {
		return R.layout.recy_grid_item;
	}

}

