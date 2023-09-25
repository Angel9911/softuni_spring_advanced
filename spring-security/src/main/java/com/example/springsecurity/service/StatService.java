package com.example.springsecurity.service;

import com.example.springsecurity.model.view.StatView;

public interface StatService {
    void onRequest();
    StatView getStats();
}
