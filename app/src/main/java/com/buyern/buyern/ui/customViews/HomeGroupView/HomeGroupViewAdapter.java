package com.buyern.buyern.ui.customViews.HomeGroupView;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.buyern.buyern.Models.Food;
import com.buyern.buyern.R;
import com.buyern.buyern.databinding.FragmentSearchBinding;
import com.buyern.buyern.databinding.HomeGroupItemViewBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class HomeGroupViewAdapter extends RecyclerView.Adapter<com.buyern.buyern.ui.customViews.HomeGroupView.HomeGroupViewAdapter.ViewHolder> {
    private static final String TAG = "HomeGroupViewAdapter";
    private final List<Food> mValues;
    private final Activity activity;
    private NavController navController;

    public HomeGroupViewAdapter(List<Food> items, Activity activity) {
        mValues = items;
        this.activity = activity;
    }

    @Override
    public HomeGroupViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(HomeGroupItemViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final HomeGroupViewAdapter.ViewHolder holder, int position) {
        navController = Navigation.findNavController(activity, R.id.nav_host_fragment_activity_main);
        holder.mItem = mValues.get(position);
//            Log.e(TAG, "onBindViewHolder: "+  mValues.get(position).getName());
//            holder.priceTV.setText(mValues.get(position).getPrice().getMain());
        holder.nameTv.setText(mValues.get(position).getName());
        holder.mainView.setOnClickListener(v -> {
            navController.navigate(R.id.action_global_foodFragment);
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final View mainView;
        public final MaterialTextView priceTV, nameTv;
        public final AppCompatImageView imageV;
        public Food mItem;

        public ViewHolder(HomeGroupItemViewBinding binding) {
            super(binding.getRoot());
            mainView = binding.getRoot();
            imageV = binding.imageView;
            priceTV = binding.price;
            nameTv = binding.name;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + priceTV.getText() + "'";
        }
    }
}
