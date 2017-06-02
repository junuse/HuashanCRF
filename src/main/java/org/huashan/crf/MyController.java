package org.huashan.crf;


import java.util.ArrayList;

import org.huashan.crf.dao.ABasicDAO;
import org.huashan.crf.dao.HResidentCheckDAO;
import org.huashan.crf.entity.ABasic;
import org.huashan.crf.entity.HResidentCheck;
import org.huashan.crf.service.ABasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController
@Controller  
public class MyController {
    
    @Autowired
    private ABasicService aBasicService;

	@Autowired
	ABasicDAO aBasicDAO;
	@Autowired
	HResidentCheckDAO hResidentCheckDAO;
	
	
	@RequestMapping("/portal")
	public String portal() {  
		return "portal";  
	}
	@RequestMapping("/portal_personal")
	public String portal_personal(
			@RequestParam(value="name", required=false, defaultValue="") String name,
			@RequestParam(value="code1", required=false, defaultValue="") String code1,
			@RequestParam(value="code2", required=false, defaultValue="") String code2,
			Model model) {
		if (!("".equals(name) || "".equals(code1) || "".equals(code2))){
			ABasic doc = new ABasic();
			doc.setName(name);
			doc.setCode1(code1);
			doc.setCode2(code2);
			model.addAttribute("doc", doc);
			return "portal_personal";  
		} else {
			return "portal";
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value="name", required=false, defaultValue="") String name, Model model) {
		ABasic named = new ABasic();
		named.setName(name);
		model.addAttribute("named", named);
		if ("".equals(name)){
			return "search";
		}
		ArrayList<ABasic> aBasics = (ArrayList<ABasic>) aBasicService.findAByName(name);
		model.addAttribute("aBasics", aBasics);
		return "search";  
	}
	
	@RequestMapping(value = "/a_basic", method = RequestMethod.GET)
	public String a_basic(
			@RequestParam(value="name", required=false, defaultValue="") String name,
			@RequestParam(value="code1", required=false, defaultValue="") String code1,
			@RequestParam(value="code2", required=false, defaultValue="") String code2,
			Model model) {
		ABasic doc = null;
		if (!("".equals(name) || "".equals(code1) || "".equals(code2))){
			doc = aBasicDAO.findOneByNameAndCode1AndCode2(name, code1, code2);
		}
		if (doc == null){
			doc = new ABasic();
		}
		model.addAttribute("doc", doc);
		return "a_basic";
	}
	
	@RequestMapping(value = "/a_basic", method = RequestMethod.POST)
	public String a_basic_post(@ModelAttribute(value="doc") ABasic doc, Model model) {
		try {
			aBasicService.saveA(doc);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Add error page
			return "Duplicated code: CNSR3-" + doc.getCode1() + "-" + doc.getCode2();
		}
//		model.addAttribute("aBasic", doc);
		return "success";  
	}


	@RequestMapping(value = "/h_resident_check", method = RequestMethod.GET)
	public String h_resident_check(
			@RequestParam(value="name", required=false, defaultValue="") String name,
			@RequestParam(value="code1", required=false, defaultValue="") String code1,
			@RequestParam(value="code2", required=false, defaultValue="") String code2,
			Model model) {
		HResidentCheck doc = null;
		if (!("".equals(name) || "".equals(code1) || "".equals(code2))){
			doc = hResidentCheckDAO.findOneByNameAndCode1AndCode2(name, code1, code2);
		}
		if (doc == null){
			doc = new HResidentCheck();
			doc.setName(name);
			doc.setCode1(code1);
			doc.setCode2(code2);
		}
		model.addAttribute("doc", doc);
		return "h_resident_check";
	}
	@RequestMapping(value = "/h_resident_check", method = RequestMethod.POST)
	public String h_resident_check_post(@ModelAttribute(value="doc") HResidentCheck doc, Model model) {
		try {
			aBasicService.saveH(doc);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Add error page
			return "Duplicated code: CNSR3-" + doc.getCode1() + "-" + doc.getCode2();
		}
//		model.addAttribute("aBasic", doc);
		return "success";  
	}

	@RequestMapping("/t")
	public String t(@RequestParam(value="name", required=false, defaultValue="jun") String name,  Model model) {  
		//ArrayList<Person> persons = new ArrayList<Person>();
		//
		//		Person person=new Person();
		//		person.setName("test");
		//		persons.add(person);
		//		persons.add(person);
		//		persons.add(person);
		//		persons.add(person);
		//		model.addAttribute("persons",persons);
		return "t";  
	}  

	//    @RequestMapping("/")
	//    public String index() {
	//        return "Greetings from Spring Boot!";
	//    }
}
