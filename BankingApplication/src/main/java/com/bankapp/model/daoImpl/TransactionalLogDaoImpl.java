package com.bankapp.model.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bankapp.model.dao.TransactionLogDao;
import com.bankapp.model.entities.TransactionLog;
import com.bankapp.model.entities.TransactionType;
@Repository
public class TransactionalLogDaoImpl implements TransactionLogDao{
	private SessionFactory factory;
	
	@Autowired
	public TransactionalLogDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}
	@Override
	public TransactionLog addTransactionLog(String txInfo, Double amount, TransactionType txnType) {
		TransactionLog log=new TransactionLog(txInfo, amount, txnType);
		getSession().persist(log);
		return log;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TransactionLog> getAllTransactionLogs() {
		List<TransactionLog>transactions= getSession().createQuery("from TransactionLog").list();
		return transactions;
	}

	@Override
	public List<TransactionLog> getAllTransactionLogsForAccount(int accountId) {
		Query query = getSession().createNativeQuery("select * from transaction_table t where t.account_id_fk=:accountId", TransactionLog.class);
		query.setParameter("accountId", accountId);
		List<TransactionLog> transactionEntries = query.getResultList();
		return transactionEntries;
		
	}

}
