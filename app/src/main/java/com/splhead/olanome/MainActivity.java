package com.splhead.olanome;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;

import com.splhead.olanome.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String genderArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String maleOrFemale = adapterView.getItemAtPosition(position).toString();
                genderArticle = maleOrFemale.equals("Masculino") ? "o" : "a";
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        binding.bOk.setOnClickListener(view1 -> {
            String name = binding.etPersonName.getText().toString();
            binding.etPersonName.setText("");

            String out = "Olá, bem vind" + genderArticle + " " + name;

            binding.tvOut.setText(out);

            hiddenKeyboard(view1);
        });
    }

    private void hiddenKeyboard(View view) {
        if (view != null) {
            InputMethodManager inputeMethodManager =
                    (InputMethodManager) getSystemService(MainActivity.this.INPUT_METHOD_SERVICE);
            inputeMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}