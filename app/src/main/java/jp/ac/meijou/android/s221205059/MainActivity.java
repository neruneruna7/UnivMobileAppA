package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import jp.ac.meijou.android.s221205059.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // javaのenum使いづらい？
    enum TextContent {
        Gorira(R.string.gorira),
        Kani(R.string.kani);

        private int id;
        private TextContent(int id) {
            this.id = id;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] texts = {TextContent.Gorira.id, TextContent.Kani.id};

        binding.button.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            binding.text.setText(text);

        });

        binding.button2.setOnClickListener(View -> {
            binding.imageView2.setImageResource(R.drawable.baseline_restaurant_menu_24);
        });

        binding.editTextText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.text.setText(String.format("%s%s", s.toString(), binding.editTextText2.getText().toString()));
            }
        });

        binding.editTextText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.text.setText(String.format("%s%s", s.toString(), binding.editTextText.getText().toString()));
            }
        });

    }
}