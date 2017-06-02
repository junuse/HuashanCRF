package org.huashan.crf;


import org.huashan.crf.entity.ABasic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller  
public class MyController {

	@RequestMapping("/g1")
	public String g1(
			@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {  
		model.addAttribute("name", name);  
		return "g1";  
	}

	@RequestMapping("/portal")
	public String portal() {  
		return "portal";  
	}

	@RequestMapping(value = "/a_basic", method = RequestMethod.GET)
	public String a_basic(Model model) {
		ABasic aBasic = new ABasic();
		aBasic.setIsmale(false);
		aBasic.setName("default");
		aBasic.setCode1("223");
		aBasic.setCode2("22333");
		model.addAttribute("aBasic", aBasic);
		return "a_basic";  
	}
	
	@RequestMapping(value = "/a_basic", method = RequestMethod.POST)
	public String a_basic_post(@ModelAttribute(value="aBasic") ABasic aBasic, Model model) {
		System.out.println(aBasic);
		model.addAttribute("aBasic", aBasic);
		return "a_basic";  
	}



	@RequestMapping("/t")
	public String t(@RequestParam(value="name", required=false, defaultValue="jun") String name,  Model model) {  

		Person person=new Person();
		person.setName("test");
		model.addAttribute("person",person);
		return "t";  
	}  

	//    @RequestMapping("/")
	//    public String index() {
	//        return "Greetings from Spring Boot!";
	//    }
}
