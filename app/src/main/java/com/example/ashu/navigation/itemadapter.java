package com.example.ashu.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashu on 8/29/2017.
 */
public class itemadapter extends ArrayAdapter {
    public List<product> product1=new ArrayList<>();
    private int resource;
    private LayoutInflater inflater;



    public itemadapter(Context context, int resource, List<product> product1) {
        super(context, resource, product1);
        this.product1 = product1;
        this.resource = resource;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewholder=new ViewHolder();

        if (convertView==null){
            convertView = inflater.inflate(R.layout.product_layout, null);
            viewholder.txtname=(TextView)convertView.findViewById(R.id.name);
            viewholder.txtprice=(TextView)convertView.findViewById(R.id.tvprice);
            viewholder.txtqty=(TextView)convertView.findViewById(R.id.tvqty);
            convertView.setTag(viewholder);
        }else {
            viewholder = (ViewHolder) convertView.getTag();
        }

        product current=product1.get(position);
        viewholder.txtname.setText(current.getName());
        viewholder.txtqty.setText(current.getQty());
        viewholder.txtprice.setText(current.getPrice());

        return convertView;
    }

    class ViewHolder {
        private TextView txtname,txtqty,txtprice;
    }
}
