package com.example.TreehouseAndroidFragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

	private final OnRecipeSelectedInterface mListener;

	public ListAdapter(Object mListener) {
		this.mListener = (OnRecipeSelectedInterface)mListener;
	}

	@NonNull
	@Override
	public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recy_list_item, parent, false);
		return new ListViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
		holder.bindView(position);
	}

	@Override
	public int getItemCount() {
		return Recipes.names.length;
	}

	interface OnRecipeSelectedInterface {
		void onListRecipeSelected(int index);
	}

	class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
		private TextView mTextView;
		private ImageView mImageView;
		private int mIndex;

		public ListViewHolder(View itemView) {
			super(itemView);
			mTextView = (TextView) itemView.findViewById(R.id.itemText);
			mImageView = (ImageView) itemView.findViewById(R.id.itemImage);
			itemView.setOnClickListener(this);
		}

		public void bindView(int position) {
			mIndex = position;
			mTextView.setText(Recipes.names[position]);
			mImageView.setImageResource(Recipes.resourceIds[position]);
		}

		@Override
		public void onClick(View v) {
			mListener.onListRecipeSelected(mIndex);
		}
	}

}

