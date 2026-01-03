package com.client.service;

import com.client.dto.ClientRequest;
import com.client.dto.ClientResponse;
import com.client.dto.ServerResponse;

import reactor.core.publisher.Mono;

public interface ClientService {
	Mono<ServerResponse> processPayment(ClientRequest clientRequest);
}
