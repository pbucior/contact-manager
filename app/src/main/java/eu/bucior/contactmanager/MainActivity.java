package eu.bucior.contactmanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import eu.bucior.contactmanager.adapter.RecyclerViewAdapter;
import eu.bucior.contactmanager.data.DatabaseHandler;
import eu.bucior.contactmanager.model.Contact;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private ArrayList<Contact> contactArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        List<Contact> contactList = db.getAllContacts();
        contactArrayList = new ArrayList<>();

        for (Contact contact : contactList) {
            contactArrayList.add(contact);
        }

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);

        recyclerView.setAdapter(recyclerViewAdapter);


    }
}
