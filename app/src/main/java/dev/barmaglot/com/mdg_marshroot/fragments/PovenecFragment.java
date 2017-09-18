package dev.barmaglot.com.mdg_marshroot.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dev.barmaglot.com.mdg_marshroot.R;

public class PovenecFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_tabs, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.main_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Медвежьегорск"));
        tabLayout.addTab(tabLayout.newTab().setText("Повенец"));

        final ViewPager pager = (ViewPager) rootView.findViewById(R.id.pager);

        TabAdapter adapter = new TabAdapter(getChildFragmentManager(),2);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return rootView;
    }

    class TabAdapter extends FragmentStatePagerAdapter{

        private int numberOfTabs;

        public TabAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            this.numberOfTabs = numberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new FragmentWidthText("06:30, 08:00, 10:10, 12:10, 13:00, 14:10, 16:00, 18:00, 20:20, 23:10");
                case 1:
                    return new FragmentWidthText("07:00, 09:00, 11:05, 13:00, 14:00, 15:05, 17:00, 19:00, 21:20, 24:00");
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return numberOfTabs;
        }
    }

}
