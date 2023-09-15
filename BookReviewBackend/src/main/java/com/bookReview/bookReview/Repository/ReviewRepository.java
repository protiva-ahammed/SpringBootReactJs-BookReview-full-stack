package com.bookReview.bookReview.Repository;
import com.bookReview.bookReview.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewEntity,Long>{
}
