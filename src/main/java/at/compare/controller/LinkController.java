package at.compare.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import at.compare.model.Auto;
import at.compare.model.User;
import at.compare.repository.AutoRepository;
import at.compare.repository.RouteRepository;
import at.compare.service.AutoService;
import at.compare.service.AutoServiceImpl;
import at.compare.service.UserService;

@Controller
//@Configuration
//@ComponentScan("at.compare")
public class LinkController {
	
	@Autowired
	AutoService autoService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	RouteRepository routeRepository;
	
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	@RequestMapping(value="/drs")
	public ModelAndView test2(HttpServletResponse response) throws IOException{
		return new ModelAndView("WebService");
	}
	
	@RequestMapping(value="/test")
	public @ResponseBody String test(){
		//Auto auto = autoService.findById(1);
		
		return "test";
	}
	@RequestMapping(value="/test2")
	public @ResponseBody String test2(){
		Auto auto = autoService.findById(1);
		
		return auto.toString();
	}
	@RequestMapping(value="/test3")
	public @ResponseBody String test3(){
		User user = userService.findByNameId("tobi11");
		
		return "test" + user.toString();
	}
	@RequestMapping(value="/JsonTest1" ,produces="application/json")
	public @ResponseBody Auto JsonTest1(){
		Auto auto = autoService.findById(1);
		
		return auto;
	}
	//insert value
	
	
	// Bsp: http://localhost:8080/cp414/autoid?id=2 
	@RequestMapping(value="/autoid", method=RequestMethod.GET)
	public @ResponseBody String id(@RequestParam(value="id", required=false, defaultValue="1" )long id){
		
		Auto auto = autoService.findById(id);
		
		return auto.toString();
	}
	
	
	/*
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView shopListPage() {
		ModelAndView mav = new ModelAndView("auto-list");
		List<Auto> autoList = autoService.findAll();
		mav.addObject("autoList", autoList);
		return mav;
	}
	*/
	@RequestMapping("/hello")  
	 public @ResponseBody  
	 String hello(@RequestParam(value = "name") String name,  
	   @RequestParam(value = "gender") String gender,  
	   @RequestParam(value = "email") String email,  
	   @RequestParam(value = "phone") String phone,  
	   @RequestParam(value = "city") String city) {  
	  System.out.println(name);  
	  System.out.println(gender);  
	  System.out.println(email);  
	  System.out.println(phone);  
	  System.out.println(city);  
	  
	  String str = "{\"user\": { \"name\": \"" + name + "\",\"gender\": \""  
	    + gender + "\",\"email\": \"" + email + "\",\"phone\": \""  
	    + phone + "\",\"city\": \"" + city + "\"}}";  
	  return str;  
	  
	 } 
	 @RequestMapping("/welcome")
	 public ModelAndView helloWorld() {
 
		String message = "<br><div align='center'>"
				+ "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is comming from CrunchifyHelloWorld.java **********<br><br>";
		return new ModelAndView("welcome", "message", message);
	 }
	 @RequestMapping(value="/greeting", method = {RequestMethod.GET, RequestMethod.HEAD},     
			    headers = "x-requested-with=XMLHttpRequest")
	 public Auto greeting(
	            @RequestParam(value="name", required=false, defaultValue="World") String name) {
	    	System.out.println("==== in greeting ====");
	    	Auto car = new Auto("model", 134.345, "DIE");
	    			
	        return car;
	 }
	 @RequestMapping("/greeting2")
	 public Auto greeting2(
	            @RequestParam(value="name", required=false, defaultValue="World") String name) {
	    	System.out.println("==== in greeting2 ====");
	        return new Auto("model", 134.345, "DIE");
	 }
	 @RequestMapping("/ajax")
	 public ModelAndView helloAjaxTest() {
	        return new ModelAndView("ajax", "message", "Crunchify Spring MVC with Ajax and JQuery Demo..");
	 }
	 
	 @RequestMapping(value = "/ajaxtest", method = RequestMethod.GET)
	 public @ResponseBody
	 String getTime() {
	 
	        Random rand = new Random();
	        float r = rand.nextFloat() * 100;
	        String result = "<br>Next Random # is <b>" + r + "</b>. Generated on <b>" + new Date().toString() + "</b>";
	        System.out.println("Debug Message from CrunchifySpringAjaxJQuery Controller.." + new Date().toString());
	        return result;
	}
}
