package com.java.webservices.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.java.webservices.messenger.dao.MessageDao;
import com.java.webservices.messenger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = MessageDao.getProfiles();
	
	public ProfileService(){
		profiles.put("Anita", new Profile(1,"Anita","Anita","Tripuraneni"));
		profiles.put("Sumanth", new Profile(2,"Sumanth","Sumanth","Talasila"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());

	}

	public Profile getProfile(String name) {
		return profiles.get(name);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getId() <= 0) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile removeProfile(String name) {
		return profiles.remove(name);
	}

}
