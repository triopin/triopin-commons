package com.triopin.commons.util;

import com.triopin.commons.lang.ThrowUtils;

public class TextUtils {

	private TextUtils() {
		ThrowUtils.noInstance();
	}

	/**
	 * Formats given time period in miliseconds to HH:mm:ss format string.<p>
	 * <b>NOTE</b>. Use {@link org.apache.commons.lang3.time#DurationFormatUtils} for more 
	 * advanced styles.
	 *
	 * @param period the period
	 * @return the string
	 */
	public static String formatPeriod(long period) {
		period /= 1000;
		final int sec = (int) period % 60;
		period /= 60;
		final int min = (int) period % 60;
		period /= 60;
		final int hours = (int) period;
		final StringBuilder sb = new StringBuilder();
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
