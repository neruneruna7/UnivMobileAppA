package jp.ac.meijou.android.s221205059;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.IOException;
import java.util.Optional;

import jp.ac.meijou.android.s221205059.databinding.ActivityNetworkBinding;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetworkActivity extends AppCompatActivity {

    private final OkHttpClient okHttpClient = new OkHttpClient();

    private final Moshi moshi = new Moshi.Builder().build();

    private final JsonAdapter<Gist> gistJsonAdapter = moshi.adapter(Gist.class);

    private ActivityNetworkBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNetworkBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.imButton.setOnClickListener(view -> {
            var imText = binding.imEditText.getText().toString();
//            var imUrlText = String.format("https://placehold.jp/808080/ffffff/150x150.png?text=%s", imText);
            var url = Uri.parse("https://placehold.jp/500x500.png")
                    .buildUpon()
                    .appendQueryParameter("text", imText)
                    .build()
                    .toString();

            getImage(url);



        });

//        getImage("https://placehold.jp/350x350.png");

    }

    private void getImage(String url) {

//        binding.gistText.setText("LOADING...");
        binding.progressBar.setVisibility(View.VISIBLE);

        var imRequest = new Request.Builder()
                .url(url)
                .build();

        okHttpClient.newCall(imRequest).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                var bitmap = BitmapFactory.decodeStream(response.body().byteStream());

                runOnUiThread(() -> {
                    binding.imageView.setImageBitmap(bitmap);
//                    binding.gistText.setText("LOADED!");
                    binding.progressBar.setVisibility(View.INVISIBLE);

                });
            }
        });

    }
}