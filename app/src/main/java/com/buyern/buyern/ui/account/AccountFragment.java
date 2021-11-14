package com.buyern.buyern.ui.account;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.buyern.buyern.R;
import com.buyern.buyern.databinding.AccountListItemBinding;
import com.buyern.buyern.databinding.FragmentAccountBinding;
import com.buyern.buyern.databinding.FragmentHomeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentAccountBinding binding;
    private View rootView;
private NavController navController;
    public AccountFragment() {}

    public static AccountFragment newInstance(String param1, String param2) {
        AccountFragment fragment = new AccountFragment();
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
        binding = FragmentAccountBinding.inflate(inflater, container, false);
        navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment_activity_main);
        rootView = binding.getRoot();
        AccountItem[] accountItems = {
                new AccountItem(1, "Profile", "Abel Michael", R.drawable.ic_outline_account_circle_24),
                new AccountItem(2, "Orders", "🛍️", R.drawable.ic_baseline_fastfood_24),
//                new AccountItem(3, "Finances", "👀", R.drawable.ic_baseline_attach_money_24),
                new AccountItem(4, "Payment Methods", "💳", R.drawable.ic_baseline_credit_card_24),
//                new AccountItem(5, "Gift Cards", "🎁", R.drawable.ic_baseline_card_giftcard_24),
                new AccountItem(6, "Contact Us", "🤙🏾", R.drawable.ic_baseline_local_phone_24),
                new AccountItem(7, "Settings", "🤙🏾", R.drawable.ic_outline_settings_24),
//                new AccountItem(7, "About Us", "ℹ️", R.drawable.ic_baseline_info_24),
//                new AccountItem(8, "Share", "", R.drawable.ic_baseline_share_24)
//                new AccountItem(9, "Scheduled Orders", "", R.drawable.ic_baseline_fastfood_24)
        };
        for (AccountItem accountItem : accountItems) {
            View view = View.inflate(getContext(), R.layout.account_list_item, null);
            TextView titleTV = view.findViewById(R.id.title);
            TextView subTitleTV = view.findViewById(R.id.subTitle);
            AppCompatImageView iconImg = view.findViewById(R.id.iconImg);
            titleTV.setText(accountItem.getText());
            binding.listView.addView(view);
            if (accountItem.getSubText().equals("")){
                subTitleTV.setVisibility(View.GONE);
            } else {
                subTitleTV.setText(accountItem.getSubText());
            }
            iconImg.setImageDrawable(ResourcesCompat.getDrawable(getResources(), accountItem.getIcon(), getContext().getTheme()));
            switch (accountItem.getId()){
                case 2:
                    view.setOnClickListener(v -> navController.navigate(R.id.action_global_orderListFragment));
                    break;
                case 4:
                    view.setOnClickListener(v -> navController.navigate(R.id.action_global_paymentMethodsFragment));
                    break;
                case 7:
                    view.setOnClickListener(v -> navController.navigate(R.id.action_global_paymentMethodsFragment));
                    break;
            }
        }
        return rootView;
    }
}
class AccountItem {
    private int id;
    private String text;
    private String subText;
    private int icon;

    public AccountItem() {

    }

    public AccountItem(int id, String text, String subText, @Nullable int icon) {
        this.id = id;
        this.text = text;
        this.subText = subText;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}