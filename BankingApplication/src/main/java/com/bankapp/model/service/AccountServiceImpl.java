package com.bankapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.TransactionType;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	private TransactionLogService transactionLogService;

	@Autowired
	public AccountServiceImpl(AccountDao accountDao, TransactionLogService transactionLogService) {
		this.accountDao = accountDao;
		this.transactionLogService = transactionLogService;
	}

	@Override
	public List<Account> getAllAccounts() {

		return accountDao.getAllAccounts();
	}

	@Override
	public void deposit(int accountId, double amount) {
		Account account = accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance() + amount);
		accountDao.updateAccount(account);
	    transactionLogService.addTransactionLog("deposit amount" ,amount,TransactionType.DEPOSIT);

	}

	@Override
	public void withdraw(int accountId, double amount) {
		Account account = accountDao.getAccountById(accountId);
		account.setBalance(account.getBalance() - amount);
		accountDao.updateAccount(account);
		transactionLogService.addTransactionLog("withdraw amount" ,amount,TransactionType.WITHDRAW);
	}

	@Override
	public void tranfer(int fromAccountId, int toAccountId, double amount) {
		withdraw(fromAccountId, amount);
		deposit(toAccountId, amount);
		transactionLogService.addTransactionLog("transfer amount" ,amount,TransactionType.TRANSFER);
	}

	@Override
	public void updateAddress(int accountId, String address, String phone, String email) {
		Account account = getAccountById(accountId);
		account.setAddress(address);
		account.setPhone(phone);
		account.setEmail(email);
		accountDao.updateAccount(account);

	}

	@Override
	public Account deleteAccount(int accountId) {

		return accountDao.deleteAccount(accountId);
	}

	@Override
	public Account getAccountById(int accountId) {
		return accountDao.getAccountById(accountId);
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}

}
