package com.codercampus.Assignment11.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;

@Controller
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	// endpoints
	@GetMapping("/transactions")

	// with RestController we need to return custom object from domain package,

	// with regular Controller GetMapping method we need to return String which
	// represents the location of our view i.e. the location of our html file
	public String getAllTransactions(ModelMap model) {

		// by default: path /src/main/resources/templates/{filename}.html, where
		// filename is the String we return

		List<Transaction> transactions = transactionService.findAllTransactions();
		model.put("transactions", transactions);

		return "transactions";
	}

	@GetMapping("/transactions/{transactionId}")
	public String getTransactionById(@PathVariable Long transactionId, ModelMap model) {
		Transaction transaction = transactionService.findById(transactionId);
		model.put("transaction", transaction);
		return "transaction";
	}

	/*
	 * MVC - Model View Controller, Model is the HashMap, it takes keys and values
	 * from java and passes them using thymeleaf lib to the view (to the html page)
	 * and with that model the html page can take the data in the HasMap and display
	 * them on the HTML page
	 */
}
