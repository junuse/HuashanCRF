package org.huashan.crf.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "a_basics")
public class ABasic {

    @Id
    private ObjectId id;

    private String 	name;
    private Boolean	ismale;
    private Integer age;
    private String 	code1;
    private String  code2;
    private String  idcard;

    public ABasic() {
    }
    

	public ABasic(String name, Boolean ismale, Integer age, String code1, String code2, String idcard) {
		super();
		this.name = name;
		this.ismale = ismale;
		this.age = age;
		this.code1 = code1;
		this.code2 = code2;
		this.idcard = idcard;
	}


	public Boolean getIsmale() {
		return ismale;
	}


	public void setIsmale(Boolean ismale) {
		this.ismale = ismale;
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
