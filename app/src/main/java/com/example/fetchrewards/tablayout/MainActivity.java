package com.example.fetchrewards.tablayout;

import android.os.Build;
//import android.support.design.widget.TabItem;
//import android.support.design.widget.TabLayout;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
//import android.support.v4.content.ContextCompat;
import androidx.core.content.ContextCompat;
//import android.support.v4.view.ViewPager;
import androidx.viewpager.widget.ViewPager;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    //public List<String> list;
    //public ArrayList<String> list = new ArrayList<>();
    //private List<String> list;
    private List<Integer> list;
    private ViewPager viewPager;
    private TabLayout tb;
    private TabItem t1,t2,t3;

    public MainActivity() {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //list = new ArrayList<String>();
        //list = new ArrayList<Integer>();

        //list.add("Ammara Rasheed");
        //list.add("Sara Khan");
        //list.add("Maham Saleem");
        //list.add("Ayesha Bibi");

        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);
        tb=findViewById(R.id.tab);
        viewPager=findViewById(R.id.viewPager);
        PageAdapter pageAdapter=new PageAdapter(getSupportFragmentManager(),tb.getTabCount());
        viewPager.setAdapter(pageAdapter);
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override

            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==1){
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.green1));
                    }
                }
                if(tab.getPosition()==2){
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.green2));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //this.Sample();
        //com.example.fetchrewards.tablayout.Sample();
        //list.add("Ammara Rasheed");
        //list.add("Sara Khan");
        //list.add("Maham Saleem");
        //list.add("Ayesha Bibi");

        //Log.i("creation2","list item: " + list.get(1));
    }
    /*
     * This class will add elements to
     * a shared list that is created with an Arraylist.
     */

    //class Write {
        //private List<String> list;
        // Receive a shared list in constructor
        //Write(List<String> list) {
            //this.list = list;
            //list = list;
        //}
        // add items
        //public void addItem(String item) {
            //this.list.add(item);
        //}
    //}

    //init
    /*
     * Read class will read elements form a shared list
     */
    /*class Read {

        private List<String> list;

        // Receive shared list in constructor
        Read(List<String> list) {
            this.list = list;
        }

        // Read the items
        public void readItem() {

            for (String item : list) {
                //System.out.println(item.toString());
                Log.i("creation2","item.toString(): " + item.toString());
            }
        }
    }
    // Test class.
    public class Sample{
        public void main(String[] args) {

            // Use synchronized list to avoid exception
            List<String> list = Collections
                    .synchronizedList(new ArrayList<String>());

            Write w = new Write(list);
            Read r = new Read(list);

            w.addItem("Apple");
            w.addItem("Mange");

            r.readItem();
        }
    }*/

    //public ArrayList<String> getList() {
    //public List<String> getList() {
    public List<Integer> getList() {
        return list;
        //return Collections.unmodifiableList( list );
    }
}
