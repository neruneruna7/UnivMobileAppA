package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;
import androidx.datastore.preferences.core.PreferencesKeys;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import jp.ac.meijou.android.s221205059.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private PrefDataStore prefDataStore;

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
        prefDataStore = PrefDataStore.getInstance(this);


        binding.changeButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            binding.textView.setText(text);
        });

        binding.saveButton.setOnClickListener(view -> {
            var text = binding.editTextText.getText().toString();
            prefDataStore.setString("name", text);
        });

        binding.deleteButton.setOnClickListener(view -> {
            var prefkey = PreferencesKeys.stringKey("name");
            prefDataStore.set(prefkey, "");
        });

        Log.d("name", "onCreate text " + binding.textView.getText());
    }


    @Override
    protected void onStart() {
        super.onStart();
        prefDataStore.getString("name")
                .ifPresent(name -> binding.textView.setText(name));

        Log.d("name", "onStart text " + binding.textView.getText());

    }
}
