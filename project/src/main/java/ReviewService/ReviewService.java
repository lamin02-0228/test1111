package ReviewService;

import java.util.List;
import ReviewDTO.*;

public interface ReviewService {
    // ���� �߰�
    void addReview(ReviewDTO review);

    // Ư�� ���� ��ȸ
    ReviewDTO viewReview(String reviewWrite);

    // ��ü ���� ��� ��ȸ
    List<ReviewDTO> listReviews();

    // ���� ����
    void modifyReview(ReviewDTO review);

    //���� ����
    void removeReview(String reviewWrite);
}
