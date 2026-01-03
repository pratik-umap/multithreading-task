package com.server.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.dto.ServerResponse;
import com.server.service.ServerService;

@RestController
@RequestMapping("/server")
public class ServerController {
	
	private ServerService serverService;
	
	public ServerController(ServerService serverService) {
		this.serverService=serverService;
	}
	
	@PostMapping("/transaction/process")
	public CompletableFuture<ServerResponse> handlePayment(@RequestBody String req) {
		return CompletableFuture.supplyAsync(()->{
			return serverService.handlePayment(req);
		});
	}
}
