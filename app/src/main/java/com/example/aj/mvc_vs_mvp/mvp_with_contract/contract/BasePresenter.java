package com.example.aj.mvc_vs_mvp.mvp_with_contract.contract;

import com.example.aj.mvc_vs_mvp.Model;

public interface BasePresenter {
    void setModel(Model model);
    void updateModel(String name);
}
