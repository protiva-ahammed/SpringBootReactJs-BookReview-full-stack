package com.bookReview.bookReview.Service;

import com.bookReview.bookReview.Repository.ReviewRepository;
import com.bookReview.bookReview.entity.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{


    @Autowired
    private ReviewRepository reviewRepository;


    @Override
    public List<ReviewEntity> readAll() {
        return reviewRepository.findAll();
    }

    @Override
    public ReviewEntity saveReview(ReviewEntity reviewEntity) {
         return reviewRepository.save(reviewEntity);
    }

    @Override
    //reading the id
    public ReviewEntity readReview(Long id) {
        ReviewEntity reviewEntity1 = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review is not present for the  book with id " + id));
        return reviewEntity1;
    }

    @Override
    public void removeReview(Long id) {
        ReviewEntity existingReview = readReview(id);//readReview is going  to help us in returning error msg also
        reviewRepository.delete(existingReview);
    }


}
