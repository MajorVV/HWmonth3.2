package com.android1.hwmonth32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private  int mValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView valueTv = findViewById(R.id.tv_counter);

        findViewById(R.id.tv_minus).setOnClickListener(v -> {
            mValue--;
            valueTv.setText(String.valueOf(mValue));
        });
        findViewById(R.id.tv_plus).setOnClickListener(v -> {
            mValue++;
            valueTv.setText(String.valueOf(mValue));
        });

        findViewById(R.id.btn_reset).setOnClickListener(v -> {
            int oldValue = mValue;
            mValue = 0;
            valueTv.setText(String.valueOf(mValue));
            Snackbar.make(v, "Счётчик очищен: ", Snackbar.LENGTH_SHORT)
                    .setAction("Отмена", ignored -> {
                        mValue = oldValue;
                        valueTv.setText(String.valueOf(mValue));
                    })
                    .show();
        });
    }
}