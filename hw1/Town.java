package edu.iastate.cs228.hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


/**
 *  @author Josh Hall
 *
 */
public class Town {
	
	private int length, width;  //Row and col (first and second indices)
	public TownCell[][] grid;
	
	/**
	 * Constructor to be used when user wants to generate grid randomly, with the given seed.
	 * This constructor does not populate each cell of the grid (but should assign a 2D array to it).
	 * @param length
	 * @param width
	 */
	public Town(int length, int width) {
		this.length = length;
		this.width = width;
		this.grid =  new TownCell[length][width];
	}
	
	/**
	 * Constructor to be used when user wants to populate grid based on a file.
	 * Please see that it simple throws FileNotFoundException exception instead of catching it.
	 * Ensure that you close any resources (like file or scanner) which is opened in this function.
	 * @param inputFileName
	 * @throws FileNotFoundException
	 */
	public Town(String inputFileName) throws FileNotFoundException {
		File file = new File(inputFileName);
		Scanner inputFile = new Scanner(file);
		int lineCount = 0;
		while(inputFile.hasNextLine()) {
			String line = inputFile.nextLine();
			String[] list = line.split(" ");
			if (lineCount == 0) {
				this.length = Integer.parseInt(list[0]);
				this.width = Integer.parseInt(list[1]);
				this.grid = new TownCell[length][width];
			}
			else {
				for(int i = lineCount - 1; i < lineCount; i++) {
					for(int j = 0; j < this.width; j++) {
						list[j] = list[j].replace("\t", "");
						switch(list[j]) {
						case "R":
							grid[i][j] = new Reseller(this, i, j); break;
						case "E":
							grid[i][j] = new Empty(this, i, j); break;
						case "C":
							grid[i][j] = new Casual(this, i, j); break;
						case "O":
							grid[i][j] = new Outage(this, i, j); break;
						case "S":
							grid[i][j] = new Streamer(this, i, j); break;
						}
					}
				}
			}
			lineCount++;
		}
		inputFile.close();
	}
	
	/**
	 * Returns width of the grid.
	 * @return
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Returns length of the grid.
	 * @return
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Initialize the grid by randomly assigning cell with one of the following class object:
	 * Casual, Empty, Outage, Reseller OR Streamer
	 */
	public void randomInit(int seed) {
		
		Random rand = new Random(seed);
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < this.width; j++) {
				int newRandomValue = rand.nextInt(5);
				switch(newRandomValue) {
				case 0:
					grid[i][j] = new Reseller(this, i, j); break;
				case 1:
					grid[i][j] = new Empty(this, i, j); break;
				case 2:
					grid[i][j] = new Casual(this, i, j); break;
				case 3:
					grid[i][j] = new Outage(this, i, j); break;
				case 4:
					grid[i][j] = new Streamer(this, i, j); break;
				}
			}
		}
	}
	
	/**
	 * Output the town grid. For each square, output the first letter of the cell type.
	 * Each letter should be separated either by a single space or a tab.
	 * And each row should be in a new line. There should not be any extra line between 
	 * the rows.
	 */
	@Override
	public String toString() {
		String s = "";
		for(int i = 0; i < this.length; i++) {
			for(int j = 0; j < this.width; j++) {
				String customer = grid[i][j].who().name(); 
				s += customer.charAt(0) + " ";
			}
			s += "\n";
		}
		return s;
	}
}
