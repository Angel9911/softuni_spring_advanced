package com.example.springsecurity.model.view;

public class StatView {
    private int authRequests;
    private int anonymousRequests;

    public StatView(int authRequests, int anonymousRequests) {
        this.authRequests = authRequests;
        this.anonymousRequests = anonymousRequests;
    }

    public int getAuthRequests() {
        return authRequests;
    }

    public void setAuthRequests(int authRequests) {
        this.authRequests = authRequests;
    }

    public int getAnonymousRequests() {
        return anonymousRequests;
    }

    public void setAnonymousRequests(int anonymousRequests) {
        this.anonymousRequests = anonymousRequests;
    }

    public int getTotalRequests(){
        return anonymousRequests+authRequests;
    }
}
