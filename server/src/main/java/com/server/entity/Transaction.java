package com.server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	@Column(name = "transaction_id")
	private String TrxId;

	@Column(name = "bank_name")
	private String BankId;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "from_account")
	private Long fromAccount;
	
	@Column(name = "to_account")
	private Long toAccount;
	
	private Double amount;
	private String currency;
	private String timeStamp;
	
	
	
	public Transaction() {
		
	}

	public Transaction(String trxId, String bankId, Long customerId, Long fromAccount, Long toAccount, Double amount,
			String currency, String timeStamp) {
		super();
		TrxId = trxId;
		BankId = bankId;
		this.customerId = customerId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
		this.currency = currency;
		this.timeStamp = timeStamp;
	}
	
	public String getTrxId() {
		return TrxId;
	}
	public void setTrxId(String trxId) {
		TrxId = trxId;
	}
	public String getBankId() {
		return BankId;
	}
	public void setBankId(String bankId) {
		BankId = bankId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Long getToAccount() {
		return toAccount;
	}
	public void setToAccount(Long toAccount) {
		this.toAccount = toAccount;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
