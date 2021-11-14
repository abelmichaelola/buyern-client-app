package com.buyern.buyern.ui.bookmark.FoodsBookmarks;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buyern.buyern.R;
import com.buyern.buyern.databinding.FragmentBookmarkFoodListBinding;
import com.buyern.buyern.ui.bookmark.FoodsBookmarks.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class FoodListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private FragmentBookmarkFoodListBinding binding;
private View rootView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FoodListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FoodListFragment newInstance(int columnCount) {
        FoodListFragment fragment = new FoodListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBookmarkFoodListBinding.inflate(inflater, container, false);
rootView = binding.getRoot();
        // Set the adapter
            Context context = rootView.getContext();
            RecyclerView recyclerView = (RecyclerView) binding.list;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyBookmarkFoodViewRecyclerViewAdapter(PlaceholderContent.ITEMS, getActivity()));

        return rootView;
    }
}