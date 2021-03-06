package com.example.ashu.navigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class istFragment extends Fragment {

private  View view;
    String [] quantity={"anis","ayush","rakshya","sanjay"};
    ListView list;
    List<product> products=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_gallery, container, false);
        list = (ListView)view.findViewById(R.id.ivProduct);
//        ArrayAdapter <String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,quantity);
//        list.setAdapter(arrayAdapter);
        product p1=new product("rosahn","100","0.5");
        product p2=new product("ayush","120","0.4");
        products.add(p1);
        products.add(p2);
        itemadapter item=new itemadapter(getActivity(),R.layout.product_layout,products);
        list.setAdapter(item);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                product produc_pos=products.get(i);
                Toast.makeText(getActivity(), "You have Clicked "+produc_pos.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
