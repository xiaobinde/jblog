package com.blog.admin.controller;

import com.blog.admin.service.ArticleCatService;
import com.blog.pojo.ArticleCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by liuhaibin on 06/02/2017.
 */
@RequestMapping("admin/article/cat")
@Controller
public class ArticleCatController {

    @Autowired
    private ArticleCatService articleCatService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ArticleCat>> queryAeticleCatListByParentId(
            @RequestParam(value = "id",defaultValue = "0")long parentId){
        try {
            List<ArticleCat> list = this.articleCatService.queryListByParentId(parentId);
            if (null == list || list.isEmpty())
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            return ResponseEntity.ok(list);
        }catch (Exception e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
