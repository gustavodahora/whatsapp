package dev.gustavodahora.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Conversation extends AppCompatActivity {

    private ImageView btnReturn;
    private ImageView btnSetup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);
        btnReturn = findViewById(R.id.arrow_return);
        btnSetup = findViewById(R.id.img_menu);
    }

    @Override
    protected void onStart() {
        super.onStart();
        btnReturn.setOnClickListener(view -> {
            startActivity(new Intent (Conversation.this, MainActivity.class));
        });
        btnSetup.setOnClickListener(view -> {
            startActivity(new Intent (Conversation.this, Setup.class));
        });
    }

    public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
        private final List<MainChat> mainChat;
        private boolean isLeft;

        public ChatAdapter(List<MainChat> mainChats) {
            this.mainChat = mainChats;
        }

        @NonNull
        @Override
        public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

//            return new ChatAdapter.ChatViewHolder(getLayoutInflater().inflate(R.layout.chat_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
            MainChat mainChatItemCurrent = mainChat.get(position);
            holder.bind(mainChatItemCurrent);
        }

        public int getLayout() {

        }

        @Override
        public int getItemCount() {
            return mainChat.size();
        }

        private class ChatViewHolder extends RecyclerView.ViewHolder {

            public ChatViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(MainChat item) {

            }
        }
    }
}