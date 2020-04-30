package com.example.TreehouseAndroidFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class DualPaneFragment extends Fragment {
	private static final String INGRIDIENT_FRAGMENT = "ingridient_fragment";
	private static final String DIRECTION_FRAGMENT = "direction_fragment";

	public static DualPaneFragment newInstance(int index) {

		Bundle args = new Bundle();
		args.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
		DualPaneFragment fragment = new DualPaneFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
		getActivity().setTitle(Recipes.names[index]);

		View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

		FragmentManager fragmentManager = getChildFragmentManager();

		IngridientsFragment savedIngridientFragment = (IngridientsFragment) fragmentManager.findFragmentByTag(INGRIDIENT_FRAGMENT);
		if (savedIngridientFragment == null) {
			IngridientsFragment ingridientsFragment = (IngridientsFragment) CheckBoxesFragment
					.newInstance(index, new IngridientsFragment());
			fragmentManager.beginTransaction()
					.add(R.id.left_Pane, ingridientsFragment, INGRIDIENT_FRAGMENT)
					.commit();
		}

		DirectionsFragment savedIDirectionFragment = (DirectionsFragment) fragmentManager.findFragmentByTag(INGRIDIENT_FRAGMENT);
		if (savedIDirectionFragment == null) {
			DirectionsFragment directionFragment = (DirectionsFragment) CheckBoxesFragment
					.newInstance(index, new DirectionsFragment());
			fragmentManager.beginTransaction()
					.add(R.id.right_pane, directionFragment, DIRECTION_FRAGMENT)
					.commit();
		}

		return view;
	}


	@Override
	public void onStop() {
		super.onStop();
		getActivity().setTitle(getResources().getString(R.string.app_name));

	}
}
