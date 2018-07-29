package com.doctor.anywhere.patient.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.doctor.anywhere.patient.model.Patient;

@Service
public interface PatientRepository {

	List<Patient> getAllPatients();

	void addPatient(Patient body);

	void updatePatient(Patient body);

	void hardDeletePatient(int patientId);
	void softDeletePatient(String patientId);

	Object getPatient(int patientId);


}
