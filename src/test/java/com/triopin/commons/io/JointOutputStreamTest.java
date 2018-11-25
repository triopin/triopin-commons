package com.triopin.commons.io;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

public class JointOutputStreamTest {

	@Test(expected = IllegalArgumentException.class)
	public void nullArgument() throws IOException {
		new JointOutputStream(new ByteArrayOutputStream(), null).close();
	}

	@Test
	public void writeByte() throws IOException {
		final ByteArrayOutputStream dst1 = new ByteArrayOutputStream();
		final ByteArrayOutputStream dst2 = new ByteArrayOutputStream();
		final JointOutputStream joint = new JointOutputStream(dst1, dst2);
		byte val = 1;
		joint.write(val);
		joint.flush();
		byte[] arr1 = dst1.toByteArray();
		assertTrue(arr1.length == 1);
		assertTrue(arr1[0] == val);
		byte[] arr2 = dst2.toByteArray();
		assertTrue(arr2.length == 1);
		assertTrue(arr2[0] == val);
		joint.close();
	}

	@Test
	public void writeArray() throws IOException {
		final ByteArrayOutputStream dst1 = new ByteArrayOutputStream();
		final ByteArrayOutputStream dst2 = new ByteArrayOutputStream();
		final JointOutputStream joint = new JointOutputStream(dst1, dst2);
		byte[] val = {1, 2, 3, 4, 5, 6, 7, 8};
		joint.write(val);
		joint.flush();
		byte[] arr1 = dst1.toByteArray();
		assertTrue(arr1.length == val.length);
		assertTrue(Arrays.equals(arr1,  val));
		byte[] arr2 = dst2.toByteArray();
		assertTrue(arr2.length == val.length);
		assertTrue(Arrays.equals(arr1,  val));
		joint.close();
	}

	@Test
	public void writeByteRange() throws IOException {
		final ByteArrayOutputStream dst1 = new ByteArrayOutputStream();
		final ByteArrayOutputStream dst2 = new ByteArrayOutputStream();
		final JointOutputStream joint = new JointOutputStream(dst1, dst2);
		byte[] val = {1, 2, 3, 4, 5, 6, 7, 8};
		joint.write(val, 0, val.length);
		joint.flush();
		byte[] arr1 = dst1.toByteArray();
		assertTrue(arr1.length == val.length);
		assertTrue(Arrays.equals(arr1,  val));
		byte[] arr2 = dst2.toByteArray();
		assertTrue(arr2.length == val.length);
		assertTrue(Arrays.equals(arr1,  val));
		joint.close();
	}
}
