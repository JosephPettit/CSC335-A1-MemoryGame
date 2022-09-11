package assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardImages {

	// Static so it can be accessed from the welcome game options window in UI.
	private static final String[] deckNames = new String[] {"Power Rangers", "Fruits"};
	
	private String backOfCards = "blank.jpg";
	private String[] imagesArray;
	private List<String> randomList;

	CardImages(int selection){	
		switch (selection) {
			case 0: imagesArray = new String[] {"apple.jpg","avocado.jpg", "pear.jpg", "peach.jpg", "pineapple.jpg", 
												"apple.jpg","avocado.jpg", "pear.jpg", "peach.jpg", "pineapple.jpg"};
			
			case 1: imagesArray = new String[] {"apple.jpg","avocado.jpg", "pear.jpg", "peach.jpg", "pineapple.jpg",
												"apple.jpg","avocado.jpg", "pear.jpg", "peach.jpg", "pineapple.jpg"}; 
		}
	}

	public static String[] getDecknames() {
		return deckNames;
	}

	public String[] getImagesArray() {
		randomList = Arrays.asList(imagesArray);
		Collections.shuffle(randomList);
		String[] randomArray = new String[randomList.size()];
		randomArray = randomList.toArray(String[]::new);
		return randomArray;
	}

	public String getBackOfCards() {
		return backOfCards;
	}
	
	
}
