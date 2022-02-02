package com.example.chrome;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.example.chrome.databinding.ActivityTenthBinding;

public class TenthActivity extends AppCompatActivity {
    private ActivityTenthBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTenthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        sharedPreferences = getSharedPreferences("Web_Site", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        binding.search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                editor.putString("query", query).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);
                return false;
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        binding.googleTranclate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query1 = "google.com/search?q=google+tranclate&oq=google+tranclate&aqs=chrome.0.69i59j0i10l9.7019j0j7&sourceid=chrome&ie=UTF-8#sbfbu=1&pi=google%20tranclate";
                editor.putString("query", query1).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });
        binding.cha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query2 = "championat.asia/";
                editor.putString("query", query2).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });
        binding.unsplash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "unsplash.com";
                editor.putString("query", query).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });
        binding.kunUz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "kun.uz";
                editor.putString("query", query).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);

            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });
        binding.qalampirUz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "qalampir.uz";
                editor.putString("query", query).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });
        binding.daryoUz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = "daryo.uz";
                editor.putString("query", query).commit();
                Intent intent = new Intent(TenthActivity.this, EleventhActivity.class);
                launcher.launch(intent);
            }

            ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
                Intent data = result.getData();
            });
        });
        binding.account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    private static final String TAG = "TenthActivity";

    @Override
    public void onBackPressed() {
        Intent start = new Intent(Intent.ACTION_MAIN);
        start.addCategory(Intent.CATEGORY_HOME);
        start.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        start.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(start);
    }
}