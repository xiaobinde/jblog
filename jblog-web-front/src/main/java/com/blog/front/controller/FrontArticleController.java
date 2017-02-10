package com.blog.front.controller;

import com.blog.common.bean.EasyUIResult;
import com.blog.front.service.FrontArticleService;
import com.blog.pojo.Article;
import com.blog.pojo.ArticleDesc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhb on 2017/2/9.
 */

@Controller
public class FrontArticleController {

    @Autowired
    private FrontArticleService articleService;
    /**
     * 查询文章列表
     *
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping(value = "newlist",method = RequestMethod.GET)
    public String queryItemList(Model model,
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "30") Integer rows) {
            List<Article> articleList = this.articleService.quaryArticleList(page, rows);
            model.addAttribute("articleList",articleList);
             List<Article> newArticleList = new ArrayList<Article>();
            if (articleList.size() > 5) {
                newArticleList = articleList.subList(0, 5);
            }else {
                newArticleList = articleList;
            }
            model.addAttribute("newArticleList",newArticleList);
            return "newlist";
    }


    @RequestMapping(value = "new/{articleId}", method = RequestMethod.GET)
    public String showDetail(Model model, @PathVariable("articleId") Long articleId) {
        //基本数据
        Article article = this.articleService.queryItemById(articleId);
        model.addAttribute("article",article);
        //描述数据
        ArticleDesc articleDesc = this.articleService.queryItemDescByItemId(articleId);
        model.addAttribute("articleDesc",articleDesc);

        return "new";
    }
}
