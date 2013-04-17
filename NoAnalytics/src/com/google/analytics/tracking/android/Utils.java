package com.google.analytics.tracking.android;

public class Utils {
	private static final char HEXBYTES[] =
			{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	public static String hexEncode(byte[] bytes) {
		char out[] = new char[bytes.length * 2];
		for (int i = 0; i < bytes.length; i++) {
			int b = bytes[i] & 0xff;
			out[2 * i] = HEXBYTES[b >> 4];
			out[2 * i + 1] = HEXBYTES[b & 0xf];
		}

		return new String(out);
	}

	public static boolean safeParseBoolean(String s) {
		if (s == null) {
			return false;
		} else {
			return Boolean.parseBoolean(s);
		}
	}

	public static double safeParseDouble(String s) {
		if (s == null) {
			return 0;
		}
		try {
			return Double.parseDouble(s);
		} catch (NumberFormatException e) {
			return 0;
		}
	}
}
