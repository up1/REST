package org.rest.sec.client;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.rest.sec.dto.User;
import org.rest.spring.application.ApplicationTestConfig;
import org.rest.spring.client.ClientTestConfig;
import org.rest.spring.persistence.jpa.PersistenceJPAConfig;
import org.rest.test.AbstractRESTIntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( classes = { ApplicationTestConfig.class, PersistenceJPAConfig.class, ClientTestConfig.class },loader = AnnotationConfigContextLoader.class )
public class AuthenticationClientRESTIntegrationTest extends AbstractRESTIntegrationTest{
	
	@Autowired private AuthenticationRESTTemplate authenticationRestTemplate;
	
	// tests
	
	// GET
	
	@Test
	public final void whenAuthenticating_then201IsReceived(){
		// When
		final ResponseEntity< User > response = authenticationRestTemplate.authenticate();
		
		// Then
		assertThat( response.getStatusCode().value(), is( 201 ) );
	}
	
}