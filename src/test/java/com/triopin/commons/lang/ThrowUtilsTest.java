package com.triopin.commons.lang;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class ThrowUtilsTest {

	@Test
	public void noInstanceFromConstructor() {
		try {
			new NoInstance();
		} catch (AssertionError e) {
			assertContainsClassName(NoInstance.class, e);
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void noInstanceFromMethod() {
		ThrowUtils.noInstance();
	}

	@Test
	public void createThrowUtils() throws Exception {
		Constructor<?> constructor = NoInstance.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		try {
			constructor.newInstance();
		} catch (InvocationTargetException e) {
			assertContainsClassName(NoInstance.class, e.getCause());
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void deepNoInstanceFromMethod() {
		new DeepNoInstance();
	}

	@Test(expected = IOException.class)
	public void rethrow() {
		ThrowUtils.rethrow(new IOException());
	}

	private void assertContainsClassName(Class<?> clazz, Throwable cause) {
		assertTrue(cause instanceof AssertionError);
		String message = cause.getMessage();
		assertTrue(message.contains(clazz.getName()));
	}

	public static class NoInstance {

		private NoInstance() {
			ThrowUtils.noInstance();
		}
	}

	private static class DeepNoInstance {

		DeepNoInstance() {
			level1();
		}

		void level1() {
			ThrowUtils.noInstance();
		}
	}
}
