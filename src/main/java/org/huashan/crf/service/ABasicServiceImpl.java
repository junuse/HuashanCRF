package org.huashan.crf.service;

import java.util.List;

import org.huashan.crf.dao.ABasicDAO;
import org.huashan.crf.dao.BDemographicDAO;
import org.huashan.crf.dao.HResidentCheckDAO;
import org.huashan.crf.entity.ABasic;
import org.huashan.crf.entity.BDemographic;
import org.huashan.crf.entity.HResidentCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ABasicServiceImpl implements ABasicService {

	@Autowired
	ABasicDAO aBasicDAO;
	@Autowired
	HResidentCheckDAO hResidentCheckDAO;
	@Autowired
	BDemographicDAO bDemographicDAO;

	@Override
	public List<ABasic> findAByName(String name)  {
		List<ABasic> aBasics = aBasicDAO.findByNameLike(name);
		return aBasics;
	}
	
	@Override
	public ABasic saveA(ABasic doc) throws Exception {
		ABasic found = aBasicDAO.findOneByNameAndCode1AndCode2(doc.getName(), doc.getCode1(), doc.getCode2());
		
		if (found != null){
			doc.setId(found.getId());
		}
		return aBasicDAO.save(doc);
	}


	@Override
	public HResidentCheck saveH(HResidentCheck doc) throws Exception {
		HResidentCheck found = hResidentCheckDAO.findOneByNameAndCode1AndCode2(
				doc.getName(), doc.getCode1(), doc.getCode2());
		
		if (found != null){
			doc.setId(found.getId());
		}
		return hResidentCheckDAO.save(doc);
	}

	@Override
	public BDemographic saveB(BDemographic doc) throws Exception {
		BDemographic found = bDemographicDAO.findOneByNameAndCode1AndCode2(
				doc.getName(), doc.getCode1(), doc.getCode2());
		
		if (found != null){
			doc.setId(found.getId());
		}
		return bDemographicDAO.save(doc);
	}
}
