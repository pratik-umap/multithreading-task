package com.client.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.client.dto.ClientRequest;
import com.client.dto.ClientResponse;
import com.client.dto.ServerResponse;
import com.client.service.ClientService;

import reactor.core.publisher.Mono;

@RestController
public class ClientController {
	
	private ClientService clientService;
	
	public ClientController(ClientService clientService) {
		this.clientService=clientService;
	}
	
	@PostMapping("/bank/transaction")	
	public CompletableFuture<Mono<ServerResponse>> handleTransaction(@RequestBody ClientRequest request) {
		return  CompletableFuture.supplyAsync(()->{
		   return clientService.processPayment(request);			
		});
	}
}
