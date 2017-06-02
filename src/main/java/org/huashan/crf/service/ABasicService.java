package org.huashan.crf.service;

import java.util.List;

import org.huashan.crf.entity.ABasic;
import org.huashan.crf.entity.HResidentCheck;

public interface ABasicService {
	public List<ABasic> findAByName(String name) ;
//	public ABasic findAByCode1AndCode2(String code1, String code2);
	
	public ABasic saveA(ABasic doc) throws Exception;
	
//	public HResidentCheck findHByCode1AndCode2(String code1, String code2);
	public HResidentCheck saveH(HResidentCheck doc) throws Exception;
}
