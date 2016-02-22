package com.manikandansethuraj.nepeancricketclub;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by ManikandanSethuraj on 2016-02-22.
 */
public class GridviewAdapter extends BaseAdapter{


    private Context context;
    private String[] items;

    public  GridviewAdapter(Context context, String[] items){
        super();
        this.context = context;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int position) {
        return items[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView img;
        WindowManager window = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;

        if (convertView == null){
            img = new ImageView(context);
            convertView = img;
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setPadding(5, 5, 5, 5);
        }else {
            img = (ImageView) convertView;
            img.setPadding(5,5,5,5);
        }

        Picasso.with(context)
                .load(items[position])
                .placeholder(R.drawable.load)
                .error(R.drawable.error)
                .resize(200, 300)
                .into(img);
        return convertView;



    }
}
