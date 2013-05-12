package rw.ugv.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class UgvTechnicalDetails implements Serializable {

	private static final long serialVersionUID = 2539410460467753351L;
	
	// Дата и время записи технической характеристики (первичный ключ)
	@Id
	@Temporal( value = TemporalType.TIMESTAMP ) 
	@Column(name = "TEX_ID", nullable = false, updatable = false) 
    private Date creatingTime;
	
	//  Номер вагона
	@Column(name = "NV")
	private String wagonNumber;
	
	//  Код железнодорожной администрации
	@Column(name = "ZD_ADM")
	private String kodDorozhAdministr;
		
	//	Код организации-собственницы
	@Column(name = "KOD_SOBSTV")
	private String kodSobstv;
	
	//	Дорога приписки вагона
	@Column(name = "DORPRIP")
	private String dorogaPripiski;
		
	//	Станция приписки вагона
	@Column(name = "STPRIP")
	private String stanciaPripiski;
	
	//	Полигон обращения вагона
	//	Код завода постройки
	//	Заводской номер постройки
	//	Тип вагона расчетный
	//	Тип вагона из документа

	public Date getCreatingTime() {
		return creatingTime;
	}

	public void setCreatingTime(Date creatingTime) {
		this.creatingTime = creatingTime;
	}

	public String getWagonNumber() {
		return wagonNumber;
	}

	public void setWagonNumber(String wagonNumber) {
		this.wagonNumber = wagonNumber;
	}

	public String getKodDorozhAdministr() {
		return kodDorozhAdministr;
	}

	public void setKodDorozhAdministr(String kodDorozhAdministr) {
		this.kodDorozhAdministr = kodDorozhAdministr;
	}

	public String getKodSobstv() {
		return kodSobstv;
	}

	public void setKodSobstv(String kodSobstv) {
		this.kodSobstv = kodSobstv;
	}

	public String getDorogaPripiski() {
		return dorogaPripiski;
	}

	public void setDorogaPripiski(String dorogaPripiski) {
		this.dorogaPripiski = dorogaPripiski;
	}

	public String getStanciaPripiski() {
		return stanciaPripiski;
	}

	public void setStanciaPripiski(String stanciaPripiski) {
		this.stanciaPripiski = stanciaPripiski;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
}
