package com.social.serviceImpl;


import java.text.ParseException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.social.DTO.SocialdetailsRequestDTO;
import com.social.exception.SocialdetailsNotFound;
import com.social.model.Socialdetails;
import com.social.repository.SocialdetailsRepository;
import com.social.service.SocialdetailsService;


@Service
public class SocialdetailsServiceImpl implements SocialdetailsService

{
	
	@Resource
	private SocialdetailsRepository socialdetailsRepository;
	
	@Transactional
	public Socialdetails create(Socialdetails socialdetails){
		return socialdetailsRepository.save(socialdetails);
	}
	
	@Transactional
	public List<Socialdetails> findAll() {
		return socialdetailsRepository.findAll();
	}
	
	@Transactional
	public Socialdetails findByid(Integer id) throws Exception {
		return socialdetailsRepository.findByid(id);
	}

	@Transactional(rollbackFor=SocialdetailsNotFound.class)
	public Socialdetails update(Socialdetails Socialdetails) throws SocialdetailsNotFound 
	{
		Socialdetails updatedStatus = socialdetailsRepository.findByid(Socialdetails.getid());
		
		
		if (updatedStatus == null)
		throw new SocialdetailsNotFound();

		String status;
		if(Socialdetails.getstatus() != null){
			status = "false";
		}else{
			status = "true";
		}
		updatedStatus.setstatus(status);
		System.out.println("=============================");
		System.out.println("\n\nSocialdetails\t");
		
		return updatedStatus;
	}
	
	public SocialdetailsRequestDTO validate(SocialdetailsRequestDTO dto) throws ParseException, SocialdetailsNotFound{

		dto.getemail();
		
		System.out.println("\n in validate method for addSocialdetails  \n");
		
			if(dto.getemail() == null){
			dto.setstatus("error");
			dto.seterror("enter email");
			System.out.println("email is not entered\n");
			return dto;
		     }
		Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = pattern.matcher(dto.getemail());
		dto.setstatus("ok");
		dto.seterror(null);
		
		if (matcher.matches()) {   
            System.out.println("\n pattern of email matches  \n");
        }else{
        	dto.setstatus("error");
        	dto.seterror("pattern of email matches is not in proper format");
        	return dto;
        }
		
		dto.getname();
		
		if(dto.getname() == null){
			dto.setstatus("error");
			dto.seterror("enter name");
			System.out.println("name is not entered\n");
			return dto;
		}
		
		Pattern pattern1 = Pattern.compile("^[\\p{L} .'-]+${2,60})");
		Matcher matcher1 = pattern1.matcher(dto.getname());
		dto.setstatus("ok");
		dto.seterror(null);
		
		if (matcher1.matches()) {   
            System.out.println("\n pattern of name matches  \n");
        }else{
        	dto.setstatus("error");
        	dto.seterror("pattern of name is not in proper format");
        	return dto;
        	}
        	        	
        dto.getsex();
        	
       if(dto.getsex() == null){
    			dto.setstatus("error");
    			dto.seterror("enter sex");
    			System.out.println("sex is not entered\n");
    			return dto;
        	}
        	
    		Pattern pattern2 = Pattern.compile("^M(ale)?$|^F(emale)?$");
    		Matcher matcher2 = pattern2.matcher(dto.getsex());
    		dto.setstatus("ok");
    		dto.seterror(null);
    		
    		if (matcher2.matches()) {   
                System.out.println("\n pattern of gender matches  \n");
            }else{
            	dto.setstatus("error");
            	dto.seterror("pattern of gender is not in proper format");
            	return dto;
            }
            	            	
           dto.getmobilenumber();
            	
            	
            if(dto.getmobilenumber() == null){
        			dto.setstatus("error");
        			dto.seterror("enter mobile number");
        			System.out.println("mobilenumber is not entered\n");
        			return dto;
            	    }
         
        		Pattern pattern3 = Pattern.compile("^[0-9]{9,10})");
        		Matcher matcher3 = pattern3.matcher(dto.getmobilenumber());
        		dto.seterror(null);
        		
        		if (matcher3.matches()) {   
                    System.out.println("\n pattern of mobile number matches  \n");
                }
        		else{
                	dto.setstatus("error");
                	dto.seterror("pattern of mobile number is not in proper format");
                	return dto;
                    }
        		
        		
        		 Integer id = dto.getid();
            	             	
             if(dto.getid() == 0){
             			dto.setstatus("error");
             			dto.seterror("enter id");
             			System.out.println("id is not entered\n");
             			return dto;
                 	    }
              
               /* Pattern pattern4 = Pattern.compile("^-?\\d{1,19}$");
             		Matcher matcher4 = pattern4.matcher(dto.getid());
             		dto.seterror(null);
             		
             		if (matcher4.matches()) {   
                         System.out.println("\n pattern of id matches  \n");
                     }
             		else{
                     	dto.setstatus("error");
                     	dto.seterror("pattern of id is not in proper format"); 
                     	return dto; 
	                      }       */	
       		       
        		           
		if(socialdetailsRepository.countByid(id).intValue()> 1){
			dto.setstatus("error");
        	dto.seterror("id already exists");
        	return dto;
		}
		return null;
		
}

		
}


