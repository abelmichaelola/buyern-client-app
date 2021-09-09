package com.life.buyern.ui.Account;

import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.life.buyern.R;

import java.util.ArrayList;
import java.util.List;

public class AccountFragment extends Fragment {

    private AccountViewModel mViewModel;
    private View rootView;

    public static AccountFragment newInstance() {
        return new AccountFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.account_fragment, container, false);
//        TextView page_title = rootView.findViewById(R.id.page_title);
//        page_title.setText("Abel Michael");
        implementList();
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        mViewModel = new ViewModelProvider(this).get(AccountViewModel.class);
        // TODO: Use the ViewModel
    }

    private void implementList() {
        LinearLayout account_list_holder;
        account_list_holder = rootView.findViewById(R.id.account_list_holder);
        ArrayList<AccountListItem> list = new ArrayList<>();
        list.add(new AccountListItem(1, "Profile", "Abel Michael", R.drawable.ic_baseline_account_circle_24, true, R.id.action_navigation_account_to_profileFragment));
        list.add(new AccountListItem(2, "Orders", "order id: 3274685984", R.drawable.ic_baseline_list_alt_24, true, R.id.action_navigation_account_to_ordersFragment));
        list.add(new AccountListItem(3, "Payment", null, R.drawable.ic_baseline_credit_card_24, true, R.id.action_navigation_account_to_paymentMainPageFragment));
        list.add(new AccountListItem(4, "Gift Cards", null, R.drawable.ic_baseline_card_giftcard_24, true, R.id.ordersFragment));
        list.add(new AccountListItem(5, "Contact Us", null, R.drawable.ic_baseline_help_outline_24, true, R.id.ordersFragment));
        list.add(new AccountListItem(6, "About Us", null, R.drawable.ic_baseline_info_24, true, R.id.ordersFragment));
        list.add(new AccountListItem(7, "Rate The App", null, R.drawable.ic_baseline_star_rate_24, true, R.id.ordersFragment));
        AccountListItem.displayItems(getContext(), getActivity(), account_list_holder, list);
    }

}

class AccountListItem {
    int id, icon;
    String Title, subTitle;
    boolean isActive;
    Integer destination;

    public AccountListItem(int id, String title, @Nullable String subTitle, int icon, boolean isActive, @Nullable Integer destination) {
        this.id = id;
        this.icon = icon;
        Title = title;
        this.subTitle = subTitle;
        this.isActive = isActive;
        this.destination = destination;
    }

    public static void displayItems(Context context, Activity activity, ViewGroup root, List<AccountListItem> accountListItems) {
        NavController navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
        for (AccountListItem accountItem : accountListItems) {
            ViewGroup view = (ViewGroup) View.inflate(context, R.layout.account_list_item, null);
            TextView title = view.findViewById(R.id.title_text);
            title.setText(accountItem.Title);
            TextView sub_text = view.findViewById(R.id.sub_text);

            if (accountItem.subTitle != null) {
                sub_text.setText(accountItem.subTitle);
                sub_text.setVisibility(View.VISIBLE);
            } else {
                sub_text.setVisibility(View.GONE);
            }
            ImageView icon_main = view.findViewById(R.id.icon_main);
            view.setOnClickListener(v -> {
                if (accountItem.destination != null){
                    navController.navigate(accountItem.destination);
                }
            });
            icon_main.setImageDrawable(ResourcesCompat.getDrawable(context.getResources(), accountItem.icon, context.getTheme()));
            root.addView(view);
        }
    }

}