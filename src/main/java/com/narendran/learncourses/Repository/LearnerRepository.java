package com.narendran.learncourses.Repository;

import com.narendran.learncourses.Entity.Learner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LearnerRepository extends JpaRepository<Learner, Long> {

}