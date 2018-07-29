package com.doctor.anywhere.patient.service;

import org.springframework.stereotype.Service;

import com.doctor.anywhere.patient.model.Patient;

@Service
public interface PatientService {

	Object getPatients();

	Object addPatient(Patient body);

	Object updatePatient(Patient body);

	Object deletePatient(int patientId);

	Object getPatient(int patientId);

}
