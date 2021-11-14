package com.buyern.buyern.ui.search;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.buyern.buyern.Models.Food;
import com.buyern.buyern.Models.SearchItem;
import com.buyern.buyern.R;
import com.buyern.buyern.databinding.FragmentSearchBinding;
import com.buyern.buyern.ui.search.placeholder.PlaceholderContent.PlaceholderItem;
//import com.buyern.buyern.ui.search.databinding.FragmentSearchBinding;

import java.util.ArrayList;

public class MySearchItemRecyclerViewAdapter extends RecyclerView.Adapter<MySearchItemRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<SearchItem> mValues;
    private final Activity activity;
    private NavController navController;

    public MySearchItemRecyclerViewAdapter(ArrayList<SearchItem> items, Activity activity) {
        mValues = items;
        this.activity = activity;
        navController = Navigation.findNavController(activity, R.id.nav_host_fragment_activity_main);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(FragmentSearchBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        switch (holder.mItem.getSearchItemType()) {
            case STORE:
                holder.itemType.setText("Store");
                holder.mainView.setOnClickListener(v -> {
                    navController.navigate(R.id.action_global_businessFragment);
                });
                break;
            case FOOD:
                Food food = (Food) mValues.get(position).getSearchItem();
                holder.price.setText(String.valueOf(food.getPrice().getBasePrice()));
                holder.oldPrice.setText(String.valueOf(food.getPrice().getBasePrice()));
                holder.name.setText(food.getName());
                holder.itemType.setText("Food");
                holder.contentView.setText(food.getAbout());
                if (food.getItems().isEmpty()) {
                    holder.contentView.setText("🤔");
                } else {
                    String contents = "";
                    for (int i = 0; i < food.getItems().size(); i++) {
                        contents = contents.concat(food.getItems().get(i).getName() + ",");
                    }
                    holder.contentView.setText(contents);
                }
//                holder.contentView.setText(food.getName());
                holder.mainView.setOnClickListener(v -> {
                    navController.navigate(R.id.action_global_foodFragment);
                });
                break;
            case BUSINESS:
                holder.itemType.setText("Business");
                holder.mainView.setOnClickListener(v -> {
                    navController.navigate(R.id.action_global_businessFragment);
                });
                break;
            default:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mainView;
        public final TextView price, oldPrice, name, contentView,itemType;
        public final ImageView image;
        public SearchItem mItem;


        public ViewHolder(FragmentSearchBinding binding) {
            super(binding.getRoot());
            mainView = binding.getRoot();
            price = binding.price;
            oldPrice = binding.oldPrice;
            itemType = binding.itemType;
            name = binding.name;
            contentView = binding.content;
            image = binding.image;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + contentView.getText() + "'";
        }
    }
}