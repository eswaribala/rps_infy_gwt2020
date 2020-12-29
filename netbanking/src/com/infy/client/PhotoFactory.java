package com.infy.client;

import java.util.List;

import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;
import com.infy.client.models.Photo;


interface PhotoFactory extends AutoBeanFactory {
	
	 AutoBean<Photo> photoView();
	}