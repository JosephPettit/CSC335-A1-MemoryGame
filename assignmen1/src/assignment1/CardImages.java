package assignment1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CardImages {

	// Static so it can be accessed from the welcome game options window in UI.
	private static final String[] deckNames = new String[] { "Power Rangers", "Fruits" };

	private String backOfCards;
	private String[] imagesArray;
	private List<String> randomList;

	CardImages(int selection) {
		switch (selection) {
			case 0 -> {
			imagesArray = new String[] {
					"blackRanger.jpg", "redRanger.jpg", "blueRanger.jpg", "pinkRanger.jpg", "yellowRanger.jpg",
					"blackRanger.jpg", "redRanger.jpg", "blueRanger.jpg", "pinkRanger.jpg", "yellowRanger.jpg"};
			backOfCards = "powerRangersLogo.jpg";
			}

			case 1 -> {
			imagesArray = new String[] { "apple.jpg", "avocado.jpg", "pear.jpg", "peach.jpg", "pineapple.jpg",
					"apple.jpg", "avocado.jpg", "pear.jpg", "peach.jpg", "pineapple.jpg" };
			backOfCards = "blank.jpg";
			}
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
