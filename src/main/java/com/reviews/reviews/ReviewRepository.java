package com.reviews.reviews;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {

	private Map<Long, Review> reviewList = new HashMap<>();
	private Review reviewOne = new Review(1L, "Castlevania 2", "video games", "Castlevania 2 is an unserstated game, and the first foray of the series into the Metroidvania territory. Including an open world format, inventory, and a rudimentary leveling system. Unfortunately this was ahead of the time for the series, and the third installment adopted a format very close to the original game.", "Castlevania-2.jpg");
	private Review reviewTwo = new Review(2L, "The Legend of Zelda: Majora's Mask", "video games", "An improvement over Ocarina of Time. Having a more complete overworld, and unique format for the series. Over a three day cycle you will need to complete dungeons and side quests utilizing both collected items and unique powers of the many masks you can collect throughout the game. Quests may require more complex and unique solutions than other games. With time becoming a major factor. Requiring you to learn the schedules of different characters in order to solve their problems.", "Majora's_Mask_Box_Art.jpg");
	private Review reviewThree = new Review(3L, "This site", "websites", "This review site is definately a disappointment compared ot other review sites. I am not quite sure what the original intent was, but with only two other reviews it appears destitute. The only saving grace is that at least someone recognizes the best N64 Zelda.", "confused.png");

	public ReviewRepository() {
		reviewList.put(reviewOne.getId(), reviewOne);
		reviewList.put(reviewTwo.getId(), reviewTwo);
		reviewList.put(reviewThree.getId(), reviewThree);
	}

	// uses varargs for testing purpose to take on the necessary reviews
	public ReviewRepository(Review... reviews) {
		for (Review review : reviews) {
			reviewList.put(review.getId(), review);
		}

	}

	public Review findReview(long id) {
		return reviewList.get(id);
	}

	public Collection<Review> findAllReviews() {
		return reviewList.values();
	}
}
