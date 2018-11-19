package com.triopin.commons.lang;

public class ThrowUtils {

	private ThrowUtils() {
		noInstance();
	}

	public static void noInstance() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		String invokerClassName = null;
		if (stackTrace != null && stackTrace.length > 0) {
			for (StackTraceElement o : stackTrace) {
				if ("<init>".equals(o.getMethodName())) {
					invokerClassName = o.getClassName();
					break;
				}
			}
		}
		if (invokerClassName != null) {
			throw new AssertionError(
					"Instance creation of class " + invokerClassName + " not alowed");
		} else {
			throw new UnsupportedOperationException(
					"Method ThrowUtils.noInstance() should be used from constructors");
		}
	}

	public static final RuntimeException rethrow(Throwable e) {
		ThrowUtils.<RuntimeException>throwAny(e);

		// This throw actually never happens 
		throw new IllegalStateException(e);
	}

	@SuppressWarnings("unchecked")
	private static <E extends Throwable> void throwAny(Throwable e) throws E {
		throw (E) e;
	}
}
