package com.triopin.commons.util;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Comparator;
import java.util.Locale;

public final class VersionsComparator implements Comparator<String> {

	/**
	 * Compare two version strings.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	public static int cmp(String o1, String o2) {
		String[] arr1 = splitByDot(o1);
		String[] arr2 = splitByDot(o2);
		int len = Math.min(arr1.length, arr2.length);
		for (int i = 0; i < len; i++) {
			int c;
			if (isInteger(arr1[i]) && isInteger(arr2[i])) {
				c = cmp(Integer.parseInt(arr1[i]), Integer.parseInt(arr2[i]));
			} else {
				c = arr1[i].compareToIgnoreCase(arr2[i]);
			}
			if (c != 0) {
				return c;
			}
		}
		return cmp(arr1.length, arr2.length);
	}

	/**
	 * Split string by dot.
	 *
	 * @param s the s
	 * @return the string[]
	 */
	private static String[] splitByDot(String s) {
		if (s != null) {
			return s.trim().split("\\."); //$NON-NLS-1$
		} else {
			return new String[0];
		}
	}

	/**
	 * Checks if given string is integer.
	 *
	 * @param s the s
	 * @return true, if is integer
	 */
	private static final boolean isInteger(String s) {
		NumberFormat formatter = NumberFormat.getIntegerInstance(Locale.ENGLISH);
		ParsePosition pos = new ParsePosition(0);
		formatter.parse(s, pos);
		return s.length() == pos.getIndex();
	}

	private static final int cmp(int v1, int v2) {
		if (v1 > v2) {
			return +1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2) {
		return cmp(o1, o2);
	}
}
