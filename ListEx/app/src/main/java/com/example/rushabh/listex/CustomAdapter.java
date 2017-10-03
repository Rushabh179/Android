package com.example.rushabh.listex;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> {


    CustomAdapter(@NonNull Context context, String[] names) {
        super(context,R.layout.custom_row ,names);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder")
        View customView=inflater.inflate(R.layout.custom_row,parent,false);///////
        String getSingleItem=getItem(position);
        TextView textView=(TextView) customView.findViewById(R.id.textView);
        ImageView imageView=(ImageView) customView.findViewById(R.id.imageView);

        textView.setText(getSingleItem);

        assert getSingleItem != null;
        switch (getSingleItem){
            case "Daenerys":
                imageView.setImageResource(R.drawable.emilia);
                break;
            case "Jon":
                imageView.setImageResource(R.drawable.kit);
                break;
            case "Tyrion":
                imageView.setImageResource(R.drawable.peter);
                break;
            case "Eddard":
                imageView.setImageResource(R.drawable.sean);
                break;
            case "Ramsay":
                imageView.setImageResource(R.drawable.iwan);
                break;
            default:
                imageView.setImageResource(R.drawable.profile);
                break;
        }

        return customView;
    }
}
