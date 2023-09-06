package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.io.StringBufferInputStream;

import jp.ac.meijou.android.s221205059.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s221205059.databinding.ActivityMainBinding;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private String calcString;

    private ArrayList<Integer> InvPolandOpcode;
    private String InvPolandOperand;


    // javaのenum使いづらい？
    enum Operators {
        Add("+"),
        Sub("-"),
        Multi("×"),
        Div("÷");

        private String operator;
        private Operators(String operator) {
            this.operator = operator;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        binding.textView2.setVisibility(View.GONE);

        binding.buttonAdd.setOnClickListener(view -> {
            calcString.concat(Operators.Add.operator);
            binding.textView2.setText(calcString);

        });

        binding.buttonSub.setOnClickListener(view -> {
            calcString.concat(Operators.Sub.operator);
            binding.textView2.setText(calcString);

        });

        binding.buttonMulti.setOnClickListener(view -> {
            calcString.concat(Operators.Multi.operator);
            binding.textView2.setText(calcString);

        });

        binding.buttonDiv.setOnClickListener(view -> {
            calcString.concat(Operators.Div.operator);
            binding.textView2.setText(calcString);

        });

        binding.buttonAC.setOnClickListener(view -> {
            calcString = "".toString();
            binding.textView2.setText(calcString);

        });

        binding.button0.setOnClickListener(view -> {
            calcString.concat("0");
            binding.textView2.setText(calcString);

        });

        binding.button1.setOnClickListener(view -> {
            calcString.concat("1");
            binding.textView2.setText(calcString);
        });

        binding.button2.setOnClickListener(view -> {
            calcString.concat("2");
            binding.textView2.setText(calcString);
        });

        binding.button3.setOnClickListener(view -> {
            calcString.concat("3");
            binding.textView2.setText(calcString);
        });

        binding.button4.setOnClickListener(view -> {
            calcString.concat("4");
            binding.textView2.setText(calcString);
        });

        binding.button5.setOnClickListener(view -> {
            calcString.concat("5");
            binding.textView2.setText(calcString);
        });

        binding.button6.setOnClickListener(view -> {
            calcString.concat("6");
            binding.textView2.setText(calcString);
        });

        binding.button7.setOnClickListener(view -> {
            calcString.concat("7");
            binding.textView2.setText(calcString);
        });

        binding.button8.setOnClickListener(view -> {
            calcString.concat("8");
            binding.textView2.setText(calcString);
        });

        binding.button9.setOnClickListener(view -> {
            calcString.concat("9");
            binding.textView2.setText(calcString);
        });
    }




}