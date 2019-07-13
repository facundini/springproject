package com.facundini.springboot.thymeleafdemo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
	  public static void main(String[] args) {
	      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	      String encoded = encoder.encode("asdasd");
	      System.out.println(encoded);
	  }
	}