package com.buyern.buyern.ui.bookmark.BusinessBookmarks;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buyern.buyern.databinding.FragmentBusinessBookmarksBinding;
import com.buyern.buyern.ui.bookmark.placeholder.PlaceholderContent;

/**
 * A fragment representing a list of Items.
 */
public class BusinessBookmarksFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;
private FragmentBusinessBookmarksBinding binding;
private View rootView;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BusinessBookmarksFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static BusinessBookmarksFragment newInstance(int columnCount) {
        BusinessBookmarksFragment fragment = new BusinessBookmarksFragment();
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
        binding = FragmentBusinessBookmarksBinding.inflate(inflater, container, false);
        rootView = binding.getRoot();

        // Set the adapter
            Context context = rootView.getContext();
            RecyclerView recyclerView = binding.list;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MyBusinessBookmarksRecyclerViewAdapter(PlaceholderContent.ITEMS, getActivity()));
        return rootView;
    }
}