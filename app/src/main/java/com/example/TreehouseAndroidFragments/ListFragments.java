package com.example.TreehouseAndroidFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListFragments extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_list, container, false);

		RecyclerView recyclerView =  view.findViewById(R.id.listRecyclerView);
		ListAdapter listAdapter = new ListAdapter(getActivity());
		recyclerView.setAdapter(listAdapter);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		return view;
	}

}
