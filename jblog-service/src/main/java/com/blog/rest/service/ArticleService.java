package com.blog.rest.service;


import com.blog.mapper.ArticleMapper;
import com.blog.pojo.Article;
import com.blog.pojo.ArticleDesc;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by liuhb on 2017/2/7.
 */
@Service
public class ArticleService extends BaseService<Article> {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ArticleDescService articleDescService;

    public void saveItem(Article article, String desc) {
        // 设置初始数据
        article.setStatus(1);

        article.setId(null);// 强制设置id为null

        super.save(article);

        ArticleDesc articleDesc = new ArticleDesc();
        articleDesc.setArticleId(article.getId());
        articleDesc.setArticleDesc(desc);
        // 保存描述数据
        this.articleDescService.save(articleDesc);
    }

    public PageInfo<Article> queryPageList(Integer page, Integer rows) throws IOException {
        Example example = new Example(Article.class);
        example.setOrderByClause("updated DESC");
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<Article> list = this.articleMapper.selectByExample(example);
        return  new PageInfo<Article>(list);
    }

    public void updateArticle(Article article, String desc) {
        {
            // 强制设置不能修改的字段为null
            article.setStatus(null);
            article.setCreated(null);
            super.updateSelective(article);

            // 修改商品描述数据
            ArticleDesc articleDesc = new ArticleDesc();
            articleDesc.setArticleId(article.getId());
            articleDesc.setArticleDesc(desc);
            this.articleDescService.updateSelective(articleDesc);

            // 发送消息
//            sendMsg(item.getId(), "update");

        }
    }
}
