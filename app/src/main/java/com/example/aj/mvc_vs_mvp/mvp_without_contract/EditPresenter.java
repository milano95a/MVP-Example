package com.example.aj.mvc_vs_mvp.mvp_without_contract;

import android.text.TextUtils;

import com.example.aj.mvc_vs_mvp.Model;

public class EditPresenter {
    private final EditActivity view;
    private Model model;

    public EditPresenter(final EditActivity view){
        this.view = view;
    }

    public void setModel(final Model model){
        this.model = model;
        view.updateName(model.name);
    }

    public void updateUser(final String name){
        if(!TextUtils.isEmpty(name)){
            model.name = name;
            view.onSubmit(model);
        }
    }
}
