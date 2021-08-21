package dev.gustavodahora.whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class Conversation extends AppCompatActivity {

    private ImageView btnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        btnReturn = findViewById(R.id.arrow_return);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnReturn.setOnClickListener(view -> {
            startActivity(new Intent (Conversation.this, MainActivity.class));
        });
    }
}