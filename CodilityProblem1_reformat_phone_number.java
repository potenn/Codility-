

import static org.junit.Assert.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/*
1. Fisrt, You must clean the character except for Digit
2. Using CleanedString, You count the CleanedString
3.
Divide by 3 for all numbers and the rest will be only 0, 1, 2.
So, you use this characterristic
you solve the problem each case(0,1,2)

*/


public class CodilityProblem1_reformat_phone_number {

	@Test
	public static void testUsingRegexExpression_run() {
		System.out.println("testUsingRegexExpression_run");
		assertEquals("004-448-555-583-61", removeExceptDigit("00-44  48 5555 8361"));
		assertEquals("022-198-53-24", removeExceptDigit("0 - 22 1985--324"));
		assertEquals("555-372-654", removeExceptDigit("555372654"));
		assertEquals("555-372-65-44", removeExceptDigit("553/72-6-54/4"));

	}

	@Test
	public static void testNotUsingRegexExpression_run() {
		System.out.println("JUnit testNotUsingRegexExpression_run");
		assertEquals("004-448-555-583-61", solutionNotUsingRegex("00-44  48 5555 8361"));
		assertEquals("022-198-53-24", solutionNotUsingRegex("0 - 22 1985--324"));
		assertEquals("555-372-654", solutionNotUsingRegex("555372654"));
		assertEquals("555-372-65-44", solutionNotUsingRegex("555/372-6-54/4"));

		System.out.println("Test OK");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// "55 5/372-6-5/44"
		// "00-44 48 5555 8361"

		System.out.println("Not Using Regex Expression");
		String a = removeExceptDigit("00-44  48 5555 8361");
		String answer1 = solution(a);
		System.out.println(answer1);

		System.out.println("Using Regex Expression");
		String input = cleanString("00-44  48 5555 8361");
		System.out.println(input);

		String answer2 = solutionNotUsingRegex(input);
		System.out.println(answer2);

		System.out.println("JUnit Test");
		testNotUsingRegexExpression_run();



	}

	/**
	 * Not Using Regex Expression
	 * @param S
	 * @return
	 */

	public static String cleanString(String S) {

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			if (Character.isDigit(S.charAt(i))) {
				builder.append(S.charAt(i));
			}
		}
		return builder.toString();
	}

	public static String solutionNotUsingRegex(String S) {

		S = cleanString(S);
		int remainder = S.length() % 3;
		int len = S.length();
		StringBuilder answerBuilder = new StringBuilder();
		switch (remainder) {

		case 0:
			for (int i = 0; i < len; i++) {

				answerBuilder.append(S.charAt(i));
				if (i % 3 == 2 && i != len - 1) {
					answerBuilder.append("-");
				}

			}
			break;

		case 1:
			// the last Two block data sum len is 4
			for (int i = 0; i < len - 4; i++) {
				answerBuilder.append(S.charAt(i));
				if (i % 3 == 2) {
					answerBuilder.append("-");
				}
			}
			for (int i = len - 4; i < len; i++) {
				answerBuilder.append(S.charAt(i));
				if (i % 2 == 1 && i != len-1) {
					answerBuilder.append("-");
				}
			}

			break;

		case 2:
			for (int i = 0; i < len - 2; i++) {
				answerBuilder.append(S.charAt(i));
				if (i % 3 == 2) {
					answerBuilder.append("-");
				}
			}
			for (int i = len - 2; i < len; i++) {
				answerBuilder.append(S.charAt(i));
				// if(i % 2 == 0 && i != len - 1){
				// answerBuilder.append("-");
				// }
			}
			break;

		}

		return answerBuilder.toString();

	}

	/**
	 * Using Regex Expression
	 *
	 * @param S
	 * @return
	 */

	public static String solution(String S) {
		// write your code in Java SE 8

		StringBuilder answerBuilder = new StringBuilder();
		String cleanS = removeExceptDigit(S);
		int lenOfCleanS = cleanS.length();

		int idx;

		switch (lenOfCleanS % 3) {
		case 0:
			for (idx = 0; idx < lenOfCleanS; idx += 3) {
				answerBuilder.append(cleanS.substring(idx, idx + 3));
				answerBuilder.append("-");
			}
			break;

		case 1:
			for (idx = 0; idx < lenOfCleanS - 4; idx += 3) {
				answerBuilder.append(cleanS.substring(idx, idx + 3));
				answerBuilder.append("-");
			}
			answerBuilder.append(cleanS.substring(lenOfCleanS - 4, lenOfCleanS - 2));
			answerBuilder.append("-");
			answerBuilder.append(cleanS.substring(lenOfCleanS - 2, lenOfCleanS));
			answerBuilder.append("-");
			break;
		case 2:
			for (idx = 0; idx < lenOfCleanS - 2; idx += 3) {
				answerBuilder.append(cleanS.substring(idx, idx + 3));
				answerBuilder.append("-");
			}
			answerBuilder.append(cleanS.substring(lenOfCleanS - 2, lenOfCleanS));
			answerBuilder.append("-");
			break;
		default:
			break;
		}
		String sTemp = answerBuilder.toString().substring(0, answerBuilder.toString().length() - 1);
		return sTemp;

	}

	public static String removeExceptDigit(String input) {

		StringBuilder removedExceptDigit = new StringBuilder();

		// \d -> Digit[0~9] is Same
		Pattern pattern = Pattern.compile("\\d");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			removedExceptDigit.append(matcher.group());
		}
		return removedExceptDigit.toString();
	}

}
