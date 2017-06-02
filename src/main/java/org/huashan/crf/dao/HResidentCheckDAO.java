package org.huashan.crf.dao;

import org.huashan.crf.entity.HResidentCheck;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface HResidentCheckDAO extends MongoRepository<HResidentCheck, String> {

	HResidentCheck findOneByNameAndCode1AndCode2(String name, String code1, String code2);

}