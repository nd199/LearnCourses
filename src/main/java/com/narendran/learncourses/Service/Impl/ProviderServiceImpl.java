package com.narendran.learncourses.Service.Impl;

import com.narendran.learncourses.Entity.Provider;
import com.narendran.learncourses.Repository.ProviderRepository;
import com.narendran.learncourses.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Provider addProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    @Override
    public Provider findProviderByEmailAddressAndPassword(String email, String password) {
        return providerRepository.findByEmailAndPassword(email, password);
    }


}
