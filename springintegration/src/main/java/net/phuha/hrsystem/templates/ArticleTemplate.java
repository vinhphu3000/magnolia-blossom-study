package net.phuha.hrsystem.templates;

import info.magnolia.module.blossom.annotation.Area;
import info.magnolia.module.blossom.annotation.AvailableComponentClasses;
import info.magnolia.module.blossom.annotation.ComponentInheritanceMode;
import info.magnolia.module.blossom.annotation.Inherits;
import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.TabOrder;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import net.phuha.hrsystem.components.TextComponent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Template(title = "Article Template", id = "springintegration:pages/article")
@TabOrder({ "Meta", "Content" })
public class ArticleTemplate extends BaseTemplate {

    @RequestMapping("/article")
    public String render() {
        return "pages/article.ftl";
    }

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("topic").label("Topic"),
                cfg.fields.richText("text").label("Text")
                );
    }

    @Area("main")
    @AvailableComponentClasses({ TextComponent.class })
    @Controller
    public static class MainArea {

        @RequestMapping("/article/main")
        public String render() {
            return "areas/mainArea.ftl";
        }

        @TabFactory("Content")
        public void contentTab(UiConfig cfg, TabBuilder tab) {
        }
    }

    @Area("promos")
    @AvailableComponentClasses({ TextComponent.class })
    @Inherits(components = ComponentInheritanceMode.FILTERED)
    @Controller
    public static class PromosArea {

        @RequestMapping("/article/promos")
        public String render() {
            return "areas/promosArea.ftl";
        }

        @TabFactory("Content")
        public void contentTab(UiConfig cfg, TabBuilder tab) {
            tab.fields(
                    cfg.fields.text("heading").label("Heading")
                    );
        }
    }

}
