package dev.gustavodahora.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.constraintlayout.widget.Constraints;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fltContacts;
    private ImageView setup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fltContacts = findViewById(R.id.floatingActionButton);
        setup = findViewById(R.id.img_menu);

        RecyclerView rvMain = findViewById(R.id.rv_main);

        List<MainItem> mainItems = new ArrayList<>();
        mainItems.add(new MainItem(1, R.drawable.person1, R.string.txt_person1, R.string.last_person1, false, R.string.time_person1));
        mainItems.add(new MainItem(2, R.drawable.person2, R.string.txt_person2, R.string.last_person2, false, R.string.time_person2));
        mainItems.add(new MainItem(3, R.drawable.person3, R.string.txt_person3, R.string.last_person3, false, R.string.time_person3));
        mainItems.add(new MainItem(4, R.drawable.person4, R.string.txt_person4, R.string.last_person4, false, R.string.time_person4));
        mainItems.add(new MainItem(5, R.drawable.person5, R.string.txt_person5, R.string.last_person5, false, R.string.time_person5));
        mainItems.add(new MainItem(6, R.drawable.person6, R.string.txt_person6, R.string.last_person6, false, R.string.time_person6));
        mainItems.add(new MainItem(7, R.drawable.person7, R.string.txt_person7, R.string.last_person7, false, R.string.time_person7));
        mainItems.add(new MainItem(8, R.drawable.person8, R.string.txt_person8, R.string.last_person8, false, R.string.time_person8));
        mainItems.add(new MainItem(9, R.drawable.person9, R.string.txt_person9, R.string.last_person9, false, R.string.time_person9));
        mainItems.add(new MainItem(10, R.drawable.person10, R.string.txt_person10, R.string.last_person10, false, R.string.time_person10));
        mainItems.add(new MainItem(11, R.drawable.person3, R.string.txt_person11, R.string.last_person10, false, R.string.time_person10));

        rvMain.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter(mainItems);

        rvMain.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        fltContacts.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Contacts.class));
        });

        setup.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, Setup.class));
        });
    }

    public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
        private final List<MainItem> mainItems;

        public MainAdapter(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MainViewHolder(getLayoutInflater().inflate(R.layout.chat_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MainActivity.MainAdapter.MainViewHolder holder, int position) {
            Log.d("chama", " " + position);
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }

        // Entenda como sendo a View da celula que está dentro do recycler
        private class MainViewHolder extends RecyclerView.ViewHolder {

            public MainViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(MainItem item) {
                ImageView imagePerson = itemView.findViewById(R.id.image_person);
                TextView namePerson = itemView.findViewById(R.id.txt_person_name);
                TextView lastPerson = itemView.findViewById(R.id.txt_last_person);
                TextView timePerson = itemView.findViewById(R.id.txt_time_person);
                View full = itemView.findViewById(R.id.layout_cns);

                imagePerson.setImageResource(item.getImageId());
                namePerson.setText(item.getNameId());
                lastPerson.setText(item.getLastChatId());
                timePerson.setText(item.getTime());

                full.setOnClickListener(view -> {
                    startActivity(new Intent(MainActivity.this, Conversation.class));
                });
            }
        }
    }
}