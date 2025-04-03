package ReviewService;

import java.util.List;
import ReviewDTO.*;

public interface ReviewService {
    // 리뷰 추가
    void addReview(ReviewDTO review);

    // 특정 리뷰 조회
    ReviewDTO viewReview(String reviewWrite);

    // 전체 리뷰 목록 조회
    List<ReviewDTO> listReviews();

    // 리뷰 수정
    void modifyReview(ReviewDTO review);

    //리뷰 제거
    void removeReview(String reviewWrite);
}
