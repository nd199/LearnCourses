package com.narendran.learncourses.Service;


import com.narendran.learncourses.Entity.Provider;

public interface ProviderService {

    Provider addProvider(Provider provider);

    Provider findProviderByEmailAddressAndPassword(String email, String password);
}
