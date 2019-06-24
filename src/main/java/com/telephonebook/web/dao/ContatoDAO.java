package com.telephonebook.web.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.telephonebook.web.models.Contato;

@Repository
@Transactional
public class ContatoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	
	
	public void write(Contato contato){
		manager.persist(contato);
	}


	public List<Contato> list(String name, String phone, String email) {
		
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Contato> query = criteriaBuilder
				.createQuery(Contato.class);
		Root<Contato> root = query.from(Contato.class);

		Path<String> namePath = root.<String>get("name");
		Path<String> phonePath = root.<String>get("phone");
		Path<String> emailPath = root.<String>get("email");

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (name != null) {
			Predicate equalName = criteriaBuilder.like(namePath, "%" + name + "%");
			predicates.add(equalName);
		}

		if (phone != null) {
			Predicate equalPhone = criteriaBuilder.like(phonePath, "%" + phone + "%");
			predicates.add(equalPhone);
		}

		if (email != null) {
			Predicate equalEmail = criteriaBuilder.like(emailPath, "%" + email + "%");
			predicates.add(equalEmail);
		}

		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Contato> typedQuery = manager.createQuery(query);
		typedQuery.setHint("org.hibernate.cacheable", "true");

		return typedQuery.getResultList();
	}
	
	
	public void delete(String name){
		Contato ctt = searchByName(name);
		
		manager.remove(manager.find(Contato.class, ctt.getId()));
		
	}
	
	public Contato searchByName(String name){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Contato> query = criteriaBuilder.createQuery(Contato.class);
		Root<Contato> root = query.from(Contato.class);
		
		Path<String> nomePath = root.<String>get("name");
		
		TypedQuery<Contato> typedQuery = manager.createQuery(query.where(criteriaBuilder.like(nomePath,name)));
		System.out.println(typedQuery.getResultList());
		return typedQuery.getSingleResult();
		
	}
	
	public void update(Contato contato){
		Contato ctt = manager.find(Contato.class, contato.getId());
		ctt.setName(contato.getName());
		ctt.setPhone(contato.getPhone());
		ctt.setEmail(contato.getEmail());
		
		manager.persist(ctt);
	}
	
}
