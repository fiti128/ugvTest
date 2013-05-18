/*
 *  Copyright belongs to Belarusian Railways. 
 *  Copying for commercial purposes is only allowed if the copyright owner's consent is obtained,
 *  or a copyright fee is paid, or it is made under licence.
 *  In order to obtain license call +375-17-2253017
 *  
 */

package rw.ugv.dao.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import rw.ugv.dao.OperationDAO;
import rw.ugv.dto.UgvOperation;


/**
 * Класс для тестирования jpa
 * @author ircm_yanusheusky
 * @since 17.05.2013
 */
public class GenericDaoJpaImplTest  {
	
	private static OperationDAO operationDao;
	private static Context context;
	private static List<UgvOperation> operationList;
	
	@BeforeClass
	public static void randomUgvOperationList() {
		
		// Рандомим угв лист
		operationList = new ArrayList<UgvOperation>();
		UgvOperation ugvOperation;
		for (int i = 1; i < 100; i++) {
			
			char priznakZapisi = (char) (i%10+47);
			Calendar openDate = Calendar.getInstance();
			openDate.setTimeInMillis(i*10000);
			Calendar closeDate = Calendar.getInstance();
			openDate.setTimeInMillis(i*20000);
			
			ugvOperation = new UgvOperation();
			ugvOperation.setPriznakZapisi(priznakZapisi);
			ugvOperation.setOpenDateInAB(openDate);
			ugvOperation.setClosingDateInAB(closeDate);
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			operationList.add(ugvOperation);
		}
		ugvOperation = new UgvOperation();
		ugvOperation.setPriznakZapisi('Y');
		operationList.add(ugvOperation);
	}
	
	@BeforeClass
	public static void beforeClass() throws NamingException {
		// Создаем контейнер и считываем бины в контекст
		final Properties p = new Properties();
      p.put("testDatabase", "new://Resource?type=DataSource");
      p.put("testDatabase.JdbcDriver", "org.hsqldb.jdbcDriver");
      p.put("testDatabase.JdbcUrl", "jdbc:hsqldb:mem:moviedb");

		
		context = EJBContainer.createEJBContainer(p).getContext();
		// Запрашиваем бин operationService
		Object object = context.lookup("java:global/ugvTest/operationDao");
		// Проверяем есть ли вообще такой бин
		Assert.assertNotNull(object);
		// Проверяем является ли наш бин объектом OperationDAO
		Assert.assertTrue(object instanceof OperationDAO);
		// Присваевам бин соответствующей ссылке
		operationDao = (OperationDAO) object;
	
	}
	
	@Test
	public void testUgvOperation() {
		// Проверяем create
		for (UgvOperation operation : operationList) {
			operationDao.create(operation);
		}
		// Проверяем read
		Date date = operationList.get(operationList.size()-1).getId();
		Timestamp tsp = new Timestamp(date.getTime());
		UgvOperation operation = operationDao.read(tsp);
		Assert.assertTrue('Y' == operation.getPriznakZapisi());
		
		// Проверяем pagination
		List<UgvOperation> listFromDb = operationDao.pagination(10, 20, null, false);
		Assert.assertTrue("Не правильно прочитало getPage()",listFromDb.size() == 20);
		
		listFromDb = operationDao.pagination(0, 200, "priznakZapisi", false);
		Assert.assertTrue("Не правильно прочитало getPage() или create()",listFromDb.size() == 100);
		
		for (UgvOperation ugvOperation : listFromDb) {
			System.out.println(ugvOperation.getPriznakZapisi());
		}
		Assert.assertTrue("Первая запись должна быть с признаком У", listFromDb.get(0).getPriznakZapisi() == 'Y');
		
		// Проверяем delete
		for (int i = 0; i < 40; i++ ) {
			operationDao.delete(listFromDb.get(i));
		}
		
		listFromDb = operationDao.pagination(0,200, null, true);
		Assert.assertTrue("Не правильно прочитало getPage() или delete()",listFromDb.size() == 60);
		
		
		// Проверяем update
		for (UgvOperation ugvOperation : listFromDb) {
			ugvOperation.setPriznakZapisi('c');
			operationDao.update(ugvOperation);
		}
		
		for (UgvOperation ugvOperation : listFromDb) {
			Assert.assertTrue('c' == ugvOperation.getPriznakZapisi());
		}
		
		
		
	}
	
	
	@AfterClass
	public static void afterClass() throws NamingException {
		if (context != null) {
			context.close();
		}
	}
}
