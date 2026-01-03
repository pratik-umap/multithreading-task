package com.client.util;

import java.io.StringWriter;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

public class XMLUtils {
	public static String marshall(Object object) {
		StringWriter stringWriter = null;
		Serializer serializer = null;
		String response = null;
		try {
			stringWriter = new StringWriter();
			serializer = new Persister();
			serializer.write(object, stringWriter);
			response = stringWriter.toString();
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return response;
	}
}
