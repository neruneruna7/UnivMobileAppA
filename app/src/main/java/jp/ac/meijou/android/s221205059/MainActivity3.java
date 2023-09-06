package jp.ac.meijou.android.s221205059;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import java.util.Optional;

import jp.ac.meijou.android.s221205059.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s221205059.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    private final ActivityResultLauncher<Intent> getActivityResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                switch (result.getResultCode()){
                    case RESULT_OK:
                        Optional.ofNullable(result.getData())
                                .map(data -> data.getStringExtra("ret"))
                                .map(text -> "Result" + text)
                                .ifPresent(text -> binding.textView4.setText(text));
                        break;
                    case RESULT_CANCELED:
                        binding.textView4.setText("Result: canceled");
                        break;
                    default:
                        binding.textView4.setText("Result: Unknown(" + result.getResultCode() + ")");
                        break;
                }
            }
    );
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

        binding.sendButton.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity4.class );
            intent.putExtra("text", binding.editTextText2.getText().toString());
            startActivity(intent);
        });

        binding.buttonActivate.setOnClickListener(view -> {
            var intent = new Intent(this, SubActivity4.class);
            getActivityResult.launch(intent);
        });



    }
}