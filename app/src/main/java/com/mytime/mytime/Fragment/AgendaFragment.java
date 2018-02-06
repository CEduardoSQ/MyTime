package com.mytime.mytime.Fragment;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mytime.mytime.R;
import com.mytime.mytime.Tab.TabFridayFragment;
import com.mytime.mytime.Tab.TabMondayFragment;
import com.mytime.mytime.Tab.TabThursdayFragment;
import com.mytime.mytime.Tab.TabTuesdayFragment;
import com.mytime.mytime.Tab.TabWednesdayFragment;


public class AgendaFragment extends Fragment {
    private AppBarLayout appBarLayout;
    public TabLayout tabLayout;
    private ViewPager viewPager;

    @SuppressLint("ResourceType")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agenda, container, false);

        View content = (View) container.getParent();
        appBarLayout = (AppBarLayout) content.findViewById(R.id.appbar);
        tabLayout = new TabLayout(getActivity());
        tabLayout.setTabTextColors(Color.parseColor("#9E9E9E"), Color.parseColor("#FFFFFF"));
        appBarLayout.addView(tabLayout);

        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        appBarLayout.removeView(tabLayout);
    }

    public class ViewPagerAdapter extends FragmentStatePagerAdapter {
        public ViewPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        String[] tittleTabs = {
                getString(R.string.monday),
                getString(R.string.tuesday),
                getString(R.string.wednesday),
                getString(R.string.thursday),
                getString(R.string.friday)
        };

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new TabMondayFragment();
                case 1:
                    return new TabTuesdayFragment();
                case 2:
                    return new TabWednesdayFragment();
                case 3:
                    return new TabThursdayFragment();
                case 4:
                    return new TabFridayFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tittleTabs[position];
        }
    }
}