package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import jp.ac.meijou.android.s221205059.databinding.ActivityMain3Binding;
import jp.ac.meijou.android.s221205059.databinding.ActivitySub4Binding;

public class SubActivity4 extends AppCompatActivity {

    private ActivitySub4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}