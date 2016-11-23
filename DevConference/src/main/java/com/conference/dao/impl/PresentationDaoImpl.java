package com.conference.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.conference.dao.PresentationDao;
import com.conference.entity.Presentation;

@Repository
public class PresentationDaoImpl implements PresentationDao {

	private EntityManager entityManager;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Transactional
	public Presentation createPresentation(Presentation presentation) {
		entityManager.persist(presentation);
		entityManager.flush();
		return presentation;
	}

	@Transactional
	public Presentation updatePresentation(Presentation presentation) {
		entityManager.merge(presentation);
		entityManager.flush();
		return presentation;
	}
	
	@Transactional
	public Presentation getPresentationById(long id) {
		TypedQuery<Presentation> query = entityManager.createQuery("SELECT e FROM Presentation e WHERE e.id = ?1", Presentation.class);
		query.setParameter(1, id);
		
		Presentation presentation = query.getSingleResult();
		
		return presentation;
	}
	
	@Transactional
	public List<Presentation> listPresentations() {
		TypedQuery<Presentation> query = entityManager.createQuery("SELECT e FROM Presentation e left join fetch e.room", Presentation.class);
		
		List<Presentation> presentations = query.getResultList();
		
		return presentations;
	}

}
