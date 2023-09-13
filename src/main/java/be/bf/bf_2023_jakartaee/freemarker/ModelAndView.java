package be.bf.bf_2023_jakartaee.freemarker;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class ModelAndView {
    private String template;
    private Map<String, Object> model = new HashMap<>();
    public ModelAndView(String view) {
        this.template = view;
    }
    public ModelAndView(String view, Map<String, Object> model) {
        this(view);
        this.model = model;
    }

    public void put(String key, Object value) {
        this.model.put(key, value);
    }

    public void setTemplate(String template) { this.template = template; }

    public void process(OutputStream channel) throws IOException, TemplateException {
        try (OutputStreamWriter out = new OutputStreamWriter(channel)) {
            FreemarkerUtils.getConfig().getTemplate(this.template+ ".ftlh").process(this.model, out);
        }
    }
}


