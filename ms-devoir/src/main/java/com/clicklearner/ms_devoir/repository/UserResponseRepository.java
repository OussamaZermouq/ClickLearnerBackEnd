package com.clicklearner.ms_devoir.repository;

import com.clicklearner.ms_devoir.model.UserResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserResponseRepository extends JpaRepository<UserResponse, Integer> {

    //select * from user_response where user_id=? and question_question_id in (select question_id from question where devoir_devoir_id=?);
    @Query("select ur from UserResponse ur where ur.userId=?1 and ur.question.questionId in (select q.questionId from Question q where q.devoir.devoirId=?2)")
    Optional<List<UserResponse>> findUserresponseByDevoirId(int userId, int devoirId);
}
