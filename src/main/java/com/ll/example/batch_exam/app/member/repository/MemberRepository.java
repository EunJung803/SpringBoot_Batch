package com.ll.example.batch_exam.app.member.repository;

import com.ll.example.batch_exam.app.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}