package com.example.TreehouseAndroidFragments.firstfragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.TreehouseAndroidFragments.R;
import com.example.TreehouseAndroidFragments.Recipes;


public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {

	private final OnRecipeSelectedInterface mListener;
	private boolean mIsDual;

	public RecyclerAdapter(Object mListener, boolean isDual) {

		this.mListener = (OnRecipeSelectedInterface)mListener;
		this.mIsDual = isDual;
	}

	@NonNull
	@Override
	public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext()).inflate(getLayOutID(), parent, false);
		return new ListViewHolder(view);
	}

	protected abstract int getLayOutID();

	@Override
	public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
		holder.bindView(position);
	}

	@Override
	public int getItemCount() {
		return Recipes.names.length;
	}

	public interface OnRecipeSelectedInterface {
		void onListRecipeSelected(int index, boolean isDualPane);
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
			mListener.onListRecipeSelected(mIndex, mIsDual);
		}
	}
}

