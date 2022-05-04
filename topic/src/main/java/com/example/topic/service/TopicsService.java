package com.example.topic.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.topic.pojo.Topic;

@Service
public class TopicsService {

    public static List<Topic> topicList = new ArrayList<>(Arrays.asList(

            new Topic("_spring", "_Spring FrameWork", "_Spring Description"),
            new Topic("spring", "Spring FrameWork", "Spring Description"),
            new Topic("java", "Java FrameWork", "Java Description")

    ));

    //get 
    /* 
     * 
     */
	public List<Topic> getAllTopicList() {
		// TODO Auto-generated method stub
		return topicList;
	}
	
	public Topic getTopic(String id) {
		return topicList.stream().filter(topic ->topic.getId().equals(id)).findFirst().get();
	}
   //post
	public Topic addTopic(Topic topic) {
		// TODO Auto-generated method stub
		 topicList.add(topic);
//		 System.out.println(topic.getId());
		 return topic;
//		 return topicList.get(0);
	}

	//put
	public Topic updateTopic(Topic topic, String id) {
		
		topicList.forEach(t -> {
			if(t.getId().equals(id)){
			  t.setId(topic.getId());
			  t.setDescription(topic.getDescription());
			  t.setName(topic.getName());
		    }
		});
//		System.out.println(topic);
		return topic;
		
	}

	//delete
	public List<Topic> deleteTopic(String id) {
		// TODO Auto-generated method stub
		topicList.removeIf(topic -> topic.getId().equals(id));
		
		return topicList;
	}
}
