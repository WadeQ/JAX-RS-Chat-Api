package org.wadektech.southpawnerd.messenger.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.wadektech.southpawnerd.model.Profile;
import org.wadektech.southpawnerd.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileApi {
	
	ProfileService mProfile = new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile>  getProfiles(){
	
		return mProfile.getAllProfiles();
			
		}
	
	@POST
	public Profile postProfile(Profile profile) {
		return mProfile.addProfile(profile);
	}
	//since we are using the put and we only want to edit an existing message,
	//we will ensure that the id is set to the original messageId and not changed
	@PUT
	@Path("/{profileName}")
	public Profile putProfile(@PathParam("profileName") String profileName, Profile profile) {
		//set id to the same long id
		profile.setProfileName(profileName);
		return mProfile.updateprofile(profile);
	}
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
		mProfile.removeProfile(profileName);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getSingleProfile(@PathParam("profileName") String id) {
		return mProfile.getProfiles(id);
	}
}
