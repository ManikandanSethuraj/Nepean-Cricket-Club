package com.manikandansethuraj.nepeancricketclub;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class SchedulePage extends AppCompatActivity {

    ImageView pdfImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_page);

        pdfImageView = (ImageView) findViewById(R.id.pdfImageView);

        int pdf_width = pdfImageView.getWidth();
        int pdf_height = pdfImageView.getHeight();
        Bitmap bitmap = Bitmap.createBitmap(pdf_width, pdf_height, Bitmap.Config.ARGB_4444);
       // File pdfFile = new File(String.valueOf(R.drawable.manicv));

//        try {
//
//           // PdfRenderer pdfRenderer = new PdfRenderer(ParcelFileDescriptor.open(pdfFile, ParcelFileDescriptor.MODE_READ_ONLY));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
