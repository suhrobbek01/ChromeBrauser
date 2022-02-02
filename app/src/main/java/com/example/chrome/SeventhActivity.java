package com.example.chrome;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.chrome.databinding.ActivitySeventhBinding;

public class SeventhActivity extends AppCompatActivity {

    private ActivitySeventhBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String Tv3;
    private String Tv4;
    private String Tv5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySeventhBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("Chrome", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String email_or_phone = sharedPreferences.getString("email_or_phone", "");
        binding.tv2.setText(email_or_phone);
        Tv3 = "Tap to learn more about each service, such as how to turn it on or off later. Data will be used according to Google`s Privacy Policy";
        Tv4 = "Easily restoreyour data or switch phones at any time. Your backup includes apps, app data, call history, contacts, device settings(including Wi-Fi passwords and permissions),and SMS.";
        Tv5 = "Your backups are uploaded to Google and encrypted using your Google Account passowrd. For some data, your device`s screen lock PIN, pattern, or passwords is also used for encryption.";
        editor.putString("Tv3", Tv3).commit();
        editor.putString("Tv4", Tv4).commit();
        editor.putString("Tv5", Tv5).commit();
        String tv3 = sharedPreferences.getString("Tv3", "");
        String tv4 = sharedPreferences.getString("Tv4", "");
        String tv5 = sharedPreferences.getString("Tv5", "");
        binding.tv3.setText(tv3);
        binding.tv4.setText(tv4);
        binding.tv5.setText(tv5);
        binding.accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SeventhActivity.this, NinethActivity.class);
                launcher.launch(intent);

            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    result.getData();
                }
            });
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SeventhActivity.this, EighthActivity.class);
        startActivity(intent);

    }


}