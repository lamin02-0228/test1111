package ReviewDAO;

import java.util.List;
import ReviewDTO.ReviewDTO;

public interface ReviewDAO {
    void insertReview(ReviewDTO review);
    ReviewDTO getReview(String reviewWrite);
    List<ReviewDTO> getAllReviews();
    void updateReview(ReviewDTO review);
    void deleteReview(String reviewWrite);
}
