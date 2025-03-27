package org.restaurant.order_compose_machine;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import lombok.SneakyThrows;
import org.restaurant.order_compose_machine.dto.Dto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@AutoConfigureMockMvc
public abstract class AbstractUnitTest extends AbstractTestNGSpringContextTests {
  @Autowired protected MockMvc mockMvc;
  @Autowired protected ObjectMapper objectMapper;

  @SneakyThrows
  protected ResultActions sendMockedGetRequest(URI uri) {
    return mockMvc.perform(MockMvcRequestBuilders.get(uri).contentType(MediaType.APPLICATION_JSON));
  }

  @SneakyThrows
  protected ResultActions sendMockedPostRequest(URI uri, Dto data) {
    return mockMvc.perform(
        MockMvcRequestBuilders.post(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(data)));
  }

  @SneakyThrows
  protected ResultActions sendMockedPutRequest(URI uri, Dto data) {
    return mockMvc.perform(
        MockMvcRequestBuilders.put(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(data)));
  }

  @SneakyThrows
  protected ResultActions sendDeleteRequest(URI uri, Dto data) {
    return mockMvc.perform(
        MockMvcRequestBuilders.delete(uri)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(data)));
  }

}
