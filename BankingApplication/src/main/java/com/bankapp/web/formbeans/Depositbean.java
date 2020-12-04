package com.bankapp.web.formbeans;

import javax.validation.constraints.NotNull;

public class Depositbean {
	
	@NotNull(message = "accountId can not be left blank")
	private Integer accountId;
	
	@NotNull(message = "amount can not be left blank")
	private Double amount;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Depositbean() {
	}
	
	
	
}
