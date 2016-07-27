package com.social.service;

import java.text.ParseException;
import java.util.List;

import com.social.DTO.SocialdetailsRequestDTO;
import com.social.exception.SocialdetailsNotFound;
import com.social.model.Socialdetails;

public interface SocialdetailsService {
	
	public Socialdetails create(Socialdetails socialdetails);
	public List<Socialdetails> findAll();
	public Socialdetails update(Socialdetails socialdetails) throws SocialdetailsNotFound;
	public Socialdetails findByid(Integer id) throws Exception;
	public SocialdetailsRequestDTO validate(SocialdetailsRequestDTO socialdetailsRequestDTO) throws ParseException, SocialdetailsNotFound;

}
