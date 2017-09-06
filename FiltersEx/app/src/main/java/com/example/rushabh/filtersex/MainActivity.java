package com.example.rushabh.filtersex;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView myImageView;
    Drawable myImage;
    Bitmap bitmapImage;
    //Button button1=(Button) findViewById(R.id.button1);
    //Button button2=(Button) findViewById(R.id.button2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myImageView=(ImageView) findViewById(R.id.myImageView);
    }

    public void invertPhoto(View view){
        myImage= ContextCompat.getDrawable(this,R.drawable.me);
        bitmapImage=((BitmapDrawable) myImage).getBitmap();
        Bitmap newPhoto=invertImage(bitmapImage);
        myImageView.setImageBitmap(newPhoto);
        MediaStore.Images.Media.insertImage(getContentResolver(),newPhoto,"Title","Description");
    }

    public void framePhoto(View view){
        Drawable[] layers=new Drawable[2];
        layers[0]=ContextCompat.getDrawable(this,R.drawable.me);
        layers[1]=ContextCompat.getDrawable(this,R.drawable.filter);
        LayerDrawable layerDrawable= new LayerDrawable(layers);
        myImageView.setImageDrawable(layerDrawable);
    }

    public static Bitmap invertImage(Bitmap original){
        Bitmap finalImage=Bitmap.createBitmap(original.getWidth(),original.getHeight(),original.getConfig());

        int A,R,G,B;
        int pixelColor;

        for (int i=0;i<original.getWidth();i++){
            for (int j=0;j<original.getHeight();j++){
                pixelColor=original.getPixel(i,j);
                A= Color.alpha(pixelColor);
                R=255-Color.red(pixelColor);
                G=255-Color.green(pixelColor);
                B=255-Color.blue(pixelColor);
                finalImage.setPixel(i,j,Color.argb(A,R,G,B));
            }
        }
        return finalImage;
    }
}