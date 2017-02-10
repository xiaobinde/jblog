package com.blog.rest.frontController;

import com.blog.common.bean.EasyUIResult;
import com.blog.pojo.Article;
import com.blog.rest.fontService.FrontService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhb on 2017/2/9.
 */
@RequestMapping("front/article")
@Controller
public class FrontArticleController {

    @Autowired
    private FrontService articleService;
    /**
     * 前端查询文章列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Article>> queryfrontArticleList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "30") Integer rows) {
        try {
            PageInfo<Article> pageInfo = this.articleService.queryPageList(page,rows);
            EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
            List<Article> list = (List<Article>) easyUIResult.getRows();
            List<Article> articlesList = new ArrayList<>();
            for (Article article : list){
                if (article.getIsindex() == 3)
                    articlesList.add(article);
            }

            if (null == pageInfo)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.ok(articlesList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 出错 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    /**
     * 根据商品id查询商品数据
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "{articleId}", method = RequestMethod.GET)
    public ResponseEntity<Article> queryById(@PathVariable("articleId") Long articleId) {
        try {
            Article item = this.articleService.queryById(articleId);
            if (null == item) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 出错 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
