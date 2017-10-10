package javaplay.linesplitter;

import junit.framework.TestCase;

public class LineSplitterTest extends TestCase {
	public void testSplit() {
		String input = "This is \"a test\" don\\'t you     'know it' fella";
		String[] expectedOutput = new String[]{"This", "is", "a test", "don't", "you", "know it", "fella"};		
		
		String[] actualOutput = LineSplitter.split(input);
		assertEquals(expectedOutput.length, actualOutput.length);
		for (int i = 0; i < expectedOutput.length; i++) {
			assertEquals(expectedOutput[i], actualOutput[i]);
		}
	}
}
