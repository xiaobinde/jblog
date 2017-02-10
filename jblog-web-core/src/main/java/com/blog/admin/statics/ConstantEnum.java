package com.blog.admin.statics;

/**
 * Created by liuhaibin on 08/01/2017.
 */
public enum ConstantEnum {
    CONTEXT_PATH("contextPath");/**项目根目录*/

    private String constant;

    ConstantEnum(String constant){
        this.constant = constant;
    }

    public String getValue(){
        return constant;
    }
}
