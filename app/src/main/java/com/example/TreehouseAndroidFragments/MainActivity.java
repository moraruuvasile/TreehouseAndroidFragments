package com.example.TreehouseAndroidFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListAdapter.OnRecipeSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		ListFragments savedFragment = (ListFragments) getSupportFragmentManager().findFragmentById(R.id.act_main_frame1);
		if (savedFragment == null) {
			ListFragments fragment = new ListFragments();
			getSupportFragmentManager()
			.beginTransaction()
			.add(R.id.act_main_frame1, fragment)
			.commit();
		}

    }

	@Override
	public void onListRecipeSelected(int index) {
		Toast.makeText(MainActivity.this, Recipes.names[index], Toast.LENGTH_SHORT).show();
	}
}
