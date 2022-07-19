package com.TTS.junittesting;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
	
		@LocalServerPort
		private int port;

		@Autowired
		private TestRestTemplate restTemplate;

		@Test
		public void greetingShouldReturnDefaultMessage() throws Exception {
			assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/",
					String.class)).contains("Hello, World");
		}
}
