package ReviewController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import ReviewDTO.ReviewDTO;
import ReviewService.ReviewService;

@org.springframework.stereotype.Controller
@RequestMapping("/reviews")
public class Controller {

    @Autowired
    private ReviewService reviewService;

    
    @RequestMapping("/add")
    public String addReview(@ModelAttribute ReviewDTO review) {
        reviewService.addReview(review);
        return "reviewlist.jsp";
    }

    
    @RequestMapping("/view/{reviewWrite}")
    public String viewReview(@PathVariable String reviewWrite, Model model) {
        ReviewDTO review = reviewService.viewReview(reviewWrite);
        model.addAttribute("review", review);
        return "reviewwriter.jsp"; // JSP ÆÄÀÏ¸í
    }

    
    @RequestMapping("/list")
    public String listReviews(Model model) {
        List<ReviewDTO> reviews = reviewService.listReviews();
        model.addAttribute("reviews", reviews);
        return "reviewlist.jsp"; 
    }

    
    @RequestMapping("/modify")
    public String modifyReview(@ModelAttribute ReviewDTO review) {
        reviewService.modifyReview(review);
        return "reviewwriter.jsp";
    }

    
    @RequestMapping("/delete/{reviewWrite}")
    public String deleteReview(@PathVariable String reviewWrite) {
        reviewService.removeReview(reviewWrite);
        return "reviewwriter.jsp";
    }
}
