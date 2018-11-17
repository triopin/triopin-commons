package com.triopin.commons.lang;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class ThrowUtilsTest {

	@Test(expected = AssertionError.class)
	public void noInstance() {
		ThrowUtils.noInstance();
	}

	@Test(expected = InvocationTargetException.class)
	public void createThrowUtils() throws Exception {
		Constructor<?> constructor = ThrowUtils.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		constructor.newInstance();
	}

	@Test(expected = IOException.class)
	public void rethrow() {
		ThrowUtils.rethrow(new IOException());
	}
}
