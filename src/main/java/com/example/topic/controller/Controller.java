package com.example.topic.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.example.topic.pojo.Books;
import com.example.topic.pojo.Topic;
import com.example.topic.service.TopicsService;

@RestController
//@RequestMapping("/foo")
public class Controller {

	@Autowired
	private RestTemplate restTemplate;
	
	
	//get
	@GetMapping("/mywer")
	public List<Books> getBooks() {
		String url ="http://localhost:9000/book";
		 return restTemplate.getForObject(url, List.class);
	
	}
}
	/*@PostMapping("/mywer")
	public ResponseEntity<Book> postBooks(@RequestBody Book books) {
		String url ="http://localhost:9000/books";
		
		return restTemplate.postForEntity(url, List.class, nul);
	}
}
	
	//post
	@RequestMapping(method=RequestMethod.POST , value = "/topics")
		public Topic addTopic(@RequestBody Topic topic) {
		  return topicsService.addTopic(topic);	
		}
	
	
	//update
	@RequestMapping(method=RequestMethod.PUT , value = "/topics/{id}")
	    public Topic updateTopic(@RequestBody Topic topic , @PathVariable("id") String id) {
		  return topicsService.updateTopic(topic , id);
	}
	
	//delete
	@RequestMapping(method=RequestMethod.DELETE , value = "/topics/{id}")
    public List<Topic> deleteTopic(@PathVariable("id") String id) {
	   return topicsService.deleteTopic(id);
    }
}*/
