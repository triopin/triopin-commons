package com.triopin.commons.util;

import com.triopin.commons.lang.ThrowUtils;

public class TextUtils {

	private TextUtils() {
		ThrowUtils.noInstance();
	}

	/**
	 * Format period.
	 *
	 * @param period the period
	 * @return the string
	 * 
	 * <b>NOTE</b>. Use class org.apache.commons.lang3.time.DurationFormatUtils for more 
	 * advanced styles.
	 */
	public static String formatPeriod(long period) {
		period /= 1000;
		final int sec = (int) period % 60;
		period /= 60;
		final int min = (int) period % 60;
		period /= 60;
		final int hours = (int) period;
		StringBuilder sb = new StringBuilder();
		append(sb, hours);
		sb.append(':');
		append(sb, min);
		sb.append(':');
		append(sb, sec);
		return sb.toString();
	}

	private static void append(StringBuilder sb, int val) {
		if (val < 10) {
			sb.append('0');
		}
		sb.append(val);
	}
}
