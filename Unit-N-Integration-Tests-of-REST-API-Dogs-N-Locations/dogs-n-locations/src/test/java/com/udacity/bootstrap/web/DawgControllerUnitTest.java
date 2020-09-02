package com.udacity.bootstrap.web;

import com.udacity.bootstrap.service.DawgService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(DawgController.class)
public class DawgControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DawgService dawgService;

    @Test
    public void getAllDawgs() throws Exception {
        mockMvc.perform(get("/dawg/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dawgService, times(1)).retrieveDawgs();
    }

    @Test
    public void eifachoepis4() throws Exception {
        mockMvc.perform(get("/dawg/breedbyid=1"))
                .andExpect(status().isOk());

        verify(dawgService, times(1)).retrieveDogBreedById((long) 1);
    }
}
