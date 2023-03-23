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
    //private TabItem t1,t2,t3;
    private TabItem t1,t2,t3,t4;

    //private void init() {
        //Call after the constructor
        //jsonrequest();
    //}

    //public MainActivity() {
        //list = new ArrayList<Integer>();
        //list.add(1);
        //list.add(2);
        //list.add(3);
        //list.add(4);

        //jsonrequest();
        //lstEmployeeAll = new ArrayList<>();
        //lstEmployee1 = new ArrayList<>();
        //lstEmployee2 = new ArrayList<>();
        //lstEmployee3 = new ArrayList<>();
        //lstEmployee4 = new ArrayList<>();

        //jsonrequest();

        //Log.i("creation2", "in public constructor, lstEmployeeAll.size(): " + lstEmployeeAll.size());
        //Log.i("creation2", "in public constructor, lstEmployee1.size(): " + lstEmployee1.size());
    //}

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


        /*lstEmployeeAll = new ArrayList<>();
        lstEmployee1 = new ArrayList<>();
        lstEmployee2 = new ArrayList<>();
        lstEmployee3 = new ArrayList<>();
        lstEmployee4 = new ArrayList<>();*/

        //Log.i("creation2","list item: " + list.get(1));
        //jsonrequest();
    }
    //private void jsonrequest() {
    /*public void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("creation2", "just inside onresponse");
                JSONObject jsonObject  = null ;

                //lstEmployeeAll = new ArrayList<>();
                for (int i = 0 ; i < response.length(); i++ ) {
                    //Log.i("creation2", "just inside first for loop");
                    try {
                        jsonObject = response.getJSONObject(i) ;
                        Employee employee = new Employee() ;
                        employee.setName(jsonObject.getString("name"));
                        employee.setId(jsonObject.getString("id"));
                        employee.setListId(jsonObject.getString("listId"));
                        lstEmployeeAll.add(employee);

                    } catch (JSONException e) {
                        Log.i("creation2", "inside jsonexception");
                        e.printStackTrace();
                    }
                }
                Collections.sort(lstEmployeeAll, new Comparator<Employee>() {
                    @Override
                    public int compare(Employee lhs, Employee rhs) {
                        //Log.i("creation2", "just inside compare");
                        //Log.i("creation2", "just inside compare, lstEmployeeAll.size(): " + lstEmployeeAll.size());
                        int listCompare = Integer.compare(Integer.parseInt(lhs.getListId()), Integer.parseInt(rhs.getListId()));
                        //return nameCompare;
                        if(listCompare != 0) {
                            return listCompare;
                        }
                        //return lhs.getName().compareTo(rhs.getName());
                        return Integer.compare(Integer.parseInt(lhs.getId()), Integer.parseInt(rhs.getId()));
                    }
                });

                //lstEmployee1 = new ArrayList<>();
                //lstEmployee2 = new ArrayList<>();
                //lstEmployee3 = new ArrayList<>();
                //lstEmployee4 = new ArrayList<>();
                //Log.i("creation2", "just before 2nd for loop");
                Log.i("creation2", "just before 2nd for loop, lstEmployeeAll.size(): " + lstEmployeeAll.size());
                for (int i = 0 ; i < lstEmployeeAll.size(); i++ ) {
                    //Log.i("creation2", "just inside second for loop");
                    if (!lstEmployeeAll.get(i).getName().isEmpty() & lstEmployeeAll.get(i).getName() != "null") {
                        //Log.i("creation2", "just inside if statement of second for loop");
                        if (Integer.parseInt(lstEmployeeAll.get(i).getListId()) == 1) {
                            //Log.i("creation2", "in case 1");
                            lstEmployee1.add(lstEmployeeAll.get(i));
                        }
                        else if (Integer.parseInt(lstEmployeeAll.get(i).getListId()) == 2) {
                            lstEmployee2.add(lstEmployeeAll.get(i));
                        }
                        else if (Integer.parseInt(lstEmployeeAll.get(i).getListId()) == 3) {
                            lstEmployee3.add(lstEmployeeAll.get(i));
                        }
                        else if (Integer.parseInt(lstEmployeeAll.get(i).getListId()) == 4) {
                            lstEmployee4.add(lstEmployeeAll.get(i));
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request) ;
    }*/

    //public MainActivity() {
        //jsonrequest();
        //Log.i("creation2", "in public constructor, lstEmployeeAll.size(): " + lstEmployeeAll.size());
        //Log.i("creation2", "in public constructor, lstEmployee1.size(): " + lstEmployee1.size());
    //}
    //public List<Integer> getList() {
    /*public List<Employee> getList() {
        //return list;
        //return lstEmployee1;
        //Log.i("creation2","list size in getList: " + lstEmployeeAll.size());
        return lstEmployeeAll;
    }*/
}
