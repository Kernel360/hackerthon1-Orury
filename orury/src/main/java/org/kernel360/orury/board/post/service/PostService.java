package org.kernel360.orury.board.post.service;

import lombok.RequiredArgsConstructor;
import org.kernel360.orury.board.post.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository repository;
}