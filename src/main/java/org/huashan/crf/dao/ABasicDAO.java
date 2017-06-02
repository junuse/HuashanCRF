package org.huashan.crf.dao;

import java.util.List;

import org.huashan.crf.entity.ABasic;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ABasicDAO extends MongoRepository<ABasic, String> {

    List<ABasic> findByNameLike(String name);
    ABasic findOneByNameAndCode1AndCode2(String name, String code1, String code2);

    long countByName(String name);

}