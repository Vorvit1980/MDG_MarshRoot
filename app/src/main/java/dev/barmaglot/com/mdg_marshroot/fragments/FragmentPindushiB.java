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
public class FragmentPindushiB extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_tabs, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.main_tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Медвежьегорск"));
        tabLayout.addTab(tabLayout.newTab().setText("Пиндуши"));

        final ViewPager pager = (ViewPager) rootView.findViewById(R.id.pager);

        FragmentPindushiB.TabAdapter adapter = new FragmentPindushiB.TabAdapter(getChildFragmentManager(),2);
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
                    return new FragmentWidthText("07:00 07:20 07:30 08:00 08:20 08:40 09:00 09:20 09:40 10:00 10:20 10:40 11:00 11:20 11:40 12:00 12:20 12:40 13:00 13:20 13:40 14:00 14:20 14:40 15:00 15:20 15:40 16:00 16:20 16:40 17:00 17:15 17:40 18:00 18:20 18:40 19:00 19:30 20:00 20:25 21:10 22:10 23:00 24:00");
                case 1:
                    return new FragmentWidthText("07:00 07:20 07:30 07:50 08:00 08:10 08:30 08:50 09:10 09:30 09:50 10:10 10:30 10:50 11:10 11:30 11:50 12:20 12:30 12:50 13:10 13:30 13:50 14:10 14:30 14:50 15:10 15:30 15:50 16:10 16:30 16:50 17:20 17:30 17:50 18:10 18:30 18:50 19:05 19:30 20:00 20:30 21:00 21:30 22:30 23:30");
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
