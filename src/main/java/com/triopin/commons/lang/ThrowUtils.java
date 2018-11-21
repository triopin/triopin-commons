package com.triopin.commons.lang;

public class ThrowUtils {

	private ThrowUtils() {
		noInstance();
	}

	public static void noInstance() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		if(stackTrace.length >= 3) {
			//	0 : java.lang.Thread.getStackTrace()
			//	1 : com.triopin.commons.lang.ThrowUtils.noInstance()
			//	2 : Always contained method noInstance() invoker element
			StackTraceElement involkerElement = stackTrace[2];
			if ("<init>".equals(involkerElement.getMethodName())) {
				throw new AssertionError("No instances of class "
						+ involkerElement.getClassName());
			}
		}
		throw new UnsupportedOperationException(
				"This method should be used from constructors");
	}

	public static final RuntimeException rethrow(Throwable e) {
		ThrowUtils.<RuntimeException>throwAny(e);

		// This throw should actually never happen
		throw new IllegalStateException(e);
	}

	@SuppressWarnings("unchecked")
	private static <E extends Throwable> void throwAny(Throwable e) throws E {
		throw (E) e;
	}
}
