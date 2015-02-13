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

public class TheMatrix {
	public int MaxArea(String[] board) {
		int[][] height = new int[board.length][board[0].length()];

		for (int i=0; i<board.length; i++) {
			String tmp = board[i];

			for (int j=height[i].length - 1; j >= 0; j--) {
				if (j == height[i].length - 1) {
					height[i][j] = 1;
				} else {
					if (tmp.charAt(j) != tmp.charAt(j + 1)) {
						height[i][j] = height[i][j+1] + 1;
					} else {
						height[i][j] = 1;
					}
				}
			}
		}

		int n = height.length;
		int m = height[0].length;
		int ans = 0;

		for (int k = 0; k < m; k++) {
			for (int i=0; i < n; i++) {
				int min = height[i][k];
				for (int j=i; j<n; j++) {
					if (i == j) {
						ans = Math.max(ans, min);
					} else {
						if (board[j - 1].charAt(k) == board[j].charAt(k)) {
							break;
						} else {
							min = Math.min(min, height[j][k]);
							ans = Math.max(ans, min * (j - i + 1));
						}
					}
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		TheMatrix temp = new TheMatrix();
	}
}
