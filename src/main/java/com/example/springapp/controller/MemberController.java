package com.example.springapp.controller;

import com.example.springapp.model.Member;
import com.example.springapp.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<List<Member>> getMembersByPage(@PathVariable int page, @PathVariable int size) {
        return ResponseEntity.ok(memberService.getMembersByPage(page, size));
    }

    @PostMapping
    public ResponseEntity<Member> create(@RequestBody Member member) {
        return ResponseEntity.status(HttpStatus.CREATED).body(memberService.create(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable int id) {
        return memberService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable int id, @RequestBody Member member) {
        return ResponseEntity.ok(memberService.update(id, member));
    }
}