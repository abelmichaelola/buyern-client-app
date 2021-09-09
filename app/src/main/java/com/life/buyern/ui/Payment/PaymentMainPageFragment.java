package com.life.buyern.ui.Payment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;
import com.life.buyern.R;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaymentMainPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaymentMainPageFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View rootView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PaymentMainPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PaymentMainPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PaymentMainPageFragment newInstance(String param1, String param2) {
        PaymentMainPageFragment fragment = new PaymentMainPageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_payment_main_page, container, false);
//        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
//        MaterialCardView paymentMethodsCard = rootView.findViewById(R.id.paymentMethodsCard);
//        MaterialCardView transactionsHistoryCard = rootView.findViewById(R.id.transactionsHistoryCard);
//        MaterialCardView bonusesCard = rootView.findViewById(R.id.bonusesCard);
//        paymentMethodsCard.setOnClickListener(v -> {
//            navController.navigate(R.id.action_paymentMainPageFragment_to_paymentMethodsFragment);
//        });
//        transactionsHistoryCard.setOnClickListener(v -> {
//            navController.navigate(R.id.action_paymentMainPageFragment_to_transactionsHistoryFragment);
//        });
//        bonusesCard.setOnClickListener(v -> {
//            navController.navigate(R.id.action_paymentMainPageFragment_to_bonusesFragment);
//        });
    return rootView;
    }
}