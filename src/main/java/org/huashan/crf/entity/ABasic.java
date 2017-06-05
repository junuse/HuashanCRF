package org.huashan.crf.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "a_basics")
public class ABasic {

    @Id
    private ObjectId id;

    private String 	name;
    private Integer	sex;
    private Integer age;
    private String 	code1;
    private String  code2;
    private String  idcard;
    private String  telephone1;
    private String  telephone2;
    private String  cellphone1;
    private String  cellphone2;
    private String  cellphone3;
    private String  province;
    private String  district;
    private String  city;
    private String  admissionnum;

    public ABasic() {
    }
    


	public String getTelephone1() {
		return telephone1;
	}



	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}



	public String getTelephone2() {
		return telephone2;
	}



	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}



	public String getCellphone1() {
		return cellphone1;
	}



	public void setCellphone1(String cellphone1) {
		this.cellphone1 = cellphone1;
	}



	public String getCellphone2() {
		return cellphone2;
	}



	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
	}



	public String getCellphone3() {
		return cellphone3;
	}



	public void setCellphone3(String cellphone3) {
		this.cellphone3 = cellphone3;
	}



	public String getProvince() {
		return province;
	}



	public void setProvince(String province) {
		this.province = province;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getAdmissionnum() {
		return admissionnum;
	}



	public void setAdmissionnum(String admissionnum) {
		this.admissionnum = admissionnum;
	}



	public Integer getSex() {
		return sex;
	}



	public void setSex(Integer sex) {
		this.sex = sex;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

    
    
}
