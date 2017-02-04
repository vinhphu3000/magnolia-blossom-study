package net.phuha.hrsystem;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Template(title = "Jsp Based Text", id = "springintegration:components/jspbasedtext")
@Controller
public class JspBasedTextComponent {

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("heading").label("Heading"),
                cfg.fields.richText("body").label("Body").required()
                );
    }

    @TabFactory("Margins")
    public void marginsTab(TabBuilder tab) {
    }

    @RequestMapping("jspbasedtext")
    public String render() {
        return "components/text.jsp";
    }

}
