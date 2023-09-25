package com.example.springsecurity.service;


import com.example.springsecurity.model.service.OfferServiceModel;
import com.example.springsecurity.model.view.AddOfferViewModel;
import com.example.springsecurity.model.view.OfferSummaryViewModel;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
public interface OfferService {

    List<OfferSummaryViewModel> getAllOffers();

    Long saveOffer(AddOfferViewModel addOfferViewModel, Principal principal);

    OfferServiceModel findOfferById(Long id);

    void delete(Long id);

    Long updateOffer(OfferServiceModel offerServiceModel);
}
