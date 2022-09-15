package com.narendran.learncourses.Repository;

import com.narendran.learncourses.Entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

}