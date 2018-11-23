package com.triopin.commons.util;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

import com.triopin.commons.lang.ThrowUtils;

public class CompareUtils {

	/**
	 * No instances of compare utilities.
	 */
	private CompareUtils() {
		ThrowUtils.noInstance();
	}

	/**
	 * Compares two comparable objects.
	 *
	 * @param <T> the generic type
	 * @param v1 the v 1
	 * @param v2 the v 2
	 * @return the int
	 * @deprecated this method has replacements by Apache Commons<br/>
	 *             {@link org.apache.commons.lang3.ObjectUtils#compare(Comparable, Comparable)} for
	 *             Java 7+ and <br/>
	 *             {@link org.apache.commons.lang.ObjectUtils#compare(Comparable, Comparable)}
	 *             for Java 1.2+
	 */
	@Deprecated
	public static final <T extends Comparable<T>> int compare(T v1, T v2) {
		if (v1 == null) {
			if (v2 == null) {
				return 0;
			} else {
				return +1;
			}
		} else if (v2 == null) {
			return -1;
		} else if (v1 == v2) {
			return 0;
		} else {
			return v1.compareTo(v2);
		}
	}

	/**
	 * Compares two {@code long} values numerically.
	 * 
	 * @param x the first {@code long} to compare
	 * @param y the second {@code long} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Long#compare(int, int)}
	 */
	public static final int compare(long v1, long v2) {
		if (v1 > v2) {
			return +1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Compares two {@code int} values numerically.
	 * 
	 * @param x the first {@code int} to compare
	 * @param y the second {@code int} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Integer#compare(long, long)}
	 */
	public static final int compare(int v1, int v2) {
		if (v1 > v2) {
			return +1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Compares two {@code short} values numerically.
	 * 
	 * @param x the first {@code short} to compare
	 * @param y the second {@code short} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Short#compare(short, short)}
	 */
	public static final int compare(short v1, short v2) {
		return v1 - v2;
	}

	/**
	 * Compares two {@code byte} values numerically.
	 * 
	 * @param x the first {@code byte} to compare
	 * @param y the second {@code byte} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Byte#compare(byte, byte)}
	 */
	public static final int compare(byte v1, byte v2) {
		return v1 - v2;
	}

	/**
	 * Compares two {@code char} values numerically.
	 * 
	 * @param x the first {@code char} to compare
	 * @param y the second {@code char} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Character#compare(char, char)}
	 */
	public static final int compare(char v1, char v2) {
		if (v1 > v2) {
			return +1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Compares two {@code float} values numerically.
	 * 
	 * @param x the first {@code float} to compare
	 * @param y the second {@code float} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Float#compare(float, float)}
	 */
	public static final int compare(float v1, float v2) {
		if (v1 > v2) {
			return +1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Compares two {@code double} values numerically.
	 * 
	 * @param x the first {@code double} to compare
	 * @param y the second {@code double} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Double#compare(double, double)}
	 */
	public static final int compare(double v1, double v2) {
		if (v1 > v2) {
			return +1;
		} else if (v1 < v2) {
			return -1;
		} else {
			return 0;
		}
	}

	/**
	 * Compares two {@code boolean} values numerically.
	 * 
	 * @param x the first {@code boolean} to compare
	 * @param y the second {@code boolean} to compare
	 * @return the value {@code 0} if {@code x == y};
	 *         a value less than {@code 0} if {@code x < y}; and
	 *         a value greater than {@code 0} if {@code x > y}
	 * @deprecated Since 1.7 Java has replacement {@link java.lang.Boolean#compare(boolean, boolean)}
	 */
	public static final int compare(boolean v1, boolean v2) {
		if (v1 == v2) {
			return 0;
		} else if (v1) {
			return +1;
		} else {
			return -1;
		}
	}

	/**
	 * Compare two <a href = "https://semver.org/">Semantic Versioning 2.0.0</a> strings.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	public static int compareSemanticVersions(String o1, String o2) {
		String[] arr1 = splitByDot(o1);
		String[] arr2 = splitByDot(o2);
		int len = Math.min(arr1.length, arr2.length);
		for (int i = 0; i < len; i++) {
			int c;
			if (isInteger(arr1[i]) && isInteger(arr2[i])) {
				c = compare(Integer.parseInt(arr1[i]), Integer.parseInt(arr2[i]));
			} else {
				c = arr1[i].compareToIgnoreCase(arr2[i]);
			}
			if (c != 0) {
				return c;
			}
		}
		return compare(arr1.length, arr2.length);
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
}
