package com.triopin.commons.lang;

public class ThrowUtils {

	private ThrowUtils() {
		noInstance();
	}

	/**
	 * Method to protect private utility classes constructor from creating instances
	 * even using reflection framework.
	 */
	public static void noInstance() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if (stackTrace.length >= 3) {
			//	0 : java.lang.Thread.getStackTrace()
			//	1 : com.triopin.commons.lang.ThrowUtils.noInstance()
			//	2 : Always contained method noInstance() invoker element
			StackTraceElement involkerElement = stackTrace[2];
			if ("<init>".equals(involkerElement.getMethodName())) {
				throw new AssertionError(
						"No instances of class " + involkerElement.getClassName());
			}
		}
		throw new UnsupportedOperationException(
				"This method should be used from constructors");
	}

	/**
	 * Rethrows given throwable as runtime exception.
	 * <p>
	 * This method is based on articles <a
	 * href="https://www.gamlor.info/wordpress/2010/02/throwing-checked-excpetions-like-unchecked-exceptions-in-java/">Throwing
	 * Checked Exceptions Like Unchecked Exceptions in Java</a> and
	 * <a href="http://robaustin.wikidot.com/rethrow-exceptions">How to Rethrow an Exception Without
	 * Wrapping them</a>
	 *
	 * @param e the e
	 * @return the runtime exception
	 */
	public static final RuntimeException rethrow(Throwable e) {
		ThrowUtils.<RuntimeException>throwAny(e);

		// This throw should actually never happen
		throw new AssertionError("WTF");
	}

	@SuppressWarnings("unchecked")
	private static <E extends Throwable> void throwAny(Throwable e) throws E {
		throw (E) e;
	}
}
