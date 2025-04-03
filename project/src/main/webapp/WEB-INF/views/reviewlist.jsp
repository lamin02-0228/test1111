<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, java.util.ArrayList, java.util.Arrays" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>리뷰 리스트</title>
    <style>
        .container { width: 80%; margin: auto; text-align: center; }
        .search-container { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        .search-box { width: 200px; padding: 10px; border: 1px solid #ddd; border-radius: 5px; }
        .write-review-btn { padding: 10px 15px; background: #28a745; color: white; border: none; border-radius: 5px; cursor: pointer; }
        .write-review-btn:hover { background: #218838; }
        .thumbnail-list { display: flex; flex-wrap: wrap; justify-content: center; margin-top: 20px; }
        .thumbnail { width: 250px; margin: 10px; border: 1px solid #ddd; border-radius: 10px; overflow: hidden; text-align: center; }
        .thumbnail img { width: 100%; height: 150px; object-fit: cover; }
        .thumbnail h3 { margin: 10px 0; font-size: 16px; }
        .thumbnail p { margin: 5px 0; font-size: 14px; color: gray; }
        .btn { display: block; padding: 10px; background: #007bff; color: white; text-decoration: none; border-radius: 5px; margin: 10px; text-align: center; }
        .btn:hover { background: #0056b3; }
    </style>
</head>
<body>

<div class="container">
    <!-- 검색창과 리뷰쓰기 버튼 -->
    <div class="search-container">
        <input type="text" id="searchBox" class="search-box" placeholder="리뷰 검색" onkeyup="searchReviews()">
        <button class="write-review-btn" onclick="location.href='writeReview.jsp'">리뷰 쓰기</button>
    </div>
<% 
    List<Review> reviews = new ArrayList<>();
String[][] reviewData = {
    {"1", "강원도의 아름다운 풍경", "2024-04-01", "90", "강원도.jpg"},
    {"2", "부산 해운대 여행기", "2024-03-28", "87", "부산.jpg"},
    {"3", "전주의 한옥마을 후기", "2024-03-25", "59", "전주.jpg"}
};

// 배열 데이터를 Review 객체로 변환하여 리스트에 추가
for (String[] review : reviewData) {  
    if (review.length >= 5) {  
        int views = Integer.parseInt(review[3]); // 조회수를 int로 변환
        reviews.add(new reviewlist(review[0], review[1], review[2], views, review[4]));

        
    } else {
        System.err.println("데이터가 누락된 리뷰 발견: " + Arrays.toString(review));
    }
}
    %>

    <h2>리뷰 목록</h2>
    <div class="thumbnail-list">
        <c:forEach var="review" items="${reviews}">
            <div class="thumbnail">
                <a href="reviewDetail.jsp?reviewId=${review.id}">
                    <img src="images/${review.image}" alt="리뷰 이미지">
                </a>
                <h3>${review.title}</h3>
                <p>작성일: ${review.date}</p>
                <p>조회수: ${review.views}</p>
                <a href="reviewDetail.jsp?reviewId=${review.id}" class="btn">자세히 보기</a>
            </div>
        </c:forEach>
    </div>
</div>

</body>
</html>
