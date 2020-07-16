package com.rakib.live_data_mvvm.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rakib.live_data_mvvm.R;
import com.rakib.live_data_mvvm.viewModel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    EditText inputOne, inputTwo;
    private MainActivityViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputOne = findViewById(R.id.input_one);
        inputTwo = findViewById(R.id.input_two);

        // Get the ViewModel.
        model = new ViewModelProvider(this).get(MainActivityViewModel.class);

        ((findViewById(R.id.add_btn))).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String v1 = inputOne.getText().toString().trim();
                String v2 = inputTwo.getText().toString().trim();

                if (v1.length() != 0 && v2.length() != 0){
                    model.getResult(v1, v2).observe(MainActivity.this, new Observer<String>() {
                        @Override
                        public void onChanged(String data) {
                            Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(MainActivity.this, "Please, enter your digit", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}