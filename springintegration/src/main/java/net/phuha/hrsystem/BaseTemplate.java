package net.phuha.hrsystem;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

public class BaseTemplate {

    @TabFactory("Meta")
    public void metaData(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.text("author").label("Author").defaultValue("").required(true),
                cfg.fields.text("authorEmail").label("Email").validator(cfg.validators.email().errorMessage("Email format is not correct")),
                cfg.fields.text("description").label("Description").defaultValue("")
                );
    }

}
