package com.social.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.social.exception.UpdateNotFound;
import com.social.model.Update;
import com.social.repository.UpdateRepository;
import com.social.service.UpdateService;

@Service
public class UpdateServiceImpl implements UpdateService {
	
	@Resource
	private UpdateRepository updateRepository;

	@Transactional
	public Update create(Update update) {
		Update createdUpdate = update;
		return updateRepository.save(createdUpdate);
	}
	
	@Transactional
	public Update findByid(Integer id) {
		return updateRepository.findOne(id);
	}

	@Transactional(rollbackFor=UpdateNotFound.class)
	public Update delete(Integer id) throws UpdateNotFound {
		Update deletedUpdate = updateRepository.findOne(id);
		
		if (deletedUpdate == null)
			throw new UpdateNotFound();
		
		updateRepository.delete(deletedUpdate);
		return deletedUpdate;
	}

	@Transactional
	public List<Update> findAll() {
		return updateRepository.findAll();
	}

	@Transactional(rollbackFor=UpdateNotFound.class)
	public Update update(Update update) throws UpdateNotFound {
		Update updatedUpdate = updateRepository.findOne(update.getid());
		
		if (updatedUpdate == null)
			throw new UpdateNotFound();
		
		
		updatedUpdate.setname(update.getname());
		updatedUpdate.setsex(update.getsex());
		updatedUpdate.setlocation(update.getlocation());
		updatedUpdate.setmobilenumber(update.getmobilenumber());
		updatedUpdate.setemail(update.getemail());
		updatedUpdate.setbirthday(update.getbirthday());
		updatedUpdate.setprofilepic(update.getprofilepic());
		updatedUpdate.setid(update.getid());
		
		return updatedUpdate;
	}

	/* @Override
	public Update create(Update update) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Update delete(String email) throws UpdateNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Update update(Update update) throws UpdateNotFound {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Update findByemail(String email) {
		// TODO Auto-generated method stub
		return null;
	} */

}
