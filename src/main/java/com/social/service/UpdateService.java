package com.social.service;

import java.util.List;

import com.social.exception.UpdateNotFound;
import com.social.model.Update;

public interface UpdateService {
	
	public Update create(Update update);
	public Update delete(Integer id) throws UpdateNotFound;
	public List<Update> findAll();
	public Update update(Update update) throws UpdateNotFound;
	public Update findByid(Integer id);

}
