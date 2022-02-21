package com.codercampus.Assignment11.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepo;

	public Transaction findById(Long transactionId) {
		Optional<Transaction> transaction = transactionRepo.findAll().stream()
				.filter(t -> t.getId().equals(transactionId)).findFirst();

		return transaction.orElse(null);
	}

	public List<Transaction> findAllTransactions() {

		List<Transaction> transactions = transactionRepo.findAll();

		return transactions;
	}

}
