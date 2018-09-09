package com.example.kainalu.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int BACKGROUND_COLOR = getResources().getColor(R.color.blue, null);
        final int TEXT_COLOR = getResources().getColor(R.color.black, null);
        final TextView textView = findViewById(R.id.textView);
        final View rootView = findViewById(R.id.rootView);

        findViewById(R.id.textColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setTextColor(getResources().getColor(R.color.colorPrimary, null));
            }
        });

        findViewById(R.id.viewColorButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootView.setBackgroundColor(
                        getResources().getColor(R.color.red, null));
            }
        });

        findViewById(R.id.textChangeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = ((EditText) findViewById(R.id.editText)).getText().toString();

                if (TextUtils.isEmpty(newText)) {
                    textView.setText(R.string.greeting);
                } else {
                    textView.setText(newText);
                }
            }
        });

        findViewById(R.id.rootView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootView.setBackgroundColor(BACKGROUND_COLOR);
                textView.setTextColor(TEXT_COLOR);
                textView.setText(R.string.greeting);
            }
        });
    }
}
