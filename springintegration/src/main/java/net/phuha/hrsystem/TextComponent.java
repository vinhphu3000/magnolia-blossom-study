package net.phuha.hrsystem;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Template(title = "Text", id = "springintegration:components/text")
public class TextComponent {

    @Inject
    private ResourceService resourceService;

    @RequestMapping("/text")
    public String render(ModelMap model) {
        model.put("resourceName", resourceService.getName());
        return "components/text.ftl";
    }

    @TabFactory("Content")
    public void contenTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("heading").label("Heading").defaultValue("").required(true),
                cfg.fields.richText("text").label("Text"),
                cfg.fields.checkbox("inheritable").label("Inherited")
                );
    }
}