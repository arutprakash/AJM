package com.aamjantamedia.ajm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {

    private static final String TAG = "MainActivity3";
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        (findViewById(R.id.saveButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Title = ((EditText) findViewById(R.id.editTitle)).getText().toString();
                String Content = ((EditText) findViewById(R.id.editContent)).getText().toString();

                // Write a message to the database
                mDatabase = FirebaseDatabase.getInstance();
                mDbRef = mDatabase.getReference("Article");
                //Setting firebase unique key for Hashmap list
                String userId = mDbRef.push().getKey();
                // creating user object
                Article item = new Article(Title, Content);
                mDbRef.child(userId).setValue(item);
                finish();

            }
        });
    }
}

