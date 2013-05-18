package rw.ugv;

import java.util.Calendar;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvOperation;
import rw.ugv.dto.UgvTechnicalDetails;



public class MainEntityManager {


	public static void main(String[] args) {
		UgvDocument document = new UgvDocument();

		document.setDocumentNumber("6");
		String form = "VP-85";

		UgvTechnicalDetails td = new UgvTechnicalDetails();
		
		UgvOperation uo = new UgvOperation();
		Calendar cal = Calendar.getInstance();
		cal.set(2012, Calendar.APRIL, 15);
		uo.setOpenDateInAB(cal);
		Calendar closeCal = Calendar.getInstance();
		closeCal.set(2013, Calendar.APRIL, 18);
		uo.setClosingDateInAB(closeCal);
		uo.setPriznakZapisi('Z');
		uo.setUgvDocId(document);
		uo.setUgvTechId(td);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(uo);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		

	}

}
