package me.ktony.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.ktony.springbootdeveloper.domain.Article;
import me.ktony.springbootdeveloper.dto.AddArticleRequest;
import me.ktony.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

}
