package com.example.chrome;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.chrome.databinding.ActivityNinethBinding;

public class NinethActivity extends AppCompatActivity {

    private ActivityNinethBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String Tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNinethBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences("Chrome", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String email_or_password = sharedPreferences.getString("email_or_phone", "");
        binding.tv2.setText(email_or_password);

        Tv4 = "Google may use your history to personalize Search, ads, and other Google services";
        editor.putString("Tv4", Tv4).commit();
        String TV4 = sharedPreferences.getString("Tv4", "");
        binding.tv4.setText(TV4);
        binding.rightBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NinethActivity.this, TenthActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(NinethActivity.this, SecondActivity.class);
        intent.putExtra("key", "1");
        launcher.launch(intent);
    }

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        Intent data = result.getData();
    });
}