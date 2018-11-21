package com.triopin.commons.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompareUtilsTest {

	@Test
	@SuppressWarnings("deprecation")
	public void compareComparable() {
		String v1 = "A";
		String v2 = "B";
		assertEquals(CompareUtils.compare(v1, v2),
				org.apache.commons.lang.ObjectUtils.compare(v1, v2));
	}
}
