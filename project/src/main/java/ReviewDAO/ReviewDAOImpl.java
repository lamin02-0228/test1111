package ReviewDAO;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ReviewDTO.ReviewDTO;

@Repository
public class ReviewDAOImpl implements ReviewDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String NAMESPACE = "mapper.review";

    
    @Override
    public void insertReview(ReviewDTO review) {
        sqlSession.insert(NAMESPACE + ".insertReview", review);
    }

    
    @Override
    public ReviewDTO getReview(String reviewWrite) {
        return sqlSession.selectOne(NAMESPACE + ".getReview", reviewWrite);
    }

    
    @Override
    public List<ReviewDTO> getAllReviews() {
        return sqlSession.selectList(NAMESPACE + ".getAllReviews");
    }

   
    @Override
    public void updateReview(ReviewDTO review) {
        sqlSession.update(NAMESPACE + ".updateReview", review);
    }

    
    @Override
    public void deleteReview(String reviewWrite) {
        sqlSession.delete(NAMESPACE + ".deleteReview", reviewWrite);
    }
}
