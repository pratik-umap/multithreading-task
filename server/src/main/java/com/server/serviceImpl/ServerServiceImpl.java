package com.server.serviceImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.server.dto.ServerResponse;
import com.server.dto.TransactionRequest;
import com.server.entity.Account;
import com.server.entity.Transaction;
import com.server.repository.AccountRepository;
import com.server.repository.TransactionRepository;
import com.server.service.ServerService;
import com.server.utils.XMLUtils;

import jakarta.transaction.Transactional;

@Service
public class ServerServiceImpl implements ServerService{

	private TransactionRepository repository;
	private AccountRepository accountRepository;

	public ServerServiceImpl(TransactionRepository repository,AccountRepository accountRepository) {
		this.repository=repository;
		this.accountRepository=accountRepository;
	}
	
	@Override
	@Transactional
	public ServerResponse handlePayment(String req) {
		TransactionRequest trxRequest = XMLUtils.unmarshall(req, TransactionRequest.class);
			ServerResponse response = new ServerResponse();
			response.setTrxId(trxRequest.getTrxId());
		Optional<Transaction> transaction = repository.findById(trxRequest.getTrxId());
		if (!transaction.isPresent()) {
		 Optional<Account> fromAccount = accountRepository.findById(trxRequest.getFromAccount());
		 Optional<Account> toAccount = accountRepository.findById(trxRequest.getToAccount());
		 
			if (fromAccount.isPresent() && toAccount.isPresent() && fromAccount.get().getBalance() >= trxRequest.getAmount()) {
				Account from = fromAccount.get();
				Account to = toAccount.get();
				from.setBalance(from.getBalance()-trxRequest.getAmount());
				to.setBalance(to.getBalance()+trxRequest.getAmount());
				
				repository.save(new Transaction(trxRequest.getTrxId(), trxRequest.getBankId(), trxRequest.getCustomerId(), trxRequest.getFromAccount()
						, trxRequest.getToAccount(), trxRequest.getAmount(), trxRequest.getCurrency(), trxRequest.getTimeStamp()));
				accountRepository.save(from);
				accountRepository.save(to);
			} else {
				if (fromAccount.isEmpty() || toAccount.isEmpty()) {
				response.setStatus("FAILED");
				response.setReason("Account Not Present");
				} else {
					response.setStatus("FAILED");
					response.setReason("Insufficient balance");
				}
			}
		} else {
			response.setStatus("FAILED");
			response.setReason("Duplicate transaction");
		}

		return response;
	}

}
