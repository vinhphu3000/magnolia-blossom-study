package net.phuha.hrsystem.components;

import info.magnolia.module.blossom.annotation.DialogFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.ui.dialog.config.DialogBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Template(title = "Header", id = "springintegration:components/header")
public class HeaderComponent {

    @DialogFactory("frontpage-properties")
    public void frontPageProperties(UiConfig cfg, DialogBuilder dialog) {
        dialog.form().tabs(
                cfg.forms.tab("Properties").fields(
                        cfg.fields.text("metadata").label("Metadata").description("Metadata used for SEO")
                        )
                );
    }

    @RequestMapping("/header")
    public String render() {
        return "components/header.ftl";
    }

}
