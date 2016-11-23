package com.conference.dao;

import java.util.List;

import com.conference.entity.Presentation;

public interface PresentationDao {
	
	/*
	 * Create/Update presentation
	 */
	public Presentation createPresentation(Presentation presentation);
	public Presentation updatePresentation(Presentation presentation);
	
	/*
	 * Get presentation
	 */
	public Presentation getPresentationById(long id);
	
	/*
	 * List presentations
	 */
	public List<Presentation> listPresentations();
}
