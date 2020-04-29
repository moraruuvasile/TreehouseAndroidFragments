package com.example.TreehouseAndroidFragments;


public class GridAdapter extends RecyclerAdapter {

	public GridAdapter(Object mListener) {
		super(mListener);
	}

	@Override
	protected int getLayOutID() {
		return R.layout.recy_grid_item;
	}

}

