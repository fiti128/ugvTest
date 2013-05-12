package rw.ugv;

import java.util.Calendar;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvOperation;
import rw.ugv.dto.UgvTechnicalDetails;

public class MainEntityManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UgvDocument document = new UgvDocument();
		document.setDocumentDate("10-05");
		document.setDocumentNumber("6");
		String form = "VP-85";
		document.setForm("VP-85");
		
		UgvOperation uo = new UgvOperation();
		Calendar cal = Calendar.getInstance();
		cal.set(2012, Calendar.APRIL, 15);
		uo.setOpenDateInAB(cal);
		Calendar closeCal = Calendar.getInstance();
		closeCal.set(2013, Calendar.APRIL, 18);
		uo.setClosingDateInAB(closeCal);
		uo.setPriznakZapisi('Z');
		uo.setUgvDocId(document);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();

		entityManager.persist(uo);
		
		entityManager.getTransaction().commit();
		entityManager.close();
		

	}

}
