package com.example.topic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.topic.pojo.Topic;
import com.example.topic.service.TopicsService;

@RestController
public class Controller {

	@Autowired
	private TopicsService topicsService;
	
	//get
	@RequestMapping("/topics")
	public List<Topic> all_topics(){
		return topicsService.getAllTopicList();
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
}
