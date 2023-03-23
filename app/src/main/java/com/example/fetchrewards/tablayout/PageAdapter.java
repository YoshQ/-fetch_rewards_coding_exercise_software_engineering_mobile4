package com.example.fetchrewards.tablayout;

//import android.support.v4.app.Fragment;
import androidx.fragment.app.Fragment;
//import android.support.v4.app.FragmentManager;
import androidx.fragment.app.FragmentManager;
//import android.support.v4.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {
    private int numbrofTab;
    public PageAdapter(FragmentManager fm, int numbrofTab) {
        super(fm);
        this.numbrofTab=numbrofTab;

    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                return new BlankFragment();
            case 1:
                return new BlankFragment2();
            case 2:
                return new BlankFragment3();
            case 3:
                return new BlankFragment4();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return numbrofTab;
    }
}
