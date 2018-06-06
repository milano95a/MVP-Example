package com.example.aj.mvc_vs_mvp.mvp_without_contract;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aj.mvc_vs_mvp.Model;
import com.example.aj.mvc_vs_mvp.R;

public class EditActivity extends AppCompatActivity {

    public static final String EXTRA_USER = "user";
    private EditPresenter presenter;
    EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        nameText = findViewById(R.id.name);
        final Button submitButton = findViewById(R.id.update);

        presenter = new EditPresenter(this);
        Model model = getIntent().getParcelableExtra(EXTRA_USER);
        presenter.setModel(model);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.updateUser(nameText.getText().toString());
            }
        });

    }

    public void updateName(final String name){
        nameText.setText(name);
    }

    public void onSubmit(final Model model){
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_USER, model));
        finish();
    }
}
