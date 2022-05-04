package com.example.topic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.topic.pojo.Topic;
import com.example.topic.service.TopicsService;

@SpringBootTest
class TopicApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	TopicsService topServ;
	
	//create
	@Test
	public void testCreate () {
	Topic t = new Topic("reactjs", "reactjs library", "reacjs is powerfull front-end library");
	Topic t1 = new Topic("reactjs-1", "reactjs library-1", "reacjs is powerfull front-end library-1");
	
//	Topic excepted = topServ.getTopic("reactjs");
//	assertEquals(excepted, t);
	assertNotNull(t, "creating the topic");
	}
	
	//read all
	@Test
	public void testReadAll () {
    List<Topic> list = topServ.getAllTopicList();
	assertNotNull(list, "reading all the topic list");
//	forEach(Topic x : list){
//	System.out.println(x));
//	}
	System.out.println(list.get(0));
	}
	
	//read one
	@Test
	public void testRead () {
	Topic actual = topServ.getTopic("java");
	assertEquals("Java FrameWork", actual.getName());
	}
		
	//update
	@Test
	public void testUpdate () {
    Topic actual = topServ.getTopic("java");
	actual.setId("react");
	actual.setDescription("react-js is front-end library");
	actual.setName("react-js library");
	
    topServ.updateTopic(actual, "reactjs");
    System.out.println(actual.getId());
	assertNotNull(actual);
	}
	
	//delete
	@Test
	public void testDelete() {	
	List<Topic> expected = topServ.deleteTopic("java");
	
	assertNotNull(expected);
	}

}