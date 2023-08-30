package me.ktony.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.ktony.springbootdeveloper.domain.Article;
import me.ktony.springbootdeveloper.dto.AddArticleRequest;
import me.ktony.springbootdeveloper.dto.UpdateArticleRequest;
import me.ktony.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll() {
        return blogRepository.findAll();
    }

    public Article findById(Long id) {
        return blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("not found: " + id)
        );
    }

    public void delete(Long id) {
        blogRepository.deleteById(id);
    }

    @Transactional
    public Article update(Long id, UpdateArticleRequest request) {
        Article article = blogRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found: " + id));

        // update 로직을 article domain에 위임했네?
        article.update(request.getTitle(), request.getContent());

        return article;
    }

}
