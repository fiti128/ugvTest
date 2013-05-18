//package rw.ugv;
//
//import java.util.Calendar;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.criteria.CriteriaBuilder;
//
//
//
//import org.hibernate.Query;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.ejb.Ejb3Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
//import rw.ugv.dto.UgvDocument;
//import rw.ugv.dto.UgvOperation;
//import rw.ugv.dto.UgvTechnicalDetails;
//
//public class Main {
//
//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		UgvDocument document = new UgvDocument();
//		document.setDocumentDate("10-05");
//		document.setDocumentNumber("6");
//		String form = "VP-85";
//
//		
//		UgvOperation uo = new UgvOperation();
//		Calendar cal = Calendar.getInstance();
//		cal.set(2012, Calendar.APRIL, 15);
//		uo.setOpenDateInAB(cal);
//		Calendar closeCal = Calendar.getInstance();
//		closeCal.set(2013, Calendar.APRIL, 18);
//		uo.setClosingDateInAB(closeCal);
//		uo.setPriznakZapisi('C');
//		uo.setUgvDocId(document);
//		
//		Configuration conf = new Configuration().configure();
//		conf.addAnnotatedClass(UgvOperation.class);
//		conf.addAnnotatedClass(UgvTechnicalDetails.class);
//		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
//		SessionFactory sf = conf.buildSessionFactory(sr);
//	
//		Session session = sf.openSession();
//		Transaction trans = session.beginTransaction();
//		
////		session.save(uo);
//		Query query = session.createQuery("from UgvOperation uo where uo.ugvDocId != null");
//		
////		List<UgvOperation> list = (List<UgvOperation>)query.list();
////		System.out.println(list.get(0).getPriznakZapisi());
//		trans.commit();
//		
//		session.close();
//		
//
//
//	}
//
//}
