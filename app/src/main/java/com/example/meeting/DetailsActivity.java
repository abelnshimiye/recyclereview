package com.example.meeting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    TextView txt_name, txt_description;
    ImageView image_language;

    String descript, name;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        txt_name = findViewById(R.id.text_name);
        txt_description = findViewById(R.id.text_description);
        image_language = findViewById(R.id.imageView_laguage);

        getData();
        setData();
    }


    private void getData(){

        if (getIntent().hasExtra("nameoflaguage") && getIntent().hasExtra("description") && getIntent().hasExtra("image")){
            descript = getIntent().getStringExtra("nameoflaguage");
            name = getIntent().getStringExtra("description");
            images = getIntent().getIntExtra("image", 1);


        }else{
            Toast.makeText(getApplicationContext(),"no data to desplay", Toast.LENGTH_LONG).show();
        }


    }

    private void setData(){
        txt_description.setText(descript);
        txt_name.setText(name);
        image_language.setImageResource(images);
    }



}