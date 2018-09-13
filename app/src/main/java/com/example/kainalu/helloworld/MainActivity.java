package com.example.kainalu.helloworld;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String EXTRA_TEXT = "com.example.kainalu.EXTRA_TEXT";
    private final String EXTRA_TEXT_COLOR = "com.example.kainalu.EXTRA_TEXT_COLOR";
    private final String EXTRA_ROOT_COLOR = "com.example.kainalu.EXTRA_ROOT_COLOR";
    private TextView textView;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int BACKGROUND_COLOR = getResources().getColor(R.color.blue, null);
        final int TEXT_COLOR = getResources().getColor(R.color.black, null);
        textView = findViewById(R.id.textView);
        rootView = findViewById(R.id.rootView);

        if (savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(EXTRA_TEXT));
            textView.setTextColor(savedInstanceState.getInt(EXTRA_TEXT_COLOR));
            rootView.setBackgroundColor(savedInstanceState.getInt(EXTRA_ROOT_COLOR));
        }

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
                EditText editText = findViewById(R.id.editText);
                String newText = editText.getText().toString();

                if (TextUtils.isEmpty(newText)) {
                    textView.setText(R.string.greeting);
                } else {
                    textView.setText(newText);
                    editText.setText("");
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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_TEXT, textView.getText().toString());
        outState.putInt(EXTRA_TEXT_COLOR, textView.getCurrentTextColor());
        outState.putInt(EXTRA_ROOT_COLOR, ((ColorDrawable) rootView.getBackground()).getColor());
    }
}
