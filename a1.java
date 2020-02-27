//Robiul	Alam 
//id#	23419382
//CISC 3130
//spring	2020
//submission of date: February 25, 2020

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class a1

{
	
	public static void main(String[] args) throws Exception {
		Scanner file = new Scanner(new File("C:/Users/robiu/OneDrive/Desktop/cis3130/a1.csv"));
		String[][] songs = a1.readFileAndGetSongs();
		a1.insert(songs);

	}
	
	String[][] songs;

	public static String[][] readFileAndGetSongs() {
		try {
			Scanner file = new Scanner(new File("C:/Users/robiu/OneDrive/Desktop/cis3130/a1.csv"));
         int rows = 200, columns = 5;
			String[][] songs = new String[rows][columns];
			songs = input(file, rows, columns, songs);
			return songs;
		}

		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new String[0][0];
	}

	public static String[][] input(Scanner file, int rows, int columns, String[][] songs) {
		songs = new String[rows][columns];
		file.nextLine();
		file.nextLine();
		for (int i = 0; i < rows; i++) {
			String line = file.nextLine();
			String split[] = line.split(",");
			if(!file.hasNextLine()) {
				break;
			}
			for (int j = 0; j < columns; j++) {
				songs[i][j] = split[j];
			}
		}
		return sortArray(songs);
	}

	public static void printArray(String[][] songs) {
		for (int i = 0; i < songs.length; i++) {
			for (int j = 0; j < songs[i].length; j++) {
				System.out.print(songs[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static String[][] sortArray(String[][] songs) {
		for (int i = 0; i < songs.length; i++) {
			for (int j = i + 1; j < songs.length - 1; j++) {
				String[] curr = songs[i];
				String[] next = songs[j];
				String currArtistName = curr[2];
				String nextArtistName = next[2];
				if (currArtistName.compareTo(nextArtistName) > 0) {
					songs[j] = curr;
					songs[i] = next;
				}
			}
		}

		printArray(songs);
		return songs;
	}
	
	public static LinkedList<String> ordered = new LinkedList<String>();

	public static LinkedList<String> insert(String[][] songs) {
		for (int i = 0; i < songs.length; i++) {
			for (int j = 0; j < songs[i].length; j++) {
				ordered.add(songs[i][j]);
			}
		}
		System.out.println(ordered);
		return ordered;
	}

	public static void printList(LinkedList<String> ordered) {
		for (int i = 0; i < ordered.size(); i++) {
			System.out.println(ordered.get(i));
		}
	}

}