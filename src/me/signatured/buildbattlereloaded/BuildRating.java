package me.signatured.buildbattlereloaded;

import lombok.Getter;

@Getter
public enum BuildRating {
	
	SUPER_POOP("Super Poop", 1),
	POOP("Poop", 2),
	OKAY("Okay", 3),
	GOOD("Good", 4),
	GREAT("Great", 5),
	AMAZING("Amazing", 6),
	LEGENDARY("Legendary", 7);
	
	private String name;
	private int score;
	
	BuildRating(String name, int score) {
		this.name = name;
		this.score = score;
	}
}
