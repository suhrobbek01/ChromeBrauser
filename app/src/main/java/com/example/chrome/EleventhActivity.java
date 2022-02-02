package com.example.chrome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.chrome.databinding.ActivityEleventh2Binding;
import com.example.chrome.databinding.ActivitySecondBinding;

public class EleventhActivity extends AppCompatActivity {

    private ActivityEleventh2Binding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String url = "https://";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEleventh2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPreferences = getSharedPreferences("Web_Site", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String query = sharedPreferences.getString("query", "");
        if (query == "google.com/search?q=google+tranclate&oq=google+tranclate&aqs=chrome.0.69i59j0i10l9.7019j0j7&sourceid=chrome&ie=UTF-8#sbfbu=1&pi=google%20tranclate" || query == "championat.asia/") {
            binding.webView.loadUrl(url + query);
            Intent intent = new Intent();
            setResult(0, intent);
            finish();
        } else {
            binding.webView.loadUrl(url + query);
            Intent intent = new Intent();
            setResult(1, intent);
        }
    }


}
