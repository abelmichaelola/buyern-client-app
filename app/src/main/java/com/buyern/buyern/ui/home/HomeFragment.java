package com.buyern.buyern.ui.home;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.buyern.buyern.Models.Price;
import com.buyern.buyern.R;
import com.buyern.buyern.databinding.FragmentHomeBinding;
import com.buyern.buyern.ui.customViews.HomeGroupView.HomeGroupView;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.function.Consumer;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    private LinearLayoutCompat mainViewHolder;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mainViewHolder = binding.mainViewHolder;
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Chipper();
            }
        });
        thread.run();


        binding.textHome.setOnClickListener(v -> {
            NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
            navController.navigate(R.id.action_global_orderFragment);
        });
        loadViews();

        return root;
    }

    private void Chipper() {
        ArrayList<String> stuffs = new ArrayList<String>();
        stuffs.add("\uD83D\uDC40  More");
        stuffs.add("😋 Top Trending");
        stuffs.add("🤗 NEW 🆕");
        stuffs.add("☕ Just Added");
        stuffs.add("🏁 Lagos");
        stuffs.add("🤩 Promo");
        ChipGroup topChipGroup = binding.topChipGroup;
        stuffs.forEach(stuff -> {

            Chip chip = new Chip(getContext());
            chip.setText(stuff);
            chip.setId(View.generateViewId());
            ColorStateList colorStateList = ColorStateList.valueOf( getResources().getColor(R.color.design_default_color_primary, getContext().getTheme()));
            colorStateList.withAlpha(25);
//            chip.setChipBackgroundColor(colorStateList);
//            chip.setTextColor(getResources().getColor(R.color.design_default_color_on_primary, getContext().getTheme()));
            topChipGroup.addView(chip);
        });


    }

    private void loadViews() {
        HomeGroupView homeGroupView = new HomeGroupView(getContext(), getActivity(), "📃 Recent Orders", "View More");
        homeGroupView.loadTopOrders();
        HomeGroupView homeGroupView1 = new HomeGroupView(getContext(), getActivity(), "👌🏾 Leading Orders", "View More");
        homeGroupView1.loadTopOrders();
        mainViewHolder.addView(homeGroupView);
        mainViewHolder.addView(homeGroupView1);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}