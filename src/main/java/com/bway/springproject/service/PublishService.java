
package com.bway.springproject.service;


import java.util.List;

import com.bway.springproject.model.Publish;


public interface PublishService  {

	void addPubl(Publish publ);
	
	void deletePubl(int id);
	
	void updatePubl(Publish publ);
	
	void ApplyPubl(Publish publ);
	
	Publish getPublById(int id);
	
	List<Publish> getAllPubls();
	
}
