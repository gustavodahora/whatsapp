package dev.gustavodahora.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Setup extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        ImageView arrowReturn = findViewById(R.id.arrow_return);
        arrowReturn.setOnClickListener(view -> {
            startActivity(new Intent(Setup.this, MainActivity.class));
        });
    }

}