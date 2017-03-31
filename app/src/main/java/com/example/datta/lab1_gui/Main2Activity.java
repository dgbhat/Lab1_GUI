package com.example.datta.lab1_gui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import static com.example.datta.lab1_gui.R.id.signup;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {


    private static final String TAG = "Main2Activity";
    private EditText EditTextEmail;
    private EditText EditTextPassword;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    private Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent i =getIntent();
        EditTextPassword = (EditText)findViewById(R.id.password);
        EditTextEmail = (EditText)findViewById(R.id.email);
        signup = (Button)findViewById(R.id.signup);
        signup.setOnClickListener(this);
        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        //TextView signin = (TextView)findViewById(R.id.signin);
        //signin.setOnClickListener(this);
        try {
            signup.setOnClickListener(this);
        }catch (RuntimeException e){
            Log.d(TAG, "onCreate: yoyoyoyoyoyoyooyo",e);
        }

    }
    private void register(){
        String email = EditTextEmail.getText().toString().trim();
        String password = EditTextPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter ur Email",Toast.LENGTH_SHORT);
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter ur Password",Toast.LENGTH_SHORT);
            return;
        }

        progressDialog.setMessage("Signing Up Please Wait ... ");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(Main2Activity.this,"Successfully registered",Toast.LENGTH_LONG).show();
                        }else{
                            //display some message here
                            Toast.makeText(Main2Activity.this,"Registration Error",Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }

                });

    }

    @Override
    public void onClick(View v) {
        if(v == signup)
        register();
    }
}
