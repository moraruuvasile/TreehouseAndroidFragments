package com.example.TreehouseAndroidFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DirectionsFragment extends Fragment {
	private static final String KEY_CHECKED_BOXES = "key_checked_boxes";
	private CheckBox[] mCheckBoxes;

	public static DirectionsFragment newInstance(int index) {

		Bundle args = new Bundle();
		args.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
		DirectionsFragment fragment = new DirectionsFragment();
		fragment.setArguments(args);
		return fragment;
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_ingridients, container, false);
		int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
		String[] ingredients = Recipes.directions[index].split("`");
		mCheckBoxes = new CheckBox[ingredients.length];
		boolean[] checkBoxes = new boolean[mCheckBoxes.length];

		if ((savedInstanceState != null) && (savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES) != null)) {
			checkBoxes = savedInstanceState.getBooleanArray(KEY_CHECKED_BOXES);
		}
		LinearLayout linearLayout = view.findViewById(R.id.ingridients_layout);
		setUpCheckBoxes(ingredients, linearLayout, checkBoxes);

		return view;
	}

	private void setUpCheckBoxes(String[] ingredients, ViewGroup container, boolean[] checkBoxes) {
		int i = 0;
		for (String ing : ingredients) {
			mCheckBoxes[i] = new CheckBox(getContext());
			mCheckBoxes[i].setPadding(8, 16, 8, 16);
			mCheckBoxes[i].setTextSize(20f);
			mCheckBoxes[i].setText(ing);
			if (checkBoxes[i]) {
				mCheckBoxes[i].toggle();
			}
			container.addView(mCheckBoxes[i]);
			i++;
		}
	}

	@Override
	public void onSaveInstanceState(@NonNull Bundle outState) {
		boolean[] stateOfCheckBoxes = new boolean[mCheckBoxes.length];

		int i=0;
		for (CheckBox checkBox:mCheckBoxes) {
			stateOfCheckBoxes[i] = checkBox.isChecked();
			i++;
		}
		outState.putBooleanArray(KEY_CHECKED_BOXES, stateOfCheckBoxes);
		super.onSaveInstanceState(outState);
	}
}
