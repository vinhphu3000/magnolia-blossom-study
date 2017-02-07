package net.phuha.hrsystem.components;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Template(title = "ReactJS Grid", id = "springintegration:components/reactjsgrid")
@Controller
public class ReactJSGridComponent {

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("heading").label("Heading"),
                cfg.fields.code("code").label("ReactJS Code")
                );
    }

    @RequestMapping("/reactjsgrid")
    public String render() {
        return "components/reactjsgrid.jsp";
    }

}
