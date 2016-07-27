package com.social.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.social.DTO.SocialdetailsRequestDTO;
import com.social.DTO.SocialdetailsResponseDTO;
import com.social.DTO.UpdateStatusDTO;
import com.social.exception.SocialdetailsNotFound;
import com.social.model.Socialdetails;
import com.social.repository.SocialdetailsRepository;
import com.social.service.SocialdetailsService;

@Controller
@RequestMapping(value = "/adddetails")
public class SocialdetailsController {

	@Autowired
	private SocialdetailsService socialdetailsService;
	
	@Autowired
	private SocialdetailsRepository socialdetailsRepository;

	public Socialdetails modifyToSocialdetails(SocialdetailsRequestDTO request) throws ParseException {

		Socialdetails socialdetails = new Socialdetails();

		socialdetails.setname(request.getname());
		socialdetails.setsex(request.getsex());
		socialdetails.setlocation(request.getlocation());
		socialdetails.setmobilenumber(request.getmobilenumber());
		socialdetails.setemail(request.getemail());
		socialdetails.setbirthday(request.getbirthday());
		socialdetails.setprofilepic(request.getprofilepic());
		socialdetails.setid(request.getid());
		socialdetails.setstatus(request.getstatus());
		socialdetails.seterror(request.geterror());

		return socialdetails;
	}
	
	public SocialdetailsResponseDTO modifyFromSocialdetailsToSocialdetailsResponseDTO(Socialdetails socialdetails ){
		System.out.println(" Social details Controller Initialized");
		SocialdetailsResponseDTO response = new SocialdetailsResponseDTO();
		
		
		response.setname(socialdetails.getname());
		response.setsex(socialdetails.getsex());
		response.setlocation(socialdetails.getlocation());
		response.setmobilenumber(socialdetails.getmobilenumber());
		response.setemail(socialdetails.getemail());
		response.setbirthday(socialdetails.getbirthday());
		response.setid(socialdetails.getid());
		response.setprofilepic(socialdetails.getprofilepic());
		response.setstatus(socialdetails.getstatus());
		response.seterror(socialdetails.geterror());
		
		
		return response;
	}
	
	

	 @RequestMapping(value = "/add", method = RequestMethod.POST, consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SocialdetailsResponseDTO createnewid(@RequestBody SocialdetailsRequestDTO SocialdetailsRequest) throws ParseException  {

		SocialdetailsResponseDTO response = new SocialdetailsResponseDTO();
		SocialdetailsRequestDTO r;
		
			try {
				r = socialdetailsService.validate(SocialdetailsRequest);
			} catch (ParseException e) {
				response.setstatus("error");
				response.seterror("not in proper format");
				e.printStackTrace();
				return response;
			}catch (SocialdetailsNotFound e) {
				response.setstatus("error");
				response.seterror("not in proper format");
				e.printStackTrace();
				return response;
			}
		
		if (r.getstatus() == "error") {
			System.out.println("valildation have errors");
			response.setstatus(r.getstatus()); 
			response.seterror(r.geterror());
			return response;
		}
		Gson gson = new Gson();
		System.out.println("after validation \t" + gson.toJson(r));  
		
		Socialdetails socialdetails = modifyToSocialdetails(r);

		System.out.println("\ncalling Social details service create method\n");
		socialdetails = socialdetailsService.create(socialdetails);
		response = modifyFromSocialdetailsToSocialdetailsResponseDTO(socialdetails);
		response.setstatus("ok");
		response.seterror(null);
		response.setid(socialdetails.getid());
		
		
		return response;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<SocialdetailsResponseDTO> SocialdetailsListPage() {

		List<Socialdetails> socialdetailsList = socialdetailsRepository.findAll();
		List<SocialdetailsResponseDTO> response = new ArrayList<SocialdetailsResponseDTO>();
		for(Socialdetails itertor : socialdetailsList){
			SocialdetailsResponseDTO r = modifyFromSocialdetailsToSocialdetailsResponseDTO(itertor);
			response.add(r);
		}
		
		return response;
	}

	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody SocialdetailsResponseDTO editSocialdetails(@RequestBody /* @Valid */ UpdateStatusDTO updateStatusDTO)
			throws SocialdetailsNotFound {
		Gson gson = new Gson();
		Socialdetails id = socialdetailsRepository.findByid(updateStatusDTO.getid());
		SocialdetailsResponseDTO response = new SocialdetailsResponseDTO();
		if(id == null){
			response.setstatus("error");
			response.seterror("Id does not exists");
			System.out.println("id == null\t" + gson.toJson(id));
			return response;
		}
		
		
		try {
			id = socialdetailsService.update(id);
			
		} catch (SocialdetailsNotFound e) {
			response.setstatus("error");
			response.seterror("id doesnot exists");
			throw new SocialdetailsNotFound();
		}
		response = modifyFromSocialdetailsToSocialdetailsResponseDTO(id);
		response.setstatus("ok");
		response.setid(response.getid());
		return response;
	}
}
