package com.aamjantamedia.ajm.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aamjantamedia.ajm.Article;
import com.aamjantamedia.ajm.R;
import com.aamjantamedia.ajm.RecyclerViewAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private DatabaseReference myDatabaseReference;
    private String ItemId;
    private List<Article> ItemList;
    private RecyclerView mRecyclerview;
    private RecyclerViewAdapter mAdapter;

    public HomeFragment(){

    }
    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //RecyclerView
        mRecyclerview = root.findViewById(R.id.recycler);
        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));

        // for data persistence
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        myDatabaseReference=FirebaseDatabase.getInstance().getReference("Article");
        ItemId= myDatabaseReference.push().getKey();

        //adapter
        //mRecyclerview.setAdapter(new RecyclerViewAdapter(initData(),getContext()));
         initData();

        return root;
    }

    //private List<Article> initData() {
    private void initData(){

        ItemList =new ArrayList<>();


        myDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> snapshotIterator = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = snapshotIterator.iterator();
                while((iterator.hasNext())){
                    Article item = iterator.next().getValue(Article.class);
                    ItemList.add(item);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mAdapter = new RecyclerViewAdapter(ItemList,getContext());
        mRecyclerview.setAdapter(mAdapter);


        //return ItemList;
    }
}