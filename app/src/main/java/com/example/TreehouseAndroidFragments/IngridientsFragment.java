package com.example.TreehouseAndroidFragments;

public class IngridientsFragment extends CheckBoxesFragment {


	@Override
	public String[] getContents(int index) {
		return Recipes.ingredients[index].split("`");
	}
}
