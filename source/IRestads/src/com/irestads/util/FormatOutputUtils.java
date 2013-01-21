package com.irestads.util;

public class FormatOutputUtils {

	public static String formatIntToString(int i, int numberZero) {
		String display = "";
		if (numberZero > 0) {
			int point = 0;
			if (i < 10 * numberZero) {
				for (int j = 1; j <= numberZero; j++) {
					point = 10 * j;
					if (i < point) {
						display = "0" + display;
					}
				}
			}
		}
		display = display + i;
		return display;
	}
}
