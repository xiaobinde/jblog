package com.blog.rest.fontService;

import com.blog.mapper.ArticleMapper;
import com.blog.pojo.Article;
import com.blog.rest.service.BaseService;
import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuhb on 2017/2/9.
 */
@Service
public class FrontIndexService extends BaseService<Article>{
    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> queryPageList(Integer page, Integer rows) throws IOException {
        List<Object> values = new ArrayList<Object>();
        values.add(1);
        values.add(2);
        Example examplebook = new Example(Article.class);
        examplebook.createCriteria().andIn("isindex",values);
        examplebook.setOrderByClause("updated DESC");
        List<Article> booklist = this.articleMapper.selectByExample(examplebook);

        Example example = new Example(Article.class);
        example.createCriteria().andNotIn("isindex",values);
        example.setOrderByClause("updated DESC");

        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<Article> articlelist = this.articleMapper.selectByExample(example);

        List<Article> articlelistAll = new ArrayList<Article>();
        articlelistAll.addAll(booklist);
        articlelistAll.addAll(articlelist);

        return  articlelistAll;
    }
}
