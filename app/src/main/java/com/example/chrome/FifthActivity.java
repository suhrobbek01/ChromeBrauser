package com.example.chrome;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.chrome.databinding.ActivityFifthBinding;

public class FifthActivity extends AppCompatActivity {

    private ActivityFifthBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFifthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("Chrome", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Intent intent = new Intent();
        setResult(1, intent);
        String email_or_phone = sharedPreferences.getString("email_or_phone", "");
        binding.email.setText(email_or_phone);
        binding.textLayout.setBoxStrokeColor(Color.parseColor("#0288D1"));

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.edit.getText().toString();
                if (s.equals("")) {
                    binding.error.setVisibility(View.VISIBLE);
                } else {
                    editor.putString("password", s).commit();
                    Intent intent1 = new Intent(FifthActivity.this, SixthActivity.class);
                    launcher.launch(intent1);
                }
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });


    }
}