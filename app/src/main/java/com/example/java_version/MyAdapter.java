package com.example.java_version;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class MyAdapter extends PagerAdapter {
    public MyAdapter(List<View> mlistView) {
        this.mlistView = mlistView;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(mlistView.get(position),0);
        return mlistView.get(position);
    }

    private List<View> mlistView;
    @Override
    public int getCount() {
        return mlistView.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
       container.removeView(mlistView.get(position));
    }
}
