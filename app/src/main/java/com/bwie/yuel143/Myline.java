package com.bwie.yuel143;
/*
 *@auther:周鑫光
 *@Date: 2019/11/26
 *@Time:18:50
 *@Description:${DESCRIPTION}
 * */

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Myline extends ViewGroup {
    private Context context;

    public Myline(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int s = 20;
        int top = 0;
        int button = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredWidth = childAt.getMeasuredWidth();
            left = right + s;
            right = left + measuredHeight;
            int width = getWidth();
            if (right > width) {
                left = s;
                right = left + measuredWidth;
            }
            childAt.measure(0, 0);
            childAt.layout(top, button, left, right);

        }
    }

    public void onAddAth(String cc) {
        TextView textView = new TextView(context);
        textView.setTextSize(20);
        textView.setTextColor(Color.RED);
        textView.setText(cc);
        addView(textView);


    }
}
