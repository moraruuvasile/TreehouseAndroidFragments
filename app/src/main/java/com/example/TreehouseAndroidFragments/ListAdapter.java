package com.example.TreehouseAndroidFragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ListAdapter extends RecyclerAdapter {

	public ListAdapter(Object mListener) {
		super(mListener);
	}

	@Override
	protected int getLayOutID() {
		return R.layout.recy_list_item;
	}








}

