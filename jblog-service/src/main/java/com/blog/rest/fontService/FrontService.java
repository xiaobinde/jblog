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
import java.util.List;

/**
 * Created by liuhb on 2017/2/9.
 */
@Service
public class FrontService extends BaseService<Article>{
    @Autowired
    private ArticleMapper articleMapper;

    public PageInfo<Article> queryPageList(Integer page, Integer rows) throws IOException {
        Example example = new Example(Article.class);
        example.setOrderByClause("updated DESC");
        // 设置分页参数
        PageHelper.startPage(page, rows);
        List<Article> list = this.articleMapper.selectByExample(example);

        return  new PageInfo<Article>(list);
    }
}
