package com.eception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.MissingResourceException;

public class MyClass {

	public static void main(String[] args) {
		MyClass myClass1 = new MyClass();
		MyClass myClass2 = null;
		printException(myClass1, myClass2);
	}

	private static void printException(MyClass myClass1, MyClass myClass2) {
		try {
			myClass1.callit();
			myClass2.callit();
		} catch (Exception e) {
			System.out.println(e.getCause().getCause().getCause().getCause().getCause().getCause().getCause().getCause()
					.getMessage());
		}

	}

	private void callit() throws Exception {
		System.out.println("Kalu bhaiya");
		Exception e1 = null;
		try {
			throw new IOException();
		} catch (IOException | RuntimeException e) {
			e = new RuntimeException(); // DOES NOT COMPILE
		}
	}

	public void doesNotCompile() { // METHOD DOES NOT COMPILE
	 try {
	 mightThrow();
	 } catch (FileNotFoundException | IllegalStateException e) {
	 } catch (InputMismatchException e | MissingResourceException e) {
	 } catch (SQLException | ArrayIndexOutOfBoundsException e) {
	 } catch (FileNotFoundException | IllegalArgumentException e) {
	 } catch (Exception e) {
	 } catch (IOException e) {
	 }
	 }

	private void mightThrow() throws DateTimeParseException, IOException {
	}
}
