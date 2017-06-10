package org.huashan.crf;


import java.security.Principal;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.huashan.crf.dao.ABasicDAO;
import org.huashan.crf.dao.BDemographicDAO;
import org.huashan.crf.dao.HResidentCheckDAO;
import org.huashan.crf.entity.ABasic;
import org.huashan.crf.entity.BDemographic;
import org.huashan.crf.entity.Cid;
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
    private BDemographicDAO bDemographicDAO;
	@Autowired
	HResidentCheckDAO hResidentCheckDAO;
	
//	@RequestMapping("/")
//    String index(Principal principal) {
//        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
//    }
//	@Controller
//    public class SomeController {
//        @RequestMapping("/")
//        public String redirect() {
//            return "redirect:/query?q=Thymeleaf+Is+Great!";
//        }
//    }
	
	@RequestMapping("/portal")
	public String portal(HttpSession session) {
		session.removeAttribute("name");
		session.removeAttribute("code1");
		session.removeAttribute("code2");
		return "portal";  
	}
	@RequestMapping("/todo")
	public String todo() {  
		return "todo";  
	}
	@RequestMapping("/portal_personal")
	public String portal_personal(
			@RequestParam(value="name", required=false, defaultValue="") String name,
			@RequestParam(value="code1", required=false, defaultValue="") String code1,
			@RequestParam(value="code2", required=false, defaultValue="") String code2,
			Model model, HttpSession session) {
		Cid cid = getCid(session);
		if (cid == null) {
			if (!"".equals(name) && !"".equals(code1) && !"".equals(code2)) {
				cid = new Cid(name, code1, code2);
				setCid(session, cid);
			}
		}
		if (cid != null){
			return "portal_personal";  
		} else {
			return "portal";
		}
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value="name", required=false, defaultValue="") String name, Model model) {
		Cid named = new Cid(name, "", "");
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
//			@RequestParam(value="name", required=false, defaultValue="") String name,
//			@RequestParam(value="code1", required=false, defaultValue="") String code1,
//			@RequestParam(value="code2", required=false, defaultValue="") String code2,
			Model model, HttpSession session) {
		ABasic doc = null;
		Cid cid = getCid(session);
		if (cid != null){
//			setCid(session, new Cid(name, code1, code2));
			doc = aBasicDAO.findOneByNameAndCode1AndCode2(cid.getName(), cid.getCode1(), cid.getCode2());
		}
		if (doc == null){
			doc = new ABasic();
		}
		model.addAttribute("doc", doc);
//		ArrayList<String> optionList = new ArrayList<String>();
//		optionList.add("aaa");
//		optionList.add("bbb");
//		model.addAttribute("optionList", optionList);
		
		Utility utility = new Utility();
		model.addAttribute(utility);
		
		return "a_basic";
	}
	
	@RequestMapping(value = "/a_basic", method = RequestMethod.POST)
	public String a_basic_post(@ModelAttribute(value="doc") ABasic doc, Model model, HttpSession session) {
		try {
			aBasicService.saveA(doc);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Add error page
			return "Duplicated code: CNSR3-" + doc.getCode1() + "-" + doc.getCode2();
		}
		setCid(session, new Cid(doc.getName(), doc.getCode1(), doc.getCode2()));
//		session.setAttribute("name", doc.getName());
//		session.setAttribute("code1", doc.getCode1());
//		session.setAttribute("code2", doc.getCode2());
		return "a_basic";  
	}

	public Cid getCid(HttpSession session) {
		try {
			return new Cid(session.getAttribute("name").toString(),
					session.getAttribute("code1").toString(),
					session.getAttribute("code2").toString());
		} catch (Exception e) {
			return null;
		}
	}
	
	public void setCid(HttpSession session, Cid cid) {
		session.setAttribute("name", cid.getName());
		session.setAttribute("code1", cid.getCode1());
		session.setAttribute("code2", cid.getCode2());
	}
	
	@RequestMapping(value = "/b_demographic", method = RequestMethod.GET)
	public String b_demographic(
//			@RequestParam(value="name", required=false, defaultValue="") String name,
//			@RequestParam(value="code1", required=false, defaultValue="") String code1,
//			@RequestParam(value="code2", required=false, defaultValue="") String code2,
			Model model, HttpSession session) {
		BDemographic doc = null;
		Cid cid = getCid(session);
		if (cid != null) {
			doc = bDemographicDAO.findOneByNameAndCode1AndCode2(cid.getName(), cid.getCode1(), cid.getCode2());
		}
		if (doc == null){
			doc = new BDemographic();
			doc.fillCid(cid);
		}
		model.addAttribute("doc", doc);
		
		Utility utility = new Utility();
		model.addAttribute(utility);
		return "b_demographic";
	}

	@RequestMapping(value = "/b_demographic", method = RequestMethod.POST)
	public String b_demographic_post(@ModelAttribute(value="doc") BDemographic doc, Model model, HttpSession session) {
		try {
			doc.fillCid(getCid(session));
			aBasicService.saveB(doc);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Add error page
			return "Duplicated code: CNSR3-" + doc.getCode1() + "-" + doc.getCode2();
		}
//		model.addAttribute("aBasic", doc);
		return "b_demographic";  
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
				Person person=new Person();
				person.setName("test");
		//		persons.add(person);
		//		persons.add(person);
		//		persons.add(person);
		//		persons.add(person);
				model.addAttribute("person",person);
		return "t";  
	}  

	//    @RequestMapping("/")
	//    public String index() {
	//        return "Greetings from Spring Boot!";
	//    }
}
