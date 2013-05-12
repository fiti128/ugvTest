package rw.ugv;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Test;

import rw.ugv.dbservice.OperationService;
import rw.ugv.dto.UgvDocument;
import rw.ugv.dto.UgvOperation;

public class OperationTest {

	@Test
	public void test() throws NamingException {
		final Properties p = new Properties();
       
		final Context context = EJBContainer.createEJBContainer(p).getContext();
		OperationService service = (OperationService) context.lookup("operationService");
		UgvDocument document = new UgvDocument();
		document.setDocumentDate("10-05");
		document.setDocumentNumber("6");
		String form = "VP-85";
		document.setForm("VP-89");
		
		UgvOperation uo = new UgvOperation();
		Calendar cal = Calendar.getInstance();
		cal.set(2012, Calendar.APRIL, 15);
		uo.setOpenDateInAB(cal);
		Calendar closeCal = Calendar.getInstance();
		closeCal.set(2013, Calendar.APRIL, 18);
		uo.setClosingDateInAB(closeCal);
		uo.setPriznakZapisi('Z');
		uo.setUgvDocId(document);
		
		service.addOperation(uo);
		
	}

}
