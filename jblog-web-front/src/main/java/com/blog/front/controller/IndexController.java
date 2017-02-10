package com.blog.front.controller;

import com.blog.front.service.IndexService;
import com.blog.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhb on 2017/2/8.
 */

@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;
    @RequestMapping("index")
    public String index(Model model,
                        @RequestParam(value = "page", defaultValue = "1") Integer page,
                        @RequestParam(value = "rows", defaultValue = "5") Integer rows){
        List<Article> articleListAll = indexService.quaryArticleList(page,rows);
        if (null == articleListAll)
            return "frontindex";
        List<Article> articleList = new ArrayList<Article>();
        List<Article> bookList = new ArrayList<Article>();
        List<Article> newList = new ArrayList<Article>();
        for (Article article :articleListAll){
            if (article.getIsindex() == 1)
                bookList.add(article);
            else if (article.getIsindex() ==2)
                newList.add(article);
            else
                articleList.add(article);
        }
        model.addAttribute("articleList",articleList);
        model.addAttribute("bookList",bookList);
        model.addAttribute("newList",articleList.size() > 5 ? articleList.subList(0,5):articleList);
        return "frontindex";
    }
}
