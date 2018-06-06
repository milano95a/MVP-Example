package com.example.aj.mvc_vs_mvp.mvc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aj.mvc_vs_mvp.Model;
import com.example.aj.mvc_vs_mvp.R;

public class EditController extends AppCompatActivity {

    public static final String EXTRA_USER = "user";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        final EditText nameText = findViewById(R.id.name);
        Button updateBtn = findViewById(R.id.update);

        final Model model = getIntent().getParcelableExtra(EXTRA_USER);
        nameText.setText(model.name);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameText.getText().toString();
                if(!TextUtils.isEmpty(name)){
                    model.name = name;
                    setResult(RESULT_OK, new Intent().putExtra(EXTRA_USER, model));
                    finish();
                }
            }
        });
    }
}
