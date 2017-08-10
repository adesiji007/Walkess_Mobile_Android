package com.example.adesiji.Walkess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adesiji on 28/11/2015.
 */
public class ListDataAdapter extends ArrayAdapter {


    List list = new ArrayList();

    public ListDataAdapter(Context context, int resource) {
        super(context, resource);
    }
    static class LayoutHandler
    {
        TextView NAME, ADDRESS, MOB, EMAIL,DATE,TIME, ID ;
        //Button DATE,TIME;
    }

    @Override
    public void add(Object object)
    {
        super.add(object);
        list.add(object);
    }

    @Override
    public   int getCount()
    {
        return list.size();
    }


    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View row = convertView;
        LayoutHandler layoutHandler;
        // check if row is available or not
        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout, parent, false);
            layoutHandler = new LayoutHandler();
            layoutHandler.NAME = (TextView)row.findViewById(R.id.text_user_name);
            layoutHandler.ADDRESS = (TextView)row.findViewById(R.id.text_user_address);
            layoutHandler.MOB = (TextView)row.findViewById(R.id.text_user_mobile);
            layoutHandler.EMAIL = (TextView)row.findViewById(R.id.text_user_email);
            layoutHandler.DATE = (TextView)row.findViewById(R.id.text_user_date);
            layoutHandler.TIME = (TextView)row.findViewById(R.id.text_user_time);
            layoutHandler.ID = (TextView)row.findViewById(R.id.text_user_id);
            row.setTag(layoutHandler);

        }

        else
        {
            layoutHandler = (LayoutHandler)row.getTag();

        }
        DataProvider dataProvider = (DataProvider) this.getItem(position);
        layoutHandler.NAME.setText(dataProvider.getName());
        layoutHandler.ADDRESS.setText(dataProvider.getEmail());
        layoutHandler.MOB.setText(dataProvider.getMob());
        layoutHandler.EMAIL.setText(dataProvider.getEmail());
        layoutHandler.DATE.setText(dataProvider.getEmail());
        layoutHandler.TIME.setText(dataProvider.getEmail());
        layoutHandler.ID.setText(dataProvider.getEmail());
        //return super.getView(position, convertView, parent);
        return row;
    }

}
