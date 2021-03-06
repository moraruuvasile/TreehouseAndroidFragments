package com.example.TreehouseAndroidFragments.firstfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.TreehouseAndroidFragments.R;
import com.example.TreehouseAndroidFragments.firstfragment.ListAdapter;

public class ListFragments extends Fragment {
	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

		RecyclerView recyclerView =  view.findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

		ListAdapter listAdapter = new ListAdapter(getActivity());
		recyclerView.setAdapter(listAdapter);

		return view;
	}

}
