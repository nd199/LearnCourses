package com.narendran.learncourses.Service;


import com.narendran.learncourses.Entity.Learner;

import java.util.List;

public interface LearnerService {
    Learner addLearner(Learner learner);

    Learner findLearnerByEmailAndPassword(String email, String password);

    List<Learner> getAllLearners();
}
