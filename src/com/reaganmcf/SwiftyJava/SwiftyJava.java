//Written by Reagan McFarland 2016

package com.reaganmcf.SwiftyJava;

import java.util.ArrayList;
import java.util.Collections;

public class SwiftyJava {

	//Print for static data types
	public void print(String r) {
		System.out.println(r);
	}
	public void print(short r) {
		System.out.println(r);
	}
	
	public void print(int r) {
		System.out.println(r);
	}
	
	public void print(long r) {
		System.out.println(r);
	}
	
	public void print(boolean r) {
		System.out.println(r);
	}
	
	public void print(char r) {
		System.out.println(r);
	}
	
	public void print(float r) {
		System.out.println(r);
	}
	
	public void print(double r) {
		System.out.println(r);
	}
	
	public void print(Object r) {
		System.out.println(r);
	}
	
	//Print for arrays of data types
	public void print(String[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void print(int[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void print(double[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void print(char[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void print(short[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void print(long[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	public void print(boolean[] r) {
		for(int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}
	
	
	//SWIFTY STRING CONVERSIONS
	public String String(int r) {
		return Integer.toString(r);
	}
	
	public String String(boolean r) {
		return Boolean.toString(r);
	}
	
	public String String(double r) {
		return Double.toString(r);
	}
	
	public String String(float r) {
		return Float.toString(r);
	}
	
	public String String(char r) {
		return Character.toString(r);
	}
	
	public String String(short r) {
		return Short.toString(r);
	}
	
	public String String(long r) {
		return Long.toString(r);
	}
	
	public String String(byte r) {
		return Byte.toString(r);
	}
	
	
	
	
	//SWIFTY INT CONVERSIONS
	public int Int(String r) {
		return Integer.parseInt(r);
	}
	
	public int Int(boolean r) {
		if(r == true) {
			return 1;
		}else{
			return 0;
		}
	}
	
	public int Int(double r) {
		return (int) Math.round(r);
	}
	
	public int Int(float r) {
		return (int) Math.round(r);
	}
	
	public int Int(short r) {
		return Short.toUnsignedInt(r);
	}
	
	public int Int(byte r) {
		return Byte.toUnsignedInt(r);
	}

	
	
	
	
	//SWIFTY BOOLEAN CONVERSIONS
	public boolean Bool(String r) {
		String lowerR = r.toLowerCase();
		if(lowerR == "true") {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean Bool(int r) {
		if(r == 1) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Bool(short r) {
		if(r == 1) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Bool(long r) {
		if(r == 1) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Bool(double r) {
		if(Math.round(r) == 1.0) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Bool(float r) {
		if(Math.round(r) == 1.0) {
			return true;
		}else{
			return false;
		}
	}
	
	public boolean Bool(char r) {
		if(r == 1) {
			return true;
		}else{
			return false;
		}
	}
	
	
	
	
	//SWIFTY DOUBLE CONVERSIONS 
	public double Double(String r) {
		return Double.parseDouble(r);
	}
	
	public double Double(float r) {
		return (float) r;
	}
	
	public double Double(int r) {
		return (double) r;
	}
	
	public double Double(boolean r) {
		if(r == true) {
			return 1.0;
		}else{
			return 0.0;
		}
	}
	
	
	
	//SWIFTY CHAR CONVERSIONS
	public char Char(String r) {
		if(r.length() == 1) {
			return r.charAt(0);
		}else{
			return 'n';
		}
	}
	
	public char Char(int r) {
		String l = String(r);
		return Char(l);
	}
	
	public char Char(short r) {
		int l = (int) r;
		return Char(l);
	}
	
	
	
	
	//EASIER ARRAY SWAPS
	public void swap(Object[] arr, int p1, int p2) {
		Object place1 = arr[p1];
		Object place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(String[] arr, int p1, int p2) {
		String place1 = arr[p1];
		String place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(int[] arr, int p1, int p2) {
		int place1 = arr[p1];
		int place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(boolean[] arr, int p1, int p2) {
		boolean place1 = arr[p1];
		boolean place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(double[] arr, int p1, int p2) {
		double place1 = arr[p1];
		double place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(char[] arr, int p1, int p2) {
		char place1 = arr[p1];
		char place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(float[] arr, int p1, int p2) {
		float place1 = arr[p1];
		float place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(short[] arr, int p1, int p2) {
		short place1 = arr[p1];
		short place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	public void swap(long[] arr, int p1, int p2) {
		long place1 = arr[p1];
		long place2 = arr[p2];
		arr[p1] = place2;
		arr[p2] = place1;
	}
	
	
	//Some Visual Basic Methods that I wanted to implement also because they are handy
	public boolean isNumeric(String r) {
		
		if(r == null) {
			throw new RuntimeException("[Swifty Java] : argument of isNumeric() is null");
		}
		
		char[] arr = new char[r.length()];
		for(int i = 0; i < r.length(); i++) {
			arr[i] = r.charAt(i);
			
		}
		
		print(arr);
		
		boolean containsNumbers = false;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == '0' ||
					arr[i] == '1' ||
					arr[i] == '2' ||
					arr[i] == '3' ||
					arr[i] == '4' || 
					arr[i] == '5' ||
					arr[i] == '6' ||
					arr[i] == '7' ||
					arr[i] == '8' ||
					arr[i] == '9') {
				containsNumbers = true;
			}else{
				containsNumbers = false;
				return false;
			}
		}
		
		if(containsNumbers) {
			return true;
		}else{
			return false;
		}
	}
	
	//Compare 2 Strings
	//If arg0.length < arg1.length; return -1
	//If arg0 == arg1; return 0
	//If arg0.length > arg1.length; return 1
	public int Compare(String arg0, String arg1) {
		
		if(arg0 == null) {
			throw new RuntimeException("[SwiftyJava] : arg1 in Compare(arg0, arg1) is null.");
		}
		
		if(arg1 == null) {
			throw new RuntimeException("[SwiftyJava] : arg1 in Compare(arg0, arg1) is null.");
		}

		if(arg0.length() < arg1.length()) {
			return -1;
		}else if(arg0 == arg1) {
			return 0;
		}else{
			return 1;
		}
	}
	
	//Ignore Case
	public int Compare(String arg0, String arg1, boolean ignoreCase) {
		
		if(arg0 == null) {
			throw new RuntimeException("[SwiftyJava] : arg1 in Compare(arg0, arg1) is null.");
		}
		
		if(arg1 == null) {
			throw new RuntimeException("[SwiftyJava] : arg1 in Compare(arg0, arg1) is null.");
		}
		
		if(ignoreCase == true) { 
			arg0 = arg0.toLowerCase();
			arg1 = arg1.toLowerCase();
		}

		if(arg0.length() < arg1.length()) {
			return -1;
		}else if(arg0 == arg1) {
			return 0;
		}else{
			return 1;
		}
	}
	
	//Get substrings of strings and compare them
	public int Compare(String arg0, int arg0StartIndex, String arg1, int arg1StartIndex, int numOfCharsToCompare) {
		
		if(arg0 == null) {
			throw new RuntimeException("[SwiftyJava] : arg0 in Compare(arg0, arg0StartIndex, arg1, arg1StartIndex, numOfCharsToCompare) is null.");
		}
		if(arg1 == null) {
			throw new RuntimeException("[SwiftyJava] : arg1 in Compare(arg0, arg0StartIndex, arg1, arg1StartIndex, numOfCharsToCompare) is null.");
		}
		if(arg0StartIndex < 0) {
			throw new RuntimeException("[SwiftyJava] : arg0StartIndex is less than 0, cannot get substring when start index is < 0.");
		}
		if(arg1StartIndex < 0) {
			throw new RuntimeException("[SwiftyJava] : arg01StartIndex is less than 0, cannot get substring when start index is < 0.");
		}
		if(numOfCharsToCompare < 0) {
			throw new RuntimeException("[SwiftyJava] : numOfCharsToCompare is < 0. numOfCharsToCompare must be a positive integer");
		}
		if(numOfCharsToCompare > arg0.length()) {
			throw new RuntimeException("[SwiftyJava] : numOfCharsToCompare is greater than arg0.length(). Substring's index will be Out Of Range");
		}
		if(numOfCharsToCompare > arg1.length()) {
			throw new RuntimeException("[SwiftyJava] : numOfCharsToCompare is greater than arg1.length(). Substring's index will be Out Of Range");
		}
		
		String arg0CharsToCompare = arg0.substring(arg0StartIndex, numOfCharsToCompare);
		String arg1CharsToCompare = arg1.substring(arg1StartIndex, numOfCharsToCompare);
		
		if(arg0CharsToCompare.length() < arg1CharsToCompare.length()) {
			return -1;
		}else if(arg0CharsToCompare == arg1CharsToCompare) {
			return 0;
		}else{
			return 1;
		}
	
	}
	
	//overload for ignoring case
	public int Compare(String arg0, int arg0StartIndex, String arg1, int arg1StartIndex, int numOfCharsToCompare, boolean ignoreCase) {
		
		if(arg0 == null) {
			throw new RuntimeException("[SwiftyJava] : arg0 in Compare(arg0, arg0StartIndex, arg1, arg1StartIndex, numOfCharsToCompare) is null.");
		}
		if(arg1 == null) {
			throw new RuntimeException("[SwiftyJava] : arg1 in Compare(arg0, arg0StartIndex, arg1, arg1StartIndex, numOfCharsToCompare) is null.");
		}
		if(arg0StartIndex < 0) {
			throw new RuntimeException("[SwiftyJava] : arg0StartIndex is less than 0, cannot get substring when start index is < 0.");
		}
		if(arg1StartIndex < 0) {
			throw new RuntimeException("[SwiftyJava] : arg01StartIndex is less than 0, cannot get substring when start index is < 0.");
		}
		if(numOfCharsToCompare < 0) {
			throw new RuntimeException("[SwiftyJava] : numOfCharsToCompare is < 0. numOfCharsToCompare must be a positive integer");
		}
		if(numOfCharsToCompare > arg0.length()) {
			throw new RuntimeException("[SwiftyJava] : numOfCharsToCompare is greater than arg0.length(). Substring's index will be Out Of Range");
		}
		if(numOfCharsToCompare > arg1.length()) {
			throw new RuntimeException("[SwiftyJava] : numOfCharsToCompare is greater than arg1.length(). Substring's index will be Out Of Range");
		}
		
		if (ignoreCase) {
			arg0 = arg0.toLowerCase();
			arg1 = arg1.toLowerCase();
		}
		
		String arg0CharsToCompare = arg0.substring(arg0StartIndex, numOfCharsToCompare);
		String arg1CharsToCompare = arg1.substring(arg1StartIndex, numOfCharsToCompare);
		
		if(arg0CharsToCompare.length() < arg1CharsToCompare.length()) {
			return -1;
		}else if(arg0CharsToCompare == arg1CharsToCompare) {
			return 0;
		}else{
			return 1;
		}
	
	}
	
	//word count
	public int wordCount(String arg0) {
		String trim = arg0.trim();
	    if (trim.isEmpty())
	        return 0;
	    return trim.split("\\s+").length; // separate string around spaces
	}
	
	public ArrayList reverseArrayList(ArrayList arg0) {
		Collections.reverse(arg0);
		return arg0;
	}
	
	
	public String[] reverseArray(String[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        String temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public int[] reverseArray(int[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        int temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public double[] resverseArray(double[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        double temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public char[] reverseArray(char[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        char temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public short[] reverseArray(short[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        short temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public long[] reverseArray(long[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        long temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public boolean[] reverseArray(boolean[] r) {
		int l = r.length;
	    for (int j = 0; j < l / 2; j++)
	    {
	        boolean temp = r[j];
	        r[j] = r[l - j - 1];
	        r[l - j - 1] = temp;
	    }
	    
	    return r;
	}
	
	public void frog(String s) {
		
		String[] frog = {"  ",
		                 "          _,-.   ",
		                 "  ,-. ,--'  o )  ",
		                 "  \\(,' '  ,,-'  ",
		                 " ,-.\\-.__,\\\\_ ",
		                 " \\(`--'    `\\  ",
		                "  "};
		String dashes = "";
		
		for(int i = 0; i < s.length(); i++) {
			dashes += "-";
		}
		
		if(s.length() > 0 ) {  
		      frog[1] = frog[1] + "   ---" + ("-" + dashes + "-");
		      frog[2] = frog[2] + "-(   " + s + "   )";
		      frog[3] = frog[3] + "    ---" +  ("-" + dashes + "-");
		}
		
		for(int j = 0; j < frog.length; j++ ) {
		       print(frog[j]);
		}
		
		
	}
	
	
	
}
