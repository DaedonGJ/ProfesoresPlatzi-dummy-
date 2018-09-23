package com.platzi.daos;

import java.util.List;

import com.platzi.modelo.SocialMedia;
import com.platzi.modelo.TeacherSocialMedia;

public class SocialMediaImpl extends AbstractSession implements SocialMediaDao {

	@Override
	public void saveSocialMedia(SocialMedia SocialMedia) {
		getSession().persist(SocialMedia);

	}

	@Override
	public void deleteSocialMediaById(Long idSocialMedia) {
		SocialMedia socialmedia = findById(idSocialMedia);
		if (socialmedia != null)
			getSession().delete(socialmedia);

	}

	@Override
	public void updateSocialMedia(SocialMedia SocialMedia) {
		updateSocialMedia(SocialMedia);

	}

	@Override
	public List<SocialMedia> findAllSocialMedias() {
		return getSession().createQuery("from SocialMedia").list();
	}

	@Override
	public SocialMedia findById(Long idSocialMedia) {

		return getSession().get(SocialMedia.class, idSocialMedia);
	}

	@Override
	public SocialMedia findByName(String name) {

		return (SocialMedia) getSession().createQuery("from SocialMedia  where name= :name ").setParameter("name", name)
				.uniqueResult();
	}

	@Override
	public TeacherSocialMedia findSocialMediaByIdAndname(Long idSocialMedia, String nickname) {

		List<Object[]> objects = getSession()
				.createQuery("from TeacherSocialMedia tsm " + "join tsm.socialMedia sm "
						+ "where sm.idSocialMedia = :idSocialmedia and tsm.nickname = :nickname")
				.setParameter("idSocialmedia", idSocialMedia).setParameter("nickname", nickname).list();
		if (objects.size() > 0) {

			for (Object[] objects2 : objects) {
				for (Object object : objects2) {
					if(object instanceof TeacherSocialMedia) {
						return (TeacherSocialMedia) object;
					}
			
				}
			}
		} 
		return null;
	}

}
