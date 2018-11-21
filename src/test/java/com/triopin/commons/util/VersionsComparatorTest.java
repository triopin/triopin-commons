package com.triopin.commons.util;

import static org.junit.Assert.*;

import org.junit.Test;

@SuppressWarnings("deprecation")
public class VersionsComparatorTest {

	@Test
	public void cmp() {
		assertTrue(VersionsComparator.cmp("1.0.1", "1.0.3") < 0);
		assertTrue(VersionsComparator.cmp("1.0.3", "1.0.1") > 0);
	}

	@Test
	public void comparator() {
		final VersionsComparator o = new VersionsComparator();
		assertTrue(o.compare("1.0.1", "1.0.3") < 0);
		assertTrue(o.compare("1.0.3", "1.0.1") > 0);
	}
}
