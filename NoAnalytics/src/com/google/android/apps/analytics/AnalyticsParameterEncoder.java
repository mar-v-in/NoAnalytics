package com.google.android.apps.analytics;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AnalyticsParameterEncoder {
	public static String encode(String s) {
		return encode(s, "UTF-8");
	}

	static String encode(String s, String charset) {
		try {
			return URLEncoder.encode(s, charset).replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new AssertionError((new StringBuilder())
					.append("URL encoding failed for: ").append(s).toString());
		}
	}
}
