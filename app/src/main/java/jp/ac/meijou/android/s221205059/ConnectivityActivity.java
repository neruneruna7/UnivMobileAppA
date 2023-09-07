package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.LinkAddress;
import android.net.NetworkCapabilities;
import android.os.Bundle;

import java.util.stream.Collectors;

import jp.ac.meijou.android.s221205059.databinding.ActivityConnectivityBinding;
import jp.ac.meijou.android.s221205059.databinding.ActivityNetworkBinding;

public class ConnectivityActivity extends AppCompatActivity {

    private ActivityConnectivityBinding binding;
    private ConnectivityManager connectivityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConnectivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        connectivityManager = getSystemService(ConnectivityManager.class);

        var correntNetwork = connectivityManager.getActiveNetwork();
        updateTransport(correntNetwork);
        updateIpAddress(correntNetwork);
    }

    private void updateTransport(Network network) {
        var caps = connectivityManager.getNetworkCapabilities(network);

        if (caps != null) {
            String transport;
            if (caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                transport = "モバイル通信";
            } else if (caps.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                transport = "Wifi";
            }else {
                transport = "そのほか";
            }

            binding.TransportKindtTextView.setText(transport);
        }
    }

    private void updateIpAddress(Network network) {
        var linkProperties = connectivityManager.getLinkProperties(network);




        if (linkProperties != null) {
            var addresses = linkProperties.getLinkAddresses().stream()
                    .map(LinkAddress::toString)
                    .collect(Collectors.joining("\n"));




            binding.ipTextView.setText(addresses);
        }
    }

}