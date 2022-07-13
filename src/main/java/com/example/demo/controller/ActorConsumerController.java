package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Actor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/mvc")
public class ActorConsumerController {
	@Autowired
	private Environment env;
	@Autowired
	private RestTemplate template;

	@GetMapping("/home")
	public String showhome() {
		return "home";
	}

	@GetMapping("/actor_report")
	public String fetchAllActors(Map<String, Object> map) throws Throwable {
		String serviceurl = env.getProperty("fetchAllActors.serviceurl1");
		ResponseEntity<String> response = template.exchange(serviceurl, HttpMethod.GET, null, String.class);
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Actor> list = mapper.readValue(jsonBody, new TypeReference<List<Actor>>() {
		});
		map.put("actorsInfo", list);
		return "show_report";
	}

	@GetMapping("/actor_add")
	public String showRegisterActorFormPage(@ModelAttribute("actor") Actor actor) {
		return "register_actor";
	}

	@PostMapping("/actor_add")
	public String registerActor(@ModelAttribute("actor") Actor actor, RedirectAttributes attrs) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		String jsonContent = mapper.writeValueAsString(actor);
		System.out.println("registerActor" + jsonContent);
		String serviceUrl = env.getProperty("register.serviceurl");
		HttpHeaders head = new HttpHeaders();
		head.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<>(jsonContent, head);
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		String msg = response.getBody();
		attrs.addFlashAttribute("resultmsg", msg);
		return "redirect:actor_report";
	}
}
