package com.social.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.social.model.Update;

public interface UpdateRepository extends JpaRepository<Update, Integer> {

}
