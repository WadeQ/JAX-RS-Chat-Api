package org.wadektech.southpawnerd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.wadektech.southpawnerd.database.MessageDB;
import org.wadektech.southpawnerd.model.Profile;

public class ProfileService {
	
	private Map<String,Profile> profiles = MessageDB.getProfiles();
	
	public ProfileService() {
		profiles.put("WadeQ", new Profile(1l,"WadeQ", "Derrick", "Wadek"));
		profiles.put("NinjaCoder", new Profile(2l,"NinjaCoder", "Derrick", "Wadek"));
	}

	public List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfiles(String profileName) {
		return profiles.get(profileName);
	}
    
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile ;
	}
	
	public Profile updateprofile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}else {
			profiles.put(profile.getProfileName(), profile);
			return profile ;
		}
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.get(profileName);
	}
}
