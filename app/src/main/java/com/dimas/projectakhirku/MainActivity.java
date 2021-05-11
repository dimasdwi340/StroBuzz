package com.dimas.projectakhirku;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ImageView photoView;
    private static final int TIME_INTERVAL = 2000;
    private long mBackPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }
    public void onBackPressed(){
        if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(getBaseContext(), "Press again to exit", Toast.LENGTH_SHORT).show();
            mBackPressed=System.currentTimeMillis();
        }
    }
    public void Lokasi(View view) {
        Intent I = new Intent(this, rekomendasi.class);
        startActivity(I);
    }

    public void potret(View view) {
        Intent imageTaken = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if(imageTaken.resolveActivity(getPackageManager())!= null){
            startActivityForResult(imageTaken, REQUEST_IMAGE_CAPTURE);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            final Bitmap imageBitmap = (Bitmap) extras.get("data");
            final ByteArrayOutputStream stream = new ByteArrayOutputStream();
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            photoView = (ImageView) findViewById(R.id.photoView);
            photoView.setImageBitmap(imageBitmap);
            Intent sharingIntent = new Intent(Intent.ACTION_SEND);
            sharingIntent.addFlags(sharingIntent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
            sharingIntent.setType("image/*");
            sharingIntent.putExtra(Intent.EXTRA_STREAM, imageBitmap);
            startActivity(Intent.createChooser(sharingIntent, "Sharing Option"));

        }
    }
}
