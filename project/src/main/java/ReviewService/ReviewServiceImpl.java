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

    // ���� �߰�
    @Override
    public void addReview(ReviewDTO review) {
        reviewDAO.insertReview(review);
    }

    // Ư�� ���� ��ȸ
    @Override
    public ReviewDTO viewReview(String reviewWrite) {
        return reviewDAO.getReview(reviewWrite);
    }

    // ��ü ���� ��� ��ȸ
    @Override
    public List<ReviewDTO> listReviews() {
        return reviewDAO.getAllReviews();
    }

    // ���� ����
    @Override
    public void modifyReview(ReviewDTO review) {
        reviewDAO.updateReview(review);
    }

    // ���� ����
    @Override
    public void removeReview(String reviewWrite) {
        reviewDAO.deleteReview(reviewWrite);
    }
}
