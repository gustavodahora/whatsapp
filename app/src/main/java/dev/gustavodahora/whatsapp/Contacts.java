package dev.gustavodahora.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Contacts extends AppCompatActivity {

    private ImageView arrowReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        arrowReturn = findViewById(R.id.arrow_return);
    }

    @Override
    protected void onStart() {
        super.onStart();
        arrowReturn.setOnClickListener(view -> {
            startActivity(new Intent(Contacts.this, MainActivity.class));
        });
    }
}
