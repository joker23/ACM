import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.awt.Point;

import static java.util.Arrays.*;
import static java.lang.Integer.*;
import static java.lang.Double.*;
import static java.lang.Long.*;
import static java.lang.Short.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Collections.*;

public class MnemonicMemory {
	public String getPhrase(String number, String[] dictionary) {
		sort(dictionary);
		boolean[] alreadyUsed = new boolean[dictionary.length];
		String ans = "";

		for (char c : number.toCharArray()) {
			int num = c - '0';
			for (int i=0; i<dictionary.length; i++) {
				if (dictionary[i].length() == num && !alreadyUsed[i]) {
					alreadyUsed[i] = true;
					ans += dictionary[i] + " ";
					break;
				}
			}
		}

		return ans.trim();
	}

	public static void main(String[] args) {
		MnemonicMemory temp = new MnemonicMemory();
	}
}
