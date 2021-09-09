package com.life.buyern.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.life.buyern.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
private View rootView;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = rootView.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        loadGroupViews();
        return rootView;
    }
    private void loadGroupViews() {
        LinearLayout GroupViewHolder = rootView.findViewById(R.id.GroupViewHolder);
        GroupViewHolder.addView(View.inflate(getContext(),R.layout.home_group_view, null));
    }
}