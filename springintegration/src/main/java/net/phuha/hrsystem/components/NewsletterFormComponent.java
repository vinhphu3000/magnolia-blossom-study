package net.phuha.hrsystem.components;

import info.magnolia.module.blossom.annotation.TabFactory;
import info.magnolia.module.blossom.annotation.Template;
import info.magnolia.module.blossom.view.UuidRedirectView;
import info.magnolia.ui.form.config.TabBuilder;
import info.magnolia.ui.framework.config.UiConfig;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import net.phuha.hrsystem.entity.NewsletterForm;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Template(title = "Newsletter", id = "springintegration:components/newsletterForm")
public class NewsletterFormComponent {

    @RequestMapping(value = "/newsletter", method = RequestMethod.GET)
    public String display(@ModelAttribute NewsletterForm form) {
        return "components/newsletterForm.ftl";
    }

    @RequestMapping(value = "/newsletter", method = RequestMethod.POST)
    public ModelAndView submit(@ModelAttribute NewsletterForm form, BindingResult result, Node content) throws RepositoryException {
        ValidationUtils.rejectIfEmpty(result, "email", null, "Email is required");
        if (result.hasErrors()) {
            return new ModelAndView("components/newsletterForm.ftl");
        }

        return new ModelAndView(new UuidRedirectView("website", content.getProperty("successPage").getString()));
    }

    @TabFactory("Content")
    public void contentTab(UiConfig cfg, TabBuilder tab) {
        tab.fields(
                cfg.fields.pageLink("successPage").label("Success page").required(true)
                );
    }
}
