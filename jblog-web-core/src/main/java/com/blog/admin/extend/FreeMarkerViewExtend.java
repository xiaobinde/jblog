package com.blog.admin.extend;

import com.blog.admin.statics.ConstantEnum;
import com.blog.common.utils.LoggerUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by liuhaibin on 07/01/2017.
 */
public class FreeMarkerViewExtend extends FreeMarkerView {

    @Override
    protected void exposeHelpers(Map<String, Object> model, HttpServletRequest request) throws Exception {
        try {
            super.exposeHelpers(model, request);
        } catch (Exception e) {
            LoggerUtils.fmtError(FreeMarkerViewExtend.class,e,"FreeMarkerViewExtend 加载父类出现异常。请检查。");
        }
        model.put(ConstantEnum.CONTEXT_PATH.getValue(), request.getContextPath());
        model.put("basePath", request.getContextPath());//base目录。

    }
}
