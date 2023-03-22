package com.example.fetchrewards.tablayout;


import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {
//public class BlankFragment {

    //MainActivity mainActivity = new MainActivity();
    private MainActivity mainActivity;
    public BlankFragment() {
        // Required empty public constructor
        mainActivity = new MainActivity();
        List<Integer> list = mainActivity.getList();
        //hurray !
        Log.i("creation2","list size: " + list.size());
        Log.i("creation2","list item: " + list.get(1));
    }


    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_blank, container, false);
        //FloatingActionButton floatingActionButton=v.findViewById(R.id.btnFloating);
        //floatingActionButton.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //final Dialog dialog=new Dialog(getContext());
                //dialog.setContentView(R.layout.dialog_layout);
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                //Button btn=dialog.findViewById(R.id.btn1);


                /*btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText text=dialog.findViewById(R.id.code);
                        String text1=text.getText().toString();
                        Toast.makeText(getContext(),"Code is"+text1,Toast.LENGTH_LONG).show();
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });*/
        //new MainActivity.Sample() sample = MainActivity.Sample();
        //MainActivity mainActivity = new MainActivity();
        //MainActivity.Sample();
        //ArrayList<String> listContent = new ArrayList<String>(mainActivity.list);
        //ArrayList<String> listContent = mainActivity.getList();
        //List<String> listContent = mainActivity.getList();
        //List<Integer> listContent = mainActivity.getList();

        //Log.i("creation2","list item: " + listContent.get(1));
        //Log.i("creation2","list size: " + listContent.size());
        /*return v;
    }

    public BlankFragment() {

    }*/

}
