package com.azure.oauth;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/details")
    public Map<String, Object> getUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        
        if (authentication == null) {
            throw new IllegalStateException("No authentication details found. User might not be authenticated.");
        }

        System.err.println("authentication "+authentication.getPrincipal());
        return Map.of(
            "principal", authentication.getPrincipal(),
            "authorities", authentication.getAuthorities(),
            "details", authentication.getDetails(),
            "name", authentication.getName()
        );
    }
    
    @GetMapping("/logout-success1")
    public String logout() {
    	System.err.println("logout success.................");
    	return "logout done";
    }
}
