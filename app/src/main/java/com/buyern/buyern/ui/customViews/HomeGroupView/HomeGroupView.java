package com.buyern.buyern.ui.customViews.HomeGroupView;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.buyern.buyern.Controllers.FoodController;
import com.buyern.buyern.Models.Food;
import com.buyern.buyern.R;
import com.buyern.buyern.ui.search.MySearchItemRecyclerViewAdapter;
import com.buyern.buyern.ui.search.placeholder.PlaceholderContent;
import com.google.android.material.textview.MaterialTextView;

import java.util.ArrayList;

/**
 * TODO: document your custom view class.
 */
public class HomeGroupView extends LinearLayoutCompat {
    private Activity activity;
    private String titleText, titleMoreBtn;
    private static final String TAG = "HomeGroupView";

    public HomeGroupView(Context context, Activity activity) {
        super(context);
        this.activity = activity;
        init(null, 0);
    }

    public HomeGroupView(Context context, Activity activity, String titleText, @Nullable String titleMoreBtn) {
        super(context);
        this.activity = activity;
        this.titleText = titleText;
        this.titleMoreBtn = titleMoreBtn;
        init(null, 0);
    }

    public void loadTopOrders() {
        ArrayList<Food> foods = new FoodController().getFoods();

        RecyclerView recyclerView = findViewById(R.id.listView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new HomeGroupViewAdapter(foods, activity));


    }

    public HomeGroupView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HomeGroupView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        inflate(getContext(), R.layout.home_group_view, this);
        MaterialTextView title = findViewById(R.id.title);
        MaterialTextView moreText = findViewById(R.id.moreText);

        if (title != null) {
            title.setText(titleText);
        } else {
            assert title != null;
            ((ViewGroup) title.getParent()).setVisibility(GONE);
        }
        if (titleMoreBtn != null) {
            moreText.setText(titleMoreBtn);
        } else {
            findViewById(R.id.moreTextHolder).setVisibility(GONE);
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // TODO: consider storing these as member variables to reduce
        // allocations per draw cycle.
//        int paddingLeft = getPaddingLeft();
//        int paddingTop = getPaddingTop();
//        int paddingRight = getPaddingRight();
//        int paddingBottom = getPaddingBottom();
//
//        int contentWidth = getWidth() - paddingLeft - paddingRight;
//        int contentHeight = getHeight() - paddingTop - paddingBottom;
//
//        // Draw the text.
//        canvas.drawText(mExampleString,
//                paddingLeft + (contentWidth - mTextWidth) / 2,
//                paddingTop + (contentHeight + mTextHeight) / 2,
//                mTextPaint);
//
//        // Draw the example drawable on top of the text.
//        if (mExampleDrawable != null) {
//            mExampleDrawable.setBounds(paddingLeft, paddingTop,
//                    paddingLeft + contentWidth, paddingTop + contentHeight);
//            mExampleDrawable.draw(canvas);
//        }
    }
}