package nQueen;

import java.io.File;

public class Check {
	
	//We create jump table here to improve the performance
	private boolean isValid(byte temp) {
		switch (temp) {
			case 'a':
			case 'o':
			case 'i':
			case 'e':
			case 'u':
			case 'A':
			case 'O':
			case 'I':
			case 'E':
			case 'U':
				return true;
			default:
				return false;
		}

	}

	public int count(byte[] line) {
		int count = 0;
		for (byte temp : line) {
			if (isValid(temp)) {
				count ++;
			}
		}
		return count;
	}


	public int getSecond(File input) {
		input.open();
		String line = null;

	int most = 0;
	int second = 0;

	int index1 = -1;
	int index2 = -1; //This is the index of the second most 

		int lineNumber = 0;

		while ( (line = input.readLine()) != null ) {
			lineNumber++;
			int count = count (line.getBytes());
			
			//If it is larger or equal than most, we shift the variable
			if (count >= most) {
				int tempCount = most;
				int tempIndex = index1;

				most = count;
				index1 = lineNumber;

				second = tempCount;
				index2 = tempIndex;
			}
			
			//else if it is larger  or equal than second, we replace the variable 
	else if (count >= second) {
				second = count;
				index2 = lineNumber;
			}
			
		}

		input.close();
		return index2;
	}	

}
