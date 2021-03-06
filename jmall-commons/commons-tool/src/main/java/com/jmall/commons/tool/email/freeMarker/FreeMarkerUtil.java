package com.jmall.commons.tool.email.freeMarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Map;

public class FreeMarkerUtil {

    public static String getMailTextForTemplate(String templatePath, String filename, Map datas) throws IOException, TemplateException {
        Configuration configuration = new Configuration();
        //获取class下面的模板文件
        configuration.setDirectoryForTemplateLoading(new File(FreeMarkerUtil.class.getClass().getResource(
               "/"+templatePath).getPath()));
        Template template = configuration.getTemplate(filename,"utf-8");
        StringWriter out = new StringWriter();
        template.process(datas,out);
        return out.toString();
    }
}
