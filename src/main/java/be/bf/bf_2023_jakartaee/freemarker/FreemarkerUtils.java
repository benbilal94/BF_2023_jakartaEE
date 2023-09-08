package be.bf.bf_2023_jakartaee.freemarker;

import freemarker.template.Configuration;

import java.util.TimeZone;

public class FreemarkerUtils {
    public static Configuration getConfig() {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_27);

        try {
            configuration.setClassForTemplateLoading(FreemarkerUtils.class,"/templates");
            configuration.setDefaultEncoding("UTF-8");
            configuration.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
            return configuration;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
