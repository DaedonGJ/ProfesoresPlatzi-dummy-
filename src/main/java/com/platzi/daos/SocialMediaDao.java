package com.platzi.daos;

import java.util.List;

import com.platzi.modelo.SocialMedia;
import com.platzi.modelo.TeacherSocialMedia;

public interface SocialMediaDao {

	void saveSocialMedia(SocialMedia SocialMedia);

	void deleteSocialMediaById(Long idSocialMedia);

	void updateSocialMedia(SocialMedia SocialMedia);

	List<SocialMedia> findAllSocialMedias();

	SocialMedia findById(Long idSocialMedia);
	
	SocialMedia findByName(String name);
	
	TeacherSocialMedia findSocialMediaByIdAndname(Long idSocialMedia,String nickname);
	
}
