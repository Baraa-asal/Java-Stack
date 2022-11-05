package com.abstractart;

import java.util.ArrayList;

public class Museum {

	public static void main(String[] args) {
		ArrayList<Art> museum = new ArrayList<Art>();

		Painting painting1 = new Painting("title1","author1","description1","paintType1");
		Painting painting2 = new Painting("title2","author2","description2","paintType2");
		Painting painting3 = new Painting("title3","author3","description3","paintType3");
		Sculpture sculpture1 = new Sculpture("title1","author1","description1","material1");
		Sculpture sculpture2 = new Sculpture("title2","author2","description2","material2");
		
		System.out.println("__________painting1: ___________");
		painting1.viewArt();
		System.out.println("__________painting2: ___________");
		painting2.viewArt();
		System.out.println("__________painting3: ___________");
		painting3.viewArt();
		System.out.println("__________sculpture1: ___________");
		sculpture1.viewArt();
		System.out.println("__________sculpture2: ___________");
		sculpture2.viewArt();
		
		museum.add(painting1);
		museum.add(painting2);
		museum.add(painting2);
		museum.add(sculpture1);
		museum.add(sculpture2);
		System.out.println(museum);
		//I tried to do the bonus but it doesnt print the arraylist
		for (int i = 0; i < museum.size(); i++) {
		      System.out.println(museum.get(i));
		    }
	}

}
