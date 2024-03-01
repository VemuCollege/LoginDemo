package com.mani.loginappdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class SuccessActivity extends Activity implements View.OnClickListener {

    ImageView ivPhoto;
    Button btnContact,btnMap,btnCamera;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btnContact = findViewById(R.id.btnContact);
        btnMap = findViewById(R.id.btnMap);
        btnCamera = findViewById(R.id.btnCamera);
        ivPhoto  = findViewById(R.id.ivPhoto);

        btnContact.setOnClickListener(this);
        btnMap.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnContact) {
            Intent intent = new Intent(Intent.ACTION_VIEW,ContactsContract.Contacts.CONTENT_URI);
            startActivity(intent);
        }
        else if (v.getId() == R.id.btnMap) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0=VEMU INSTITUTE OF TECHNOLOGY,CHITTOOR"));
            startActivity(mapIntent);
        }
        else if (v.getId() == R.id.btnCamera) {
            Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(cameraIntent,1001);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1001) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            ivPhoto.setImageBitmap(bitmap);
        }
    }
}
