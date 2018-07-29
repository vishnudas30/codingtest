package com.doctor.anywhere.patient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.anywhere.patient.model.Patient;
import com.doctor.anywhere.patient.repository.PatientRepository;

@Service
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientRepository patientRepo;
	
	public Object getPatients() {
		return patientRepo.getAllPatients();	
	}
	public Object addPatient(Patient body) {
		patientRepo.addPatient(body);
		return body; 
	}
	public Object updatePatient(Patient body) {
		patientRepo.updatePatient(body);
		return body; 
	}
	public Object deletePatient(int patientId) {
		patientRepo.hardDeletePatient(patientId);
		return patientId; 
	}
	public Object getPatient(int patientId) {
		return patientRepo.getPatient(patientId);
	}

}
