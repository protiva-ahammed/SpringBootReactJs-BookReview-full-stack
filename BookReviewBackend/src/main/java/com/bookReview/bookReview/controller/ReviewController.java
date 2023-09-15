package com.bookReview.bookReview.controller;
import com.bookReview.bookReview.Service.ReviewService;
import com.bookReview.bookReview.entity.ReviewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")//to say any port values are going to be accessed
@RestController
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review")
    public List<ReviewEntity>getReview(){
        return reviewService.readAll();

    }
    @Value("${app.version}")
    private String version;

    @GetMapping("/version")
    public String getVersion(){
        return "Application is up and running with  " + version;
    }

    @PostMapping("/save-review")
    public ReviewEntity saveReview(@RequestBody ReviewEntity reviewEntity){
        return reviewService.saveReview(reviewEntity);
    }

    @GetMapping("review/{id}")
    public ReviewEntity getReview(@PathVariable Long id){
        return reviewService.readReview(id);
    }

    @DeleteMapping("review/{id}")
    public ResponseEntity<HttpStatus> removeReview(@PathVariable Long id){
            reviewService.removeReview(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/review")
    public ReviewEntity updateReview(@RequestBody ReviewEntity reviewEntity){
            return reviewService.saveReview(reviewEntity);
    }
}
