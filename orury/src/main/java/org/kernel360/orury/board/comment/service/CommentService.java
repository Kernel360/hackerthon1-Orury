package org.kernel360.orury.board.comment.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.comment.repository.CommentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository repository;
}
