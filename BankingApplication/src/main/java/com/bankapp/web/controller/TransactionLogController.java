package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.service.TransactionLogService;

@Controller
public class TransactionLogController {
	
	private TransactionLogService transactionLogService;
	
	@Autowired
	public TransactionLogController(TransactionLogService transactionLogService) {
		this.transactionLogService = transactionLogService;
	}
	
	@GetMapping("showalltransactions")
	public ModelAndView showAllTransactionss(ModelAndView mv) {
		mv.setViewName("showalltransactions");
		mv.addObject("transactions", transactionLogService.getAllTransactionLogs());
		return mv;
	}
	
	@GetMapping("showtransactions")
	public ModelAndView showTransactionss(ModelAndView mv,HttpServletRequest req) {
		int id =Integer.parseInt(req.getParameter("id"));
		mv.setViewName("showtransactionsbyid");
		mv.addObject("transactions", transactionLogService.getAllTransactionLogsForAccount(id));
		return mv;
	}
		
	
}
