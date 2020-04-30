package com.example.TreehouseAndroidFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.TreehouseAndroidFragments.firstfragment.GridFragments;
import com.example.TreehouseAndroidFragments.firstfragment.ListFragments;
import com.example.TreehouseAndroidFragments.firstfragment.RecyclerAdapter;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.OnRecipeSelectedInterface {
	private static boolean isBack = true;

	public static final String LIST_FRAGMENT = "list_fragment";
	public static final String VIEWPAGE_FRAGMENT = "viewpage_fragment";
	private static final String GRID_FRAGMENT = "grid_fragment";

	ListFragments listFragments = null;
	GridFragments gridFragments = null;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		boolean isTablet = getResources().getBoolean(R.bool.isTablet);
		Toast.makeText(this, isTablet + "", Toast.LENGTH_SHORT).show();


		if (!isTablet && isBack) {
			listFragments = (ListFragments) getSupportFragmentManager()
					.findFragmentByTag(LIST_FRAGMENT);
			if (listFragments == null) {
				ListFragments fragment = new ListFragments();
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.act_main_frame1, fragment, LIST_FRAGMENT)
						.commit();
			}
		}

		if(isTablet && isBack ) {
			gridFragments = (GridFragments) getSupportFragmentManager()
					.findFragmentByTag(GRID_FRAGMENT);
			if (gridFragments == null) {
				GridFragments fragment = new GridFragments();
				getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.act_main_frame1, fragment, GRID_FRAGMENT)
						.commit();
			}
		}
	}

	@Override
	public void onListRecipeSelected(int index, boolean isDualPane) {
		if (isDualPane) {
			DualPaneFragment fragment = DualPaneFragment.newInstance(index);
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.act_main_frame1, fragment, VIEWPAGE_FRAGMENT)
//				.addToBackStack(null)
					.commit();
		} else {
			ViewPagerFragment fragment = ViewPagerFragment.newInstance(index);
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.act_main_frame1, fragment, VIEWPAGE_FRAGMENT)
//				.addToBackStack(null)
					.commit();
		}
		isBack = false;
	}

	@Override
	public void onBackPressed() {
		if (!isBack) {
			refreshActivity();
		}
		isBack = true;
		super.onBackPressed();
	}

	private void refreshActivity() {
		Intent i = new Intent(this, MainActivity.class);
//		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		finish();

	}

}
