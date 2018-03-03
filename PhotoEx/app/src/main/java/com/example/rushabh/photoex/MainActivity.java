package com.example.rushabh.photoex;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE=1;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button) findViewById(R.id.button);
        imageView=(ImageView) findViewById(R.id.imageView);

        //Check for camera
        if (!hasCamera()){
            button.setEnabled(false);
        }

    }

    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view){
        Toast.makeText(this, "aasa", Toast.LENGTH_SHORT).show();
        startActivityForResult(new Intent(MediaStore.ACTION_IMAGE_CAPTURE),REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_IMAGE_CAPTURE && resultCode== RESULT_OK){
            Bundle extras=data.getExtras();
            Bitmap photo= (Bitmap) extras.get("data");
            imageView.setImageBitmap(photo);
        }
    }

    public void shootVideo(View view) {
        startActivity(new Intent(this, VideoActivity.class));
    }
}