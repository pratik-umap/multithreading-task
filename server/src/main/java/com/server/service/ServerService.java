package com.server.service;

import com.server.dto.ServerResponse;

public interface ServerService {
	ServerResponse handlePayment(String req);
}
