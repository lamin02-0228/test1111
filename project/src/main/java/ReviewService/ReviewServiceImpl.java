package ReviewService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ReviewDAO.ReviewDAO;
import ReviewDTO.ReviewDTO;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewDAO reviewDAO;

    // 리뷰 추가
    @Override
    public void addReview(ReviewDTO review) {
        reviewDAO.insertReview(review);
    }

    // 특정 리뷰 조회
    @Override
    public ReviewDTO viewReview(String reviewWrite) {
        return reviewDAO.getReview(reviewWrite);
    }

    // 전체 리뷰 목록 조회
    @Override
    public List<ReviewDTO> listReviews() {
        return reviewDAO.getAllReviews();
    }

    // 리뷰 수정
    @Override
    public void modifyReview(ReviewDTO review) {
        reviewDAO.updateReview(review);
    }

    // 리뷰 삭제
    @Override
    public void removeReview(String reviewWrite) {
        reviewDAO.deleteReview(reviewWrite);
    }
}
