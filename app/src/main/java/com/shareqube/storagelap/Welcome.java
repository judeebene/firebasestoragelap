package com.shareqube.storagelap;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG =  Welcome.class.getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        findViewById(R.id.explore_button).setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.explore_button:
                mAuth.signInAnonymously().addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Intent feedsIntent = new Intent(Welcome.this, Discovery.class);
                        startActivity(feedsIntent);
                    }
                }).addOnFailureListener( new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Welcome.this, "Unable to sign in anonymously. enable anonymous authentication in firebase",
                                Toast.LENGTH_SHORT).show();
                        Log.e(TAG, e.getMessage());
                    }
                });
                break;


        }
    }
}
