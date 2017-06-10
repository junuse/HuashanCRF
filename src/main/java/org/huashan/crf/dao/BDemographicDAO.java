package org.huashan.crf.dao;

import java.util.List;

import org.huashan.crf.entity.BDemographic;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BDemographicDAO extends MongoRepository<BDemographic, String> {

    List<BDemographic> findByNameLike(String name);
    BDemographic findOneByNameAndCode1AndCode2(String name, String code1, String code2);

    long countByName(String name);

}