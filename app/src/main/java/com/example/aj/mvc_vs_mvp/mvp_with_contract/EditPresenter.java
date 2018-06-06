package com.example.aj.mvc_vs_mvp.mvp_with_contract;

import android.text.TextUtils;

import com.example.aj.mvc_vs_mvp.Model;
import com.example.aj.mvc_vs_mvp.mvp_with_contract.contract.BasePresenter;
import com.example.aj.mvc_vs_mvp.mvp_with_contract.contract.BaseView;

public class EditPresenter implements BasePresenter{
    private final BaseView view;
    private Model model;

    public EditPresenter(final EditActivity view){
        this.view = view;
    }

    @Override
    public void setModel(Model model) {
        this.model = model;
        view.updateName(model.name);
    }

    @Override
    public void updateModel(String name) {
        if(!TextUtils.isEmpty(name)){
            model.name = name;
            view.onSubmit(model);
        }
    }
}
