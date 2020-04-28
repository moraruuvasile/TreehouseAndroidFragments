package com.example.TreehouseAndroidFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnRecipeSelectedInterface {
public static final String LIST_FRAGMENT = "list_fragment";
public static final String VIEWPAGE_FRAGMENT = "viewpage_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		ListFragments savedFragment = (ListFragments) getSupportFragmentManager()
				.findFragmentByTag(LIST_FRAGMENT);
		if (savedFragment == null) {
			ListFragments fragment = new ListFragments();
			getSupportFragmentManager()
			.beginTransaction()
			.add(R.id.act_main_frame1, fragment, LIST_FRAGMENT)
			.commit();
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


}
