package org.huashan.crf.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "b_demographic")
public class BDemographic {

    @Id
    private ObjectId id;

    private String 	name;
    private String 	code1;
    private String  code2;

	private Integer	nation;
    private Integer marital;
    
    private Integer dwelling;
    private Boolean dwell_children;
    private Boolean dwell_mate;
    private Boolean dwell_parent;
    private Boolean dwell_relative;
    private Boolean dwell_nurse;
    private Boolean dwell_other;
    
    private Integer edu;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;
//    private Integer ;

    public void fillCid(Cid cid) {
    	setName(cid.getName());
    	setCode1(cid.getCode1());
    	setCode2(cid.getCode2());
    }
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public Integer getMarital() {
		return marital;
	}

	public void setMarital(Integer marital) {
		this.marital = marital;
	}

	public Integer getDwelling() {
		return dwelling;
	}

	public void setDwelling(Integer dwelling) {
		this.dwelling = dwelling;
	}

	public Boolean getDwell_children() {
		return dwell_children;
	}

	public void setDwell_children(Boolean dwell_children) {
		this.dwell_children = dwell_children;
	}

	public Boolean getDwell_mate() {
		return dwell_mate;
	}

	public void setDwell_mate(Boolean dwell_mate) {
		this.dwell_mate = dwell_mate;
	}

	public Boolean getDwell_parent() {
		return dwell_parent;
	}

	public void setDwell_parent(Boolean dwell_parent) {
		this.dwell_parent = dwell_parent;
	}

	public Boolean getDwell_relative() {
		return dwell_relative;
	}

	public void setDwell_relative(Boolean dwell_relative) {
		this.dwell_relative = dwell_relative;
	}

	public Boolean getDwell_nurse() {
		return dwell_nurse;
	}

	public void setDwell_nurse(Boolean dwell_nurse) {
		this.dwell_nurse = dwell_nurse;
	}

	public Boolean getDwell_other() {
		return dwell_other;
	}

	public void setDwell_other(Boolean dwell_other) {
		this.dwell_other = dwell_other;
	}

	public Integer getEdu() {
		return edu;
	}

	public void setEdu(Integer edu) {
		this.edu = edu;
	}
}
