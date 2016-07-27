package com.social.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.social.exception.SocialdetailsNotFound;
import com.social.model.Socialdetails;



public interface SocialdetailsRepository extends JpaRepository<Socialdetails, Integer>{
	
	
		public Socialdetails findByid(Integer id) throws SocialdetailsNotFound;
		
	
	@Query(value="SELECT COUNT(*) FROM social_master WHERE id= :id",nativeQuery=true)
	public BigInteger countByid(@Param("id") Integer id);
	
	/* @Query(value="SELECT COUNT(*) FROM promocod_transaction_details WHERE merchant_id= :merchantId and promocode= :promocode",nativeQuery=true)
	public BigInteger countByMerchantIDAndPromocode(@Param("merchantId") long merchantId
	*/

}
