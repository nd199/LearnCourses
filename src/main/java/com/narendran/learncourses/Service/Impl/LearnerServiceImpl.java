package com.narendran.learncourses.Service.Impl;

import com.narendran.learncourses.Entity.Learner;
import com.narendran.learncourses.Repository.LearnerRepository;
import com.narendran.learncourses.Service.LearnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearnerServiceImpl implements LearnerService {

    @Autowired
    private LearnerRepository learnerRepository;


    @Override
    public Learner addLearner(Learner learner) {
        return learnerRepository.save(learner);
    }

    @Override
    public Learner findLearnerByEmailAndPasswordAndConfirmPassword(String email, String password, String confirmPassword) {
        return learnerRepository.findByEmailAndPasswordAndConfirmPassword(email, password, confirmPassword);
    }

    @Override
    public List<Learner> getAllLearners() {
        return learnerRepository.findAll();
    }
}
