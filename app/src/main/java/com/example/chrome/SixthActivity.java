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

import com.example.chrome.databinding.ActivitySixthBinding;

public class SixthActivity extends AppCompatActivity {

    private ActivitySixthBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySixthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("Chrome", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        data = "We publish the Google Terms of Servise so that you know what to expect as you use our services. By clicking 'I agree', you agree to these terms." + "\n" + "\n" + "You are also agreeing to the Google Play Terms of Service to enable discovery and management of apps." + "\n" + "\n" + "And remember, the Google Privacy Policy describes how Google handles information generated as you use Google services. You can always visit your Google Account (account.google.com) to take a Privacy Checkup or to adjust your privacy controls.";
        editor.putString("agreement_data", data).commit();
        String agreement_data = sharedPreferences.getString("agreement_data", "");
        binding.tv.setText(agreement_data);
        String email_or_phone = sharedPreferences.getString("email_or_phone", "");
        binding.email.setText(email_or_phone);
        binding.agreementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SixthActivity.this, SeventhActivity.class);
                launcher.launch(intent1);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });

        Intent intent = new Intent();
        setResult(1, intent);

    }
}