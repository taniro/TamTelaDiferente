package br.ufrn.eaj.tads.tamteladiferente;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Fragment1();
            case 1:
                return new Fragment2();
            default:
                return null;
        }
    }


    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Tab1";
            case 1:
                return "Tab2";
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
