package com.example.chrome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chrome.databinding.ActivityFourthBinding;

public class FourthActivity extends AppCompatActivity {

    private ActivityFourthBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFourthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("Chrome", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        Intent intent = new Intent();
        setResult(1, intent);

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = binding.edit.getText().toString();
                if (s.isEmpty()) {
                    binding.error.setVisibility(View.VISIBLE);
                    binding.textLayout.setBoxStrokeErrorColor(ColorStateList.valueOf(Color.parseColor("#D5033E")));
                } else {
                    if (isValidEmail(s) || isValidPhoneNumber(s)) {
                        editor.putString("email_or_phone", s).commit();
                        Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
                        launcher.launch(intent);
                    } else {
                        Toast.makeText(FourthActivity.this, "Telefon raqami yoki emailni to`g`ri kiriting!", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                }
            });
        });

    }

    public static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    private boolean isValidPhoneNumber(String number) {
        return Patterns.PHONE.matcher(number).matches();
    }

}