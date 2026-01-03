package com.client.service.impl;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.client.dto.ClientRequest;
import com.client.dto.ClientResponse;
import com.client.dto.ServerResponse;
import com.client.dto.TransactionRequest;
import com.client.service.ClientService;
import com.client.util.GenerateIdUtils;
import com.client.util.XMLUtils;

import reactor.core.publisher.Mono;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Override
	public  Mono<ServerResponse> processPayment(ClientRequest clientRequest) {
		String transactionId = GenerateIdUtils.generateTransId();
		ZonedDateTime zonedNow = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
		TransactionRequest request = new TransactionRequest();
		request.setTrxId(transactionId);
		request.setBankId("Bank_A");
		request.setCustomerId(clientRequest.getCustomerId());
		request.setFromAccount(clientRequest.getFromAccount());
		request.setToAccount(clientRequest.getToAccount());
		request.setAmount(clientRequest.getAmount());
		request.setCurrency(clientRequest.getCurrency());
		request.setTimeStamp(LocalDateTime.now().toString());
		
		String xml = XMLUtils.marshall(request);
		
		WebClient webClient = WebClient.create("http://localhost:8083");
		  return webClient.post()
		    .uri("/server/transaction/process")
		    .contentType(MediaType.APPLICATION_JSON)
		    .bodyValue(xml)
		    .retrieve()
		    .bodyToMono(ServerResponse.class);
	}

}
