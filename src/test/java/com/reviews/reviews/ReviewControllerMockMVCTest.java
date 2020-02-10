package com.reviews.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(ReviewController.class)
public class ReviewControllerMockMVCTest {

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private Review reviewOne;

	@MockBean
	private ReviewRepository reviewRepo;

	@Test
	public void shouldGetStatusOkWhenNavigatingToAllReviews() throws Exception {
		this.mockMvc.perform(get("/show-reviews")).andExpect(status().isOk())
		.andExpect(view().name("reviews-template"));

	}

	@Test
	public void shouldGetStatusOkWhenNavigatingToReviewOne() throws Exception {
		this.mockMvc.perform(get("/show-review")).andExpect(status().isOk())
		.andExpect(view().name("review-template"));
	}
	
	@Test
	public void shouldAddAllReviewsToModel() throws Exception {
		this.mockMvc.perform(get("/show-reviews"))
		.andExpect(model().attribute("reviewsModel", hasSize(2)));
	}
	
	@Test
	public void shouldAddSingleReviewToModel() throws Exception {
		this.mockMvc.perform(get("/show-review"))
		.andExpect(model().attribute("reviewModel", is(reviewOne)));
	}
	
	@Test
	public void shouldReturnNotFoundStatusForBadRequest() throws Exception {
		Long badId = 5L;
		when(reviewRepo.findReview(badId)).thenReturn(null);
		this.mockMvc.perform(get("/show-review"))
		.andExpect(status().isNotFound());
	}
}
