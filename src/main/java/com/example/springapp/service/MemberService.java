package com.example.springapp.service;

import com.example.springapp.model.Member;
import com.example.springapp.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepo;

    public MemberService(MemberRepository memberRepo) {
        this.memberRepo = memberRepo;
    }

    public List<Member> getMembersByPage(int page, int size) {
        Page<Member> paged = memberRepo.findAll(PageRequest.of(page, size));
        return paged.getContent();
    }

    public Member create(Member member) {
        return memberRepo.save(member);
    }

    public Optional<Member> getById(int id) {
        return memberRepo.findById(id);
    }

    public Member update(int id, Member member) {
        member.setId(id);
        return memberRepo.save(member);
    }
}