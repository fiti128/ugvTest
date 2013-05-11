package rw.ugv;

import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import rw.ugv.dto.UgvDocument;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		UgvDocument document = new UgvDocument();
//		document.setCreatingTime(new Timestamp(new Date().getTime()));
//		document.setCreatingTime(new Date());
		document.setDocumentDate("10-05");
		document.setDocumentNumber("5");
//		System.out.println(document.getTest().getStr());
		document.setForm("VP-58");
		Configuration conf = new Configuration().configure();
		ServiceRegistry sr = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();
		SessionFactory sf = conf.buildSessionFactory(sr);
	
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(document);
		trans.commit();
		
		session.close();

	}

}
