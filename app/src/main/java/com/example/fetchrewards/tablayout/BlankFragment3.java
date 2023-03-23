package com.example.fetchrewards.tablayout;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {

    public BlankFragment3() {
        // Required empty public constructor
    }
    private final String JSON_URL = "https://fetch-hiring.s3.amazonaws.com/hiring.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<Employee> lstEmployeeAll;
    private List<Employee> lstEmployee3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lstEmployeeAll = new ArrayList<>();
        lstEmployee3 = new ArrayList<>();
        //Log.i("creation2","list item: " + list.get(1));
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("creation2", "just inside onresponse");
                JSONObject jsonObject = null;

                for (int i = 0; i < response.length(); i++) {
                    //Log.i("creation2", "just inside first for loop");
                    try {
                        jsonObject = response.getJSONObject(i);
                        Employee employee = new Employee();
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
                        if (listCompare != 0) {
                            return listCompare;
                        }
                        return Integer.compare(Integer.parseInt(lhs.getId()), Integer.parseInt(rhs.getId()));
                    }
                });

                //Log.i("creation2", "just before 2nd for loop");
                Log.i("creation2", "just before 2nd for loop, lstEmployeeAll.size(): " + lstEmployeeAll.size());
                for (int i = 0; i < lstEmployeeAll.size(); i++) {
                    //Log.i("creation2", "just inside second for loop");
                    if (!lstEmployeeAll.get(i).getName().isEmpty() & lstEmployeeAll.get(i).getName() != "null") {
                        //Log.i("creation2", "just inside if statement of second for loop");
                        if (Integer.parseInt(lstEmployeeAll.get(i).getListId()) == 3) {
                            //Log.i("creation2", "in case 1");
                            lstEmployee3.add(lstEmployeeAll.get(i));
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        requestQueue = Volley.newRequestQueue(this.getContext());
        requestQueue.add(request);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
        RecyclerView recyclerView=view.findViewById(R.id.recycler3);
        //RecyclerAdapter3 recyclerAdapter3 =new RecyclerAdapter3(lstEmployee3,getActivity());
        RecyclerAdapter recyclerAdapter =new RecyclerAdapter(lstEmployee3,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //recyclerView.setAdapter(recyclerAdapter3);
        recyclerView.setAdapter(recyclerAdapter);
        return view;
    }
}