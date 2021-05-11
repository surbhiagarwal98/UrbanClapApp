package com.nagarro.Login.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nagarro.Login.dto.AuthenticationRequest;
import com.nagarro.Login.dto.AuthenticationResponse;
import com.nagarro.Login.exception.NoLoginInfoFoundException;
import com.nagarro.Login.model.User;
import com.nagarro.Login.service.LoginService;
import com.nagarro.Login.service.MyUserDetailsService;
import com.nagarro.Login.util.JwtUtil;
import com.nagarro.Login.constants.Constants;

/**
 * Controller for login
 * 
 * @author surbhiagarwal
 *
 */

@RestController
public class LoginController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService myUserDetailsService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Authenticates the user
	 * 
	 * @param authenticationRequest
	 * @return
	 * @throws Exception
	 */

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException bce) {
			throw new Exception("Invalid Username or password");
		}

		final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = JwtUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

	/**
	 * gets current user, sends it to order application
	 * 
	 * @return
	 * @throws NoLoginInfoFoundException
	 * @throws URISyntaxException
	 */

	@RequestMapping("/currentuser")
	public User getCurrentlyLoggedInUser() throws NoLoginInfoFoundException, URISyntaxException {
		User currentUser = null;
		String username = loginService.getCurrentUsername();
		if (username != null) {
			List<User> allUsers = myUserDetailsService.getAllUsers();
			for (User user : allUsers) {
				if (user.getEmail().equals(username)) {
					currentUser = user;
					URI uri = new URI(Constants.orderBaseurl + Constants.orderGetUserUrl);
					try {
						ResponseEntity<User> response = restTemplate.postForEntity(uri, currentUser, User.class);
						System.out.println(response.getBody());
					} catch (Exception e) {
						System.out.println(e.toString());
					}
					break;
				}
			}
		} else {
			throw new NoLoginInfoFoundException("Please login to continue");
		}

		return currentUser;
	}
}
