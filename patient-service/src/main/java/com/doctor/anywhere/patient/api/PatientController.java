package com.doctor.anywhere.patient.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.doctor.anywhere.patient.model.Patient;
import com.doctor.anywhere.patient.service.PatientService;

/**
 * @author vishnudas
 *
 */
@Controller
public class PatientController {
	private static final Logger log = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService patientService;
	
	@RequestMapping(value = "/getpatients", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getPatients() {
		log.info("Getting all patients");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatients());

	}
	@RequestMapping(value = "/addpatient", method = RequestMethod.POST, produces = { "application/json" })
	public ResponseEntity<?> addPatient(@RequestBody Patient body) {
		log.info("Getting all patients");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.addPatient(body).toString());

	}
	@RequestMapping(value = "/updatepatient", method = RequestMethod.PUT, produces = { "application/json" })
	public ResponseEntity<?> updatePatient(@RequestBody Patient body) {
		log.info("updating  patient");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.updatePatient(body).toString());

	}
	@RequestMapping(value = "/deletepatinet/{patientId}", method = RequestMethod.DELETE, produces = { "application/json" })
	public ResponseEntity<?> deletePatient(@PathVariable("patientId") int patientId) {
		log.info("Getting all patients");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.deletePatient(patientId).toString());

	}
	@RequestMapping(value = "/getpatient/{patientId}", method = RequestMethod.GET, produces = { "application/json" })
	public ResponseEntity<?> getPatient(@PathVariable("patientId") int patientId) {
		log.info("Getting all patients");
		return ResponseEntity.status(HttpStatus.OK).body(patientService.getPatient(patientId));

	}

}
