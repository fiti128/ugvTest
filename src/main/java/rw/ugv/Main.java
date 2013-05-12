package rw.ugv;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvOperation;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UgvDocument document = new UgvDocument();
		document.setDocumentDate("10-05");
		document.setDocumentNumber("5");
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
//		uo.setUgvDocId(document);
		
		Configuration conf = new Configuration().configure();
		conf.addAnnotatedClass(UgvOperation.class);
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
	
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		Query query = session.createQuery("from UgvDocument as doc where doc.form = 'VP-85'");
		List<UgvDocument> list = query.list();
		System.out.println(list.get(0).getForm());
		UgvDocument document1 = list.get(0);
		uo.setUgvDocId(document1);
		session.save(uo);
		trans.commit();
		
		session.close();
		


	}

}
