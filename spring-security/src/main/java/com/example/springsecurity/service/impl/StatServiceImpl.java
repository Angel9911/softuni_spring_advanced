package com.example.springsecurity.service.impl;

import com.example.springsecurity.model.view.StatView;
import com.example.springsecurity.service.StatService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class StatServiceImpl implements StatService {
    private int anonymousRequest;
    private int authRequest;

    @Override
    public void onRequest() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();// get the user who is logged in

        if(authentication!=null && (authentication.getPrincipal() instanceof UserDetails)){

            authRequest++;
        }else{

            anonymousRequest++;
        }

        System.out.println("anonymous req: "+anonymousRequest);
        System.out.println("auth req: "+authRequest);
    }

    @Override
    public StatView getStats() {

        StatView statView = new StatView(authRequest,anonymousRequest);

        return statView;
    }
}
