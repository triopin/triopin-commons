package com.triopin.commons.lang;

public class ThrowUtils {

	private ThrowUtils() {
		noInstance();
	}

	public static void noInstance() {
		throw new AssertionError("Instance creation not alowed");
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
