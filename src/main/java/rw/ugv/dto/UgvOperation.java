package rw.ugv.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "VGO")
public class UgvOperation {

	public UgvOperation() {
		creatingTime = new Date();
	}
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column (name = "ZAP_ID", nullable = false, updatable = false)
	private Date creatingTime;
	
}
