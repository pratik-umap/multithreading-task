package com.client.util;

import java.util.UUID;

public class GenerateIdUtils {

	public static String generateTransId() {
		return UUID.randomUUID().toString();
	}
}
