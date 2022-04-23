package com.golden.assignment.Personalitytest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.Cookie;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class PersonalitytestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalitytestApplication.class, args);
	}

	@GetMapping
	public String first(){


		String question = "Do you usually wake up happy?";
		String form =  "<form action='/q2' method='POST'>\n" +
				"        <input type='radio' name='q' id='yes' value='1'>\n" +
				"        <label for='yes'>Yes</label>\n" +
				"        <input type='radio' name='q' id='no' value='0'>\n" +
				"        <label for='no'>No</label>\n" +
				"        <input type='submit' value='Submit'>\n" +
				"    </form>";
		return question + "\n" + form;
	}


	@PostMapping("/q2")
	public String secondQuestion(@RequestParam("q") String q){
		String question = "Do you stay alone";
		if(q.equals("0"))
			question = "Do you often eat breakfast?";

		String form =  "<form action='../q3' method='POST'>\n" +
				"        <input type='radio' name='q' id='yes' value='" + q +"1'>\n" +
				"        <label for='yes'>Yes</label>\n" +
				"        <input type='radio' name='q' id='no' value='" + q +"0'>\n" +
				"        <label for='no'>No</label>\n" +
				"        <input type='submit' value='Submit'>\n" +
				"    </form>";
		return question + "\n" + form;
	}

	@PostMapping("/q3")
	public String thirdQuestion(@RequestParam("q") String q){
		String question;
		if(q.equals("11")){
			question = "Do you have a pet?";
		} else if (q.equals("10")) {
			question = "Do you go out often?";
		} else if (q.equals("01")) {
			question = "Do you have a job?";
		} else{
			question = "Do you wake up early";
		}
		String form =  "<form action='../result' method='POST'>\n" +
				"        <input type='radio' name='q' id='yes' value='" + q +"1'>\n" +
				"        <label for='yes'>Yes</label>\n" +
				"        <input type='radio' name='q' id='no' value='" + q +"0'>\n" +
				"        <label for='no'>No</label>\n" +
				"        <input type='submit' value='Submit'>\n" +
				"    </form>";
		return question + "\n" + form;
	}

	@PostMapping("/result")
	public String result(@RequestParam("q") String q){
		String result;

		if(q.equals("111")){
			result = "You are a beautiful caring being!";
		} else if (q.equals("110")) {
			result = "You are a free satisfied spirit!";
		} else if (q.equals("101")) {
			result = "You are a delight";
		} else if (q.equals("100")) {
			result = "You are a family person";
		} else if (q.equals("011")) {
			result = "You have not found your purpose";
		} else if (q.equals("010")){
			result = "You have a void inside that you seek to fill";
		} else if (q.equals("001")){
			result = "You work too hard, you don't get enough rest";
		}else{
			result = "You probably have a malnutrition problem and you are lazy";
		}
		return result;
	}


}
