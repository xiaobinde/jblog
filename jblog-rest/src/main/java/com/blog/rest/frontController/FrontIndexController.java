package com.blog.rest.frontController;

import com.blog.common.bean.EasyUIResult;
import com.blog.pojo.Article;
import com.blog.rest.fontService.FrontIndexService;
import com.blog.rest.fontService.FrontService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liuhb on 2017/2/9.
 */
@RequestMapping(value = "front/index")
@Controller
public class FrontIndexController {
    @Autowired
    private FrontIndexService indexService;
    /**
     * 前端查询文章列表
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Article>> queryfrontArticleList(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "10") Integer rows) {
        try {
            List<Article> list = this.indexService.queryPageList(page,rows);
            if (null == list)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 出错 500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
