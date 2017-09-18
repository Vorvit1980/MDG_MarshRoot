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
import android.widget.TextView;

import dev.barmaglot.com.mdg_marshroot.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_tabs, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.main_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Медвежьегорск"));
        tabLayout.addTab(tabLayout.newTab().setText("с/х Вичка"));

        final ViewPager pager = (ViewPager) rootView.findViewById(R.id.pager);

        Fragment2.TabAdapter adapter = new Fragment2.TabAdapter(getChildFragmentManager(),2);
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

    class TabAdapter extends FragmentStatePagerAdapter {

        private int numberOfTabs;

        public TabAdapter(FragmentManager fm, int numberOfTabs) {
            super(fm);
            this.numberOfTabs = numberOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position){
                case 0:
                    return new FragmentWidthText("06:45 07:20 09:10 11:10 14:20 16:30 18:00 19:40");
                case 1:
                    return new FragmentWidthText("07:00 07:40 09:30 11:30 14:40 16:50 18:20 20:00");
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
