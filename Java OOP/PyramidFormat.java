package javaCorDev;

public class PyramidFormat {

	public static void main(String[] args) {

		new PyramidFormat().pyramidFormat("Epam University");

	}

	// The method outputs a string in a pyramid format
	public void pyramidFormat(String inputedString) {
		for (int i = 0; i < inputedString.length(); i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(inputedString.charAt(j));
			}
			System.out.println();
		}
	}

}
