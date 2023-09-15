package com.bookReview.bookReview.Service;

import com.bookReview.bookReview.entity.ReviewEntity;

import java.util.List;

public interface ReviewService {


    List<ReviewEntity> readAll();
    ReviewEntity saveReview(ReviewEntity reviewEntity);

    ReviewEntity readReview(Long id);

    void removeReview(Long id);

//    ReviewEntity updateReview(ReviewEntity reviewEntity);
}
