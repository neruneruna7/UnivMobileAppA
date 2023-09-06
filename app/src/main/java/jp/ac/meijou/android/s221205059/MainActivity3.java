package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import jp.ac.meijou.android.s221205059.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s221205059.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonM.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity4.class );
            startActivity(intent);
        });

        binding.buttonA.setOnClickListener(view -> {
            var intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(("https://www.yahoo.co.jp")));
            startActivity(intent);
        });

    }
}