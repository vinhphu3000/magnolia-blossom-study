package net.phuha.hrsystem;

import org.springframework.stereotype.Service;

@Service
public class ResourceService {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
