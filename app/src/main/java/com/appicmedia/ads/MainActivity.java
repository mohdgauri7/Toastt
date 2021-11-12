package com.appicmedia.ads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.appicmedia.toast.ShowToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShowToast showToast = new ShowToast();
        showToast.ToastShow(this,"my message");

    }
}