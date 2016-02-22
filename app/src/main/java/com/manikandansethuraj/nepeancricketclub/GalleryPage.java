package com.manikandansethuraj.nepeancricketclub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class GalleryPage extends AppCompatActivity {

    private GridView gridView;
    private GridviewAdapter gridviewAdapter;
    

   private ArrayList<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);


        gridView = (GridView) findViewById(R.id.galleryGridView);
        gridviewAdapter = new GridviewAdapter(GalleryPage.this, items);

        gridView.setAdapter(gridviewAdapter);

    }
}
