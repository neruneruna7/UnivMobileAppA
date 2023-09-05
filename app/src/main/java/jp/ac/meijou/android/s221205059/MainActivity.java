package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
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

        binding.button.setOnClickListener(view -> {
            binding.text.setText(R.string.kani);
        });

        binding.button2.setOnClickListener(View -> {
            binding.imageView2.setImageResource(R.drawable.baseline_restaurant_menu_24);
        });

    }
}