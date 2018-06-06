package com.example.aj.mvc_vs_mvp.mvp_with_contract;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aj.mvc_vs_mvp.Model;
import com.example.aj.mvc_vs_mvp.R;
import com.example.aj.mvc_vs_mvp.mvp_with_contract.contract.BasePresenter;
import com.example.aj.mvc_vs_mvp.mvp_with_contract.contract.BaseView;

public class EditActivity extends AppCompatActivity implements BaseView{

    public static final String EXTRA_USER = "user";
    private BasePresenter presenter;
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
                presenter.updateModel(nameText.getText().toString());
            }
        });
    }

    @Override
    public void updateName(String name) {
        nameText.setText(name);
    }

    @Override
    public void onSubmit(Model model) {
        setResult(RESULT_OK, new Intent().putExtra(EXTRA_USER, model));
        finish();
    }
}
