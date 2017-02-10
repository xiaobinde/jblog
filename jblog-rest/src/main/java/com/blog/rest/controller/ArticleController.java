package com.blog.rest.controller;

import com.blog.common.bean.EasyUIResult;
import com.blog.common.utils.LoggerUtils;
import com.blog.common.utils.StringUtils;
import com.blog.pojo.Article;
import com.blog.rest.service.ArticleService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liuhb on 2017/2/7.
 */
@RequestMapping("admin/article")
@Controller
public class ArticleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleController.class);
    @Autowired
    private ArticleService articleService;

    /**
     * 新增
     * @param article
     * @param desc
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveArticle(Article article,String desc){
        try{
            LOGGER.info("新增商品， item = {}, desc = {}", article, desc);

            if (StringUtils.isEmpty(article.getTitle())) {
                // 响应400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            // 保存商品的基本数据
            this.articleService.saveItem(article, desc);
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("新增商品成功， itemId = {}", article.getId());
            }
            // 成功 201
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            LOGGER.error("新增商品失败! title = " + article.getTitle() + ", cid = " + article.getCid(), e);
        }
        // 出错 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * admin查询文章列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<EasyUIResult> queryArticleList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "30") Integer rows) {
        try {
            PageInfo<Article> pageInfo = this.articleService.queryPageList(page,rows);
            EasyUIResult easyUIResult = new EasyUIResult(pageInfo.getTotal(), pageInfo.getList());
            if (null == pageInfo)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.ok(easyUIResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 出错 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }



    /**
     * 修改文章信息
     *
     * @param article
     * @param desc
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<Void> updateItem(Article article, @RequestParam("desc") String desc) {
        try {
            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("修改商品， item = {}, desc = {}", article, desc);
            }
            if (StringUtils.isEmpty(article.getTitle())) {
                // 响应400
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }

            this.articleService.updateArticle(article, desc);

            if (LOGGER.isInfoEnabled()) {
                LOGGER.info("修改商品成功， itemId = {}", article.getId());
            }
            // 成功 204
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            LOGGER.error("修改商品失败! title = " + article.getTitle() + ", cid = " + article.getCid(), e);
        }
        // 出错 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
