package com.server.utils;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class XMLUtils {

	public static <T> T unmarshall(String request, Class returnType) {
		Serializer serializer = null;
		T response = null;
		try {
			serializer = new Persister();
			response = (T) serializer.read(returnType, request);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return response;
	}
}
