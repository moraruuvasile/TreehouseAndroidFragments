package com.example.TreehouseAndroidFragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnRecipeSelectedInterface {
	public static final String LIST_FRAGMENT = "list_fragment";
	public static final String VIEWPAGE_FRAGMENT = "viewpage_fragment";
	private static final String GRID_FRAGMENT = "grid_fragment";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		boolean isTablet = getResources().getBoolean(R.bool.isTablet);
		Toast.makeText(this, isTablet + "", Toast.LENGTH_SHORT).show();

		if (!isTablet && ) {
			ListFragments savedFragment = (ListFragments) getSupportFragmentManager()
					.findFragmentByTag(LIST_FRAGMENT);
			if (savedFragment == null) {
				ListFragments fragment = new ListFragments();
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.act_main_frame1, fragment, LIST_FRAGMENT)
						.commit();
			}
		} else {
			GridFragments savedFragment = (GridFragments) getSupportFragmentManager()
					.findFragmentByTag(GRID_FRAGMENT);
			if (savedFragment == null) {
				GridFragments fragment = new GridFragments();
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.act_main_frame1, fragment, GRID_FRAGMENT)
						.commit();
			}
		}
	}

	@Override
	public void onListRecipeSelected(int index) {
		ViewPagerFragment fragment = ViewPagerFragment.newInstance(index);
		getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.act_main_frame1, fragment, VIEWPAGE_FRAGMENT)
				.addToBackStack(null)
				.commit();
	}

	@Override
	protected void onSaveInstanceState(@NonNull Bundle outState) {
		super.onSaveInstanceState(outState);
	}
}
