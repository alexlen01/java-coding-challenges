package dev.coding.crypto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Java Shift Caesar Cipher by shift spaces.
 * 
 * Restrictions:
 * 
 * Only works with a positive number in the shift parameter. Only works with a
 * shift less than 26. Does a += which will bog the computer down for bodies of
 * text longer than a few thousand characters. Does a cast number to character,
 * so it will fail with anything but ascii letters. Only tolerates letters a
 * through z. Cannot handle spaces, numbers, symbols or unicode. Code violates
 * the DRY (don't repeat yourself) principle by repeating the calculation more
 * than it has to.
 * 
 * Pseudo-code:
 * 
 * Loop through each character in the string. Add shift to the character and if
 * it falls off the end of the alphabet then subtract shift from the number of
 * letters in the alphabet (26) If the shift does not make the character fall
 * off the end of the alphabet, then add the shift to the character. Append the
 * character onto a new string. Return the string.
 */
public class CeasarShift {

	public String cipher(String msg, int shift) {
		List<Character> chars = new ArrayList<>();
		List<Character> letters = translate(msg);

		for (Character alpha : letters) {
			char c =  (char) (alpha + shift);
			int i;
			if (c > 'z') {
				i = alpha - (26 - shift);
			} else {
				i = alpha + shift;
			}
			chars.add((char) i);
		}

		return chars.stream().map(e->e.toString()).collect(Collectors.joining());
	}

	private List<Character> translate(final String str) {
		return str.chars()
				.mapToObj(i -> (char) i)
				.filter(Character::isAlphabetic)
				.collect(Collectors.toList());
	}
}
