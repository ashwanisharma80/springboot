package com.droidinfotech.packages.model;

import org.springframework.data.repository.CrudRepository;

import com.droidinfotech.packages.model.Questions;

// This will be AUTO IMPLEMENTED by Spring into a Bean called questionRepository
// CRUD refers Create, Read, Update, Delete

public interface QuestionsRepository extends CrudRepository<Questions, Integer> {
    
}
