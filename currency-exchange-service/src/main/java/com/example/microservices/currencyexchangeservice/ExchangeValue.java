package com.example.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ExchangeValue {
	
	@Id
	private Long id;
	
	@Column(name="currency_from")
	private String from;
	
	@Column(name="currency_to")
	private String to;
	private BigDecimal convirsionMultiple;
	
	private int port;
	
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public ExchangeValue() {
		super();
	}
	
	public ExchangeValue(long id, String from, String to, BigDecimal convirsionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convirsionMultiple = convirsionMultiple;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getForm() {
		return from;
	}

	public void setForm(String form) {
		this.from = form;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConvirsionMultiple() {
		return convirsionMultiple;
	}

	public void setConvirsionMultiple(BigDecimal convirsionMultiple) {
		this.convirsionMultiple = convirsionMultiple;
	}
	
	
	
	

}
