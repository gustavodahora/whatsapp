package dev.gustavodahora.whatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Contacts extends AppCompatActivity {

    private ImageView arrowReturn;
    private ImageView setup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        arrowReturn = findViewById(R.id.arrow_return);
        setup = findViewById(R.id.img_menu);

        RecyclerView rvContacts = findViewById(R.id.rv_contacts);

        List<MainItem> contactItems = new ArrayList<>();
        contactItems.add(new MainItem(1, R.drawable.person1, R.string.txt_person1, R.string.last_person1, false, R.string.time_person1));
        contactItems.add(new MainItem(2, R.drawable.person2, R.string.txt_person2, R.string.last_person2, false, R.string.time_person2));
        contactItems.add(new MainItem(3, R.drawable.person3, R.string.txt_person3, R.string.last_person3, false, R.string.time_person3));
        contactItems.add(new MainItem(4, R.drawable.person4, R.string.txt_person4, R.string.last_person4, false, R.string.time_person4));
        contactItems.add(new MainItem(5, R.drawable.person5, R.string.txt_person5, R.string.last_person5, false, R.string.time_person5));
        contactItems.add(new MainItem(6, R.drawable.person6, R.string.txt_person6, R.string.last_person6, false, R.string.time_person6));
        contactItems.add(new MainItem(7, R.drawable.person7, R.string.txt_person7, R.string.last_person7, false, R.string.time_person7));
        contactItems.add(new MainItem(8, R.drawable.person8, R.string.txt_person8, R.string.last_person8, false, R.string.time_person8));
        contactItems.add(new MainItem(9, R.drawable.person9, R.string.txt_person9, R.string.last_person9, false, R.string.time_person9));
        contactItems.add(new MainItem(10, R.drawable.person10, R.string.txt_person10, R.string.last_person10, false, R.string.time_person10));

        rvContacts.setLayoutManager(new LinearLayoutManager(this));
        ContactsAdapter adapter = new ContactsAdapter(contactItems);

        rvContacts.setAdapter(adapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        arrowReturn.setOnClickListener(view -> {
            startActivity(new Intent(Contacts.this, MainActivity.class));
        });

        setup.setOnClickListener(view -> {
            startActivity(new Intent(Contacts.this, Setup.class));
        });
    }

    public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder> {
        private final List<MainItem> mainItems;

        public ContactsAdapter(List<MainItem> mainItems) {
            this.mainItems = mainItems;
        }

        @NonNull
        @Override
        public ContactsAdapter.ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ContactsAdapter.ContactsViewHolder(getLayoutInflater().inflate(R.layout.contact_item, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ContactsAdapter.ContactsViewHolder holder, int position) {
            Log.d("chama", " " + position);
            MainItem mainItemCurrent = mainItems.get(position);
            holder.bind(mainItemCurrent);
        }

        @Override
        public int getItemCount() {
            return mainItems.size();
        }

        // Entenda como sendo a View da celula que está dentro do recycler
        private class ContactsViewHolder extends RecyclerView.ViewHolder {

            public ContactsViewHolder(@NonNull View itemView) {
                super(itemView);
            }

            public void bind(MainItem item) {
                ImageView imagePerson = itemView.findViewById(R.id.image_person);
                TextView namePerson = itemView.findViewById(R.id.txt_person_name);

                imagePerson.setImageResource(item.getImageId());
                namePerson.setText(item.getNameId());
            }
        }
    }
}
