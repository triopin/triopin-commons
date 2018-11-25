package com.triopin.commons.io;

import java.io.IOException;
import java.io.OutputStream;

public class JointOutputStream extends OutputStream {

	private final OutputStream[] destinations;

	public JointOutputStream(OutputStream... destinations) {
		for (int i = 0; i < destinations.length; i++) {
			if (destinations[i] == null) {
				throw new IllegalArgumentException(
						"Null value of destination " + (i + 1));
			}
		}
		this.destinations = destinations;
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(int)
	 */
	@Override
	public void write(int b) throws IOException {
		for (OutputStream tgt : destinations) {
			tgt.write(b);
		}
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[])
	 */
	@Override
	public void write(byte[] b) throws IOException {
		for (OutputStream tgt : destinations) {
			tgt.write(b);
		}
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#write(byte[], int, int)
	 */
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		for (OutputStream tgt : destinations) {
			tgt.write(b, off, len);
		}
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#flush()
	 */
	@Override
	public void flush() throws IOException {
		for (OutputStream tgt : destinations) {
			tgt.flush();
		}
	}

	/* (non-Javadoc)
	 * @see java.io.OutputStream#close()
	 */
	@Override
	public void close() throws IOException {
		for (OutputStream tgt : destinations) {
			tgt.close();
		}
	}
}
