package com.example.aj.mvc_vs_mvp.mvp_with_contract.contract;

import com.example.aj.mvc_vs_mvp.Model;

public interface BaseView {
    void updateName(String name);
    void onSubmit(Model model);
}
