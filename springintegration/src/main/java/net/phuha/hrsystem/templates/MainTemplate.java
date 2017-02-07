package net.phuha.hrsystem.templates;

import info.magnolia.module.blossom.annotation.Area;
import info.magnolia.module.blossom.annotation.AvailableComponentClasses;
import info.magnolia.module.blossom.annotation.ComponentInheritanceMode;
import info.magnolia.module.blossom.annotation.Inherits;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import net.phuha.hrsystem.components.HeaderComponent;
import net.phuha.hrsystem.components.JspBasedTextComponent;
import net.phuha.hrsystem.components.NewsletterFormComponent;
import net.phuha.hrsystem.components.ReactJSGridComponent;
import net.phuha.hrsystem.components.TextComponent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Template(title = "Main Template", id = "springintegration:pages/mainTemplate")
public class MainTemplate extends BaseTemplate {

    @RequestMapping("/mainTemplate")
    public String render() {
        return "pages/main.ftl";
    }

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("topic").label("Topic"),
                cfg.fields.richText("text").label("Text")
                );
    }

    @Area("main")
    @AvailableComponentClasses({
            TextComponent.class,
            NewsletterFormComponent.class,
            JspBasedTextComponent.class,
            HeaderComponent.class,
            ReactJSGridComponent.class })
    @Controller
    public static class MainArea {
        @TabFactory("Content")
        public void contentTab(TabBuilder tab) {
        }

        @RequestMapping("/mainTemplate/main")
        public String render() {
            return "areas/mainArea.ftl";
        }
    }

    @Area("promos")
    @AvailableComponentClasses({ TextComponent.class })
    @Inherits(components = ComponentInheritanceMode.FILTERED)
    @Controller
    public static class PromosArea {
        @TabFactory("Content")
        public void contentTab(UiConfig cfg, TabBuilder tab) {
            tab.fields(
                    cfg.fields.text("heading").label("Heading")
                    );
        }

        @RequestMapping("/mainTemplate/promos")
        public String render() {
            return "areas/promosArea.ftl";
        }
    }
}
