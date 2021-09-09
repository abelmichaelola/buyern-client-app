package com.life.buyern.ui.Bookmarks;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.life.buyern.R;

public class BookmarksFragment extends Fragment {

    private BookmarksViewModel mViewModel;
    private View rootView;

    public static BookmarksFragment newInstance() {
        return new BookmarksFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.bookmarks_fragment, container, false);
        TextView page_title = rootView.findViewById(R.id.page_title);
        page_title.setText(R.string.title_bookmarks);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(BookmarksViewModel.class);
        // TODO: Use the ViewModel
    }

}