package com.example.fetchrewards.tablayout;

import android.os.Build;
//import android.support.design.widget.TabItem;
//import android.support.design.widget.TabLayout;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
//import android.support.v4.content.ContextCompat;
import androidx.core.content.ContextCompat;
//import android.support.v4.view.ViewPager;
import androidx.viewpager.widget.ViewPager;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
//public class MainActivity {
    //public List<String> list;
    //public ArrayList<String> list = new ArrayList<>();
    //private List<String> list;
    //private List<Integer> list;
    private final String JSON_URL = "https://fetch-hiring.s3.amazonaws.com/hiring.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue ;
    private List<Employee> lstEmployeeAll;
    private List<Employee> lstEmployee1;
    private List<Employee> lstEmployee2;
    private List<Employee> lstEmployee3;
    private List<Employee> lstEmployee4;
    private ViewPager viewPager;
    private TabLayout tb;
    private TabItem t1,t2,t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                if(tab.getPosition()==3){
                    if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.green1));
                    }
                }
                if(tab.getPosition()==4){
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
    }
}
