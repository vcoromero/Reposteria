package com.example.vcoromero.reposteria;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MenuActivity extends AppCompatActivity {

    //CarouselView carouselView;

    //int[] sampleImages = {R.drawable.coficial, R.drawable.poficial, R.drawable.goficial};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        //carouselView = (CarouselView) findViewById(R.id.carouselView);
      //  carouselView.setPageCount(sampleImages.length);

        //carouselView.setImageListener(imageListener);
    }

    /*
    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
    */

    public void close(View v) {
        MenuActivity.this.finish();
    }

    public void openPasteles(View v){
        Intent i = new Intent(MenuActivity.this, TipoPastelActivity.class);
        startActivity(i);
    }
}
