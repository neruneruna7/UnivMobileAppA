package jp.ac.meijou.android.s221205059;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.io.StringBufferInputStream;

import jp.ac.meijou.android.s221205059.databinding.ActivityMain2Binding;
import jp.ac.meijou.android.s221205059.databinding.ActivityMainBinding;
import java.util.Stack;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private Stack<String> calcString;


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


        binding.buttonEq.setOnClickListener(view -> {



        });

        binding.buttonAdd.setOnClickListener(view -> {
            calcString.push(Operators.Add.operator);
            binding.textView2.setText(calcString.toString());

        });

        binding.buttonSub.setOnClickListener(view -> {
            calcString.push(Operators.Sub.operator);
            binding.textView2.setText(calcString.toString());

        });

        binding.buttonMulti.setOnClickListener(view -> {
            calcString.push(Operators.Multi.operator);
            binding.textView2.setText(calcString.toString());

        });

        binding.buttonDiv.setOnClickListener(view -> {
            calcString.push(Operators.Div.operator);
            binding.textView2.setText(calcString.toString());

        });

        binding.buttonAC.setOnClickListener(view -> {
            calcString.clear();
            binding.textView2.setText(calcString.toString());

        });

        binding.button0.setOnClickListener(view -> {
            calcString.push("0");
            binding.textView2.setText(calcString.toString());

        });

        binding.button1.setOnClickListener(view -> {
            calcString.push("1");
            binding.textView2.setText(calcString.toString());
        });

        binding.button2.setOnClickListener(view -> {
            calcString.push("2");
            binding.textView2.setText(calcString.toString());
        });

        binding.button3.setOnClickListener(view -> {
            calcString.push("3");
            binding.textView2.setText(calcString.toString());
        });

        binding.button4.setOnClickListener(view -> {
            calcString.push("4");
            binding.textView2.setText(calcString.toString());
        });

        binding.button5.setOnClickListener(view -> {
            calcString.push("5");
            binding.textView2.setText(calcString.toString());
        });

        binding.button6.setOnClickListener(view -> {
            calcString.push("6");
            binding.textView2.setText(calcString.toString());
        });

        binding.button7.setOnClickListener(view -> {
            calcString.push("7");
            binding.textView2.setText(calcString.toString());
        });

        binding.button8.setOnClickListener(view -> {
            calcString.push("8");
            binding.textView2.setText(calcString.toString());
        });

        binding.button9.setOnClickListener(view -> {
            calcString.push("9");
            binding.textView2.setText(calcString.toString());
        });
    }




}