package com.rk.oauth2.jwk.resourceserver.controller;

import java.security.Principal;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping
  @PreAuthorize("hasRole('ROLE_USER')")
  public HttpEntity<String> get(final Principal principal) {
    String message = String.format("Hello %s !", principal.getName());
    return new ResponseEntity<>(message, HttpStatus.OK);
  }


}
