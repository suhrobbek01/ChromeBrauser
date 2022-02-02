package com.example.chrome;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import com.example.chrome.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    private int a = 0;

    private static boolean ischecked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.switchView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ischecked = true;
                    binding.switchTv.setText("on");
                } else {
                    ischecked = false;
                    binding.switchTv.setText("off");
                }
            }
        });

        binding.nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                launcher.launch(intent);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });


        Intent intent = new Intent();
        setResult(1, intent);

       /* int i = Integer.parseInt(key);
        a = i;

        if (a == 1) {
            binding.nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setResult(1, intent);
                    finish();
                }
            });*/
    }


    private static final String TAG = "SecondActivity";

    @Override
    protected void onResume() {
        super.onResume();
        if (ischecked) {
            binding.switchView.setChecked(true);
        } else {
            binding.switchView.setChecked(false);
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (binding.switchView.isChecked()) {
            binding.switchView.setChecked(true);
        } else {
            binding.switchView.setChecked(false);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.switchView.setChecked(false);
    }
}