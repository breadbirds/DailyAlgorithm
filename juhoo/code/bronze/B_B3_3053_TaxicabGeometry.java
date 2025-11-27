package source_code;

import java.io.*;
import java.util.*;

public class B_B3_3053_TaxicabGeometry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		System.out.println(Math.PI * Math.pow(num, 2));
		System.out.println(2 * Math.pow(num, 2));
	}

}
