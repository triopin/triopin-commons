package com.triopin.commons.util;

import java.util.Comparator;

@Deprecated
public final class VersionsComparator implements Comparator<String> {

	/**
	 * Compare two <a href = "https://semver.org/">Semantic Versioning 2.0.0</a> strings.
	 *
	 * @param o1 the o 1
	 * @param o2 the o 2
	 * @return the int
	 */
	public static int cmp(String o1, String o2) {
		return CompareUtils.compareSemanticVersions(o1, o2);
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2) {
		return CompareUtils.compareSemanticVersions(o1, o2);
	}
}
