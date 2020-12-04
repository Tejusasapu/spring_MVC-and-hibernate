package com.bankapp.web.formbeans;

import javax.validation.constraints.NotNull;

public class Transferbean {
	
	@NotNull(message = "fromAccountId can not be left blank")
	private Integer fromAccountId;
	
	@NotNull(message = "toAccountId can not be left blank")
	private Integer toAccountId;
	@NotNull(message = "amount can not be left blank")
	private Double amount;
	public Integer getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(Integer fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public Integer getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(Integer toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Transferbean() {
		
	}
	
	
}
