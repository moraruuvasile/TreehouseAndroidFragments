package com.example.TreehouseAndroidFragments;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridFragments extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

		RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
		int numColums = (int) (dpWidth/150);
		recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), numColums));

		GridAdapter listAdapter = new GridAdapter(getActivity());
		recyclerView.setAdapter(listAdapter);

		return view;
	}
}