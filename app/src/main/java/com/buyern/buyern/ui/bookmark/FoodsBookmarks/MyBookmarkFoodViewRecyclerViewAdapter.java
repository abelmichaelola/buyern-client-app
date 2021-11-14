package com.buyern.buyern.ui.bookmark.FoodsBookmarks;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.buyern.buyern.R;
import com.buyern.buyern.databinding.FragmentBookmarkFoodBinding;
import com.buyern.buyern.ui.bookmark.FoodsBookmarks.placeholder.PlaceholderContent.PlaceholderItem;
//import com.buyern.buyern.ui.bookmark.FoodsBookmarks.databinding.FragmentBookmarkFoodBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyBookmarkFoodViewRecyclerViewAdapter extends RecyclerView.Adapter<MyBookmarkFoodViewRecyclerViewAdapter.ViewHolder> {

    private final List<PlaceholderItem> mValues;
    private final  Activity activity;
    private final NavController navController;

    public MyBookmarkFoodViewRecyclerViewAdapter(List<PlaceholderItem> items, Activity activity) {
        mValues = items;
        this.activity = activity;
        navController = Navigation.findNavController(activity, R.id.nav_host_fragment_activity_main);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentBookmarkFoodBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
        holder.mainView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_global_foodFragment);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;
        public final View mainView;

        public ViewHolder(FragmentBookmarkFoodBinding binding) {
            super(binding.getRoot());
            mainView = binding.getRoot();
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}