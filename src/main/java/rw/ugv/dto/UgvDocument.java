package rw.ugv.dto;


import java.io.Serializable;
import java.util.Date;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;









@Entity
public class UgvDocument implements Serializable {
	

	public UgvDocument() {
		creatingTime = new Date();
	}
	private static final long serialVersionUID = -6682900294284156242L;
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column(name = "DOC_ID", nullable = false, updatable = false) 
    private Date creatingTime;
	
	String form;
	
	@Column(name = "N_DOC")
	String documentNumber;
	
	@Column(name = "D_DOC")
	String documentDate;

	

	public Date getCreatingTime() {
		return creatingTime;
	}
	public void setCreatingTime(Date creatingTime) {
		this.creatingTime = creatingTime;
	}

	public String getForm() {
		return form;
	}
	public void setForm(String form) {
		this.form = form;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getDocumentDate() {
		return documentDate;
	}
	public void setDocumentDate(String documentDate) {
		this.documentDate = documentDate;
	}
	
	
	
}
