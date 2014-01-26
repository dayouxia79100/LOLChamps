package com.example.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by dayouxia on 1/21/14.
 */
public class GridFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main,container,false);



        GridView gridView = (GridView) v.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(getActivity()));

        gridView.setBackgroundResource(R.drawable.fiddle2);



        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),"Item at position "+i +" is pressed",Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }

    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mThumbIds.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            LinearLayout linearLayout;
            TextView textView;
            ImageView imageView;
            if (convertView == null) {  // if it's not recycled, initialize some attributes

                linearLayout = new LinearLayout(mContext);
                linearLayout.setGravity(Gravity.CENTER);
                imageView = new ImageView(mContext);
                textView = new TextView(mContext);


                textView.setText(mChamps[position]);
                textView.setTextColor(Color.WHITE);




                textView.setGravity(Gravity.CENTER);
                textView.setGravity(Gravity.CENTER_HORIZONTAL);



                imageView.setLayoutParams(new GridView.LayoutParams(150, 150));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
                linearLayout.addView(textView);
                linearLayout.addView(imageView);
                linearLayout.setOrientation(1);
            } else {
                linearLayout = (LinearLayout) convertView;
            }


            ((ImageView)linearLayout.getChildAt(1)).setImageResource(mThumbIds[position]);




            return linearLayout;
        }

        // references to our images
        private Integer[] mThumbIds = {
                R.drawable.aatrox, R.drawable.ahri,
                R.drawable.akali, R.drawable.alistar,
                R.drawable.amumu, R.drawable.anivia,
                R.drawable.annie
        };


        private  String[] mChamps = {
                "Aatrox", "Ahri",
                "Akali", "Alistar",
                "Amumu", "Anivia",
                "Annie"
        };
    }

}
