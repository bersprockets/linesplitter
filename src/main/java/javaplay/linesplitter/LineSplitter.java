package javaplay.linesplitter;

import java.util.ArrayList;
import java.util.List;

public class LineSplitter {
	public static String[] split(String line) {
		List<String> tokens = new ArrayList<>();
		StringBuffer currToken = new StringBuffer();
		
		boolean inQuotedString = false;
		boolean nextCharQuoted = false;
		char quoteChar = 0;
		
		for (int i = 0; i < line.length(); i++) {
			char c = line.charAt(i);
			if (nextCharQuoted) {
				nextCharQuoted = false;
				currToken.append(c);
			} else if (inQuotedString) {
				if (c == quoteChar) {
					inQuotedString = false;
					quoteChar = 0;
				} else {
					currToken.append(c);
				}
			} else if (c == '\\') {
				nextCharQuoted = true;
			} else if (c == '"' || c == '\'') {
				inQuotedString = true;
				quoteChar = c;
			} else if (Character.isWhitespace(c)) {
				String newToken = currToken.toString();
				if (newToken.length() > 0) {
					tokens.add(newToken);
				}
				currToken.replace(0, currToken.length(), "");
			} else {
				currToken.append(c);
			}
		}
		String remainingToken = currToken.toString();
		if (remainingToken.length() > 0) {
			tokens.add(remainingToken);
		}
		return tokens.toArray(new String[tokens.size()]);
	}

}
