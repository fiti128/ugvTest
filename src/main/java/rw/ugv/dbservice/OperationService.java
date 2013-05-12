package rw.ugv.dbservice;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rw.ugv.dto.UgvOperation;

@Named
public class OperationService {
	
	@PersistenceContext(unitName = "sample")
    private EntityManager entityManager;
	
	
	public void addOperation(UgvOperation operation) {
		entityManager.persist(operation);
	}
}
