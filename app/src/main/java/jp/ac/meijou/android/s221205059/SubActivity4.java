package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Optional;

import jp.ac.meijou.android.s221205059.databinding.ActivityMain3Binding;
import jp.ac.meijou.android.s221205059.databinding.ActivitySub4Binding;

public class SubActivity4 extends AppCompatActivity {

    private ActivitySub4Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Optional.ofNullable(getIntent().getStringExtra("text"))
                        .ifPresent(text -> binding.textView3.setText(text));

        binding.buttonOk.setOnClickListener(view -> {
            var intent2 = new Intent();
            intent2.putExtra("ret", "OK");
            setResult(RESULT_OK, intent2);
            finish();
        });


        binding.buttonCancel.setOnClickListener(view -> {
            setResult(RESULT_CANCELED);
            finish();
        });


    }
}