package com.reviews.reviews;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;

public class ReviewRepositoryTest {

	
	@Resource
	private ReviewRepository underTest;
	private Review reviewOne = new Review(1L, "review name", "category", "description", "image");
	private Review reviewTwo = new Review(2L, "review name", "category", "description", "image");
	
	@Test
	public void shouldFindReviewById() {
		underTest = new ReviewRepository(reviewOne);
		Review foundReview = underTest.findReview(1L);
		assertThat(foundReview, is(reviewOne));
	}
	
	@Test
	public void shouldFindAllReviews() {
		underTest = new ReviewRepository(reviewOne, reviewTwo);
		Collection<Review> foundReviews = underTest.findAllReviews();
		assertThat(foundReviews, containsInAnyOrder(reviewOne, reviewTwo));
	}
}
