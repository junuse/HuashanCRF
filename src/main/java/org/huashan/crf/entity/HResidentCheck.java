package org.huashan.crf.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "h_resident_check")
public class HResidentCheck {

    @Id
    private ObjectId id;

    private String 	name;
    private String 	code1;
    private String  code2;
    
    private Boolean isbloodgathered;
    private String 	bloodyear;
    private String 	bloodmonth;
    private String  bloodday;
    private String  bloodclock;

    public HResidentCheck() {
    }

	public HResidentCheck(String name, String code1, String code2, Boolean isbloodgathered, String bloodyear,
			String bloodmonth, String bloodday, String bloodclock) {
		super();
		this.name = name;
		this.code1 = code1;
		this.code2 = code2;
		this.isbloodgathered = isbloodgathered;
		this.bloodyear = bloodyear;
		this.bloodmonth = bloodmonth;
		this.bloodday = bloodday;
		this.bloodclock = bloodclock;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
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

	public Boolean getIsbloodgathered() {
		return isbloodgathered;
	}

	public void setIsbloodgathered(Boolean isbloodgathered) {
		this.isbloodgathered = isbloodgathered;
	}

	public String getBloodyear() {
		return bloodyear;
	}

	public void setBloodyear(String bloodyear) {
		this.bloodyear = bloodyear;
	}

	public String getBloodmonth() {
		return bloodmonth;
	}

	public void setBloodmonth(String bloodmonth) {
		this.bloodmonth = bloodmonth;
	}

	public String getBloodday() {
		return bloodday;
	}

	public void setBloodday(String bloodday) {
		this.bloodday = bloodday;
	}

	public String getBloodclock() {
		return bloodclock;
	}

	public void setBloodclock(String bloodclock) {
		this.bloodclock = bloodclock;
	}
    


    
    
}
