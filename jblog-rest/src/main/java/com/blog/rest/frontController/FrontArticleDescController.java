package com.blog.rest.frontController;

import com.blog.pojo.ArticleDesc;
import com.blog.rest.service.ArticleDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by liuhb on 2017/2/9.
 */
@RequestMapping("front/article/desc")
@Controller
public class FrontArticleDescController {

    @Autowired
    private ArticleDescService articleDescService;
    /**
     * 根据商品id查询商品描述数据
     *
     * @param articleId
     * @return
     */
    @RequestMapping(value = "{articleId}", method = RequestMethod.GET)
    public ResponseEntity<ArticleDesc> queryByItemId(@PathVariable("articleId")Long articleId){
        try {
            ArticleDesc itemDesc = this.articleDescService.queryById(articleId);
            if(null == itemDesc){
                //资源不存在，404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            // 200
            return ResponseEntity.ok(itemDesc);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //错误，500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
