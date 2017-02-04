package net.phuha.hrsystem;

import info.magnolia.module.blossom.annotation.VirtualURIMapper;

@VirtualURIMapper
public class VirtualUriMapping {

    public String campaignPage(String uri) {
        if (uri.equals("/campaign")) {
            return "/Main/1st-article";
        }

        return null;
    }
}
