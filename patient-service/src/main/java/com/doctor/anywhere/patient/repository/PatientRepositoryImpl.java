package com.doctor.anywhere.patient.repository;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.doctor.anywhere.patient.model.Address;
import com.doctor.anywhere.patient.model.Patient;

@Repository

public class PatientRepositoryImpl implements PatientRepository {
	/*
	 * @PersistenceContext private EntityManager entityManager;
	 */
	@Autowired
	private EntityManagerFactory emf;

	public List<Patient> getAllPatients() {
		System.out.println("Get ALL  patients");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		org.hibernate.Session session = (Session) em.getDelegate();
		
		//Criteria criteria = em.unwrap(Session.class).createCriteria(Address.class);
		//List<Patient> patientList = criteria.list();
		List<Patient> patientList = session.createQuery("from Patient").list();
		tx.commit();
		em.close();

		return patientList;

	}

	@Transactional
	public void addPatient(Patient body) {
		System.out.println("Adding new Patient");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(body);
		Address a  = body.getAddrs().iterator().next();
		a.setPatient(body);
		em.persist(a);
		tx.commit();
		em.close();
	}
	@Transactional
	public void updatePatient(Patient body) {
		System.out.println("Update  patient"+body.getFirstName()+body.getLastName()+body.getPatientId());
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.unwrap(Session.class).update(body);
		tx.commit();
		em.close();

	}
	@Transactional
	public void hardDeletePatient(int patientId) {
		System.out.println("hard delete patient");
		EntityManager em = emf.createEntityManager();
		Patient p = em.find(Patient.class, patientId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(p);
		tx.commit();
		em.close();
	}
	@Transactional
	public void softDeletePatient(String patientId) {
		System.out.println("soft delete patient");
		EntityManager em = emf.createEntityManager();
		Patient p = em.find(Patient.class, patientId);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		p.setStatus("inactive");
		em.remove(p);
		tx.commit();
		em.close();
	}

	public Object getPatient(int patientId) {
		
		System.out.println("soft delete patient");
		EntityManager em = emf.createEntityManager();
		Patient p = em.find(Patient.class, patientId);
		return p;
	}

}
