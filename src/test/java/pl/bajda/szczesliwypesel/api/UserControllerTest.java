package pl.bajda.szczesliwypesel.api;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import pl.bajda.szczesliwypesel.model.User;
import pl.bajda.szczesliwypesel.services.UserService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    @Test
    public void givenUsers_whenGetUsers_thenReturnJsonArray() throws Exception {
        User stefan = new User();
        stefan.setName("Stefan");
        stefan.setEmail("stefan@gmail.com");
        List<User> allUsers = Arrays.asList(stefan);

        given(service.getAllUser()).willReturn(allUsers);

        mvc.perform(get("/users/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", Matchers.is(stefan.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(1)));
    }

    @Test

    public void getUserById() throws Exception {

        User stefan = new User();
        stefan.setId(1l);
        stefan.setName("Stefan");

        given(service.getUserById(stefan.getId())).willReturn(stefan);

        mvc.perform(get("/users/1")

                .contentType(MediaType.APPLICATION_JSON))

                .andExpect(status().isOk())

                .andExpect(MockMvcResultMatchers.jsonPath("name", is(stefan.getName())));

    }


    @Test
    public void getUserByName() {
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateUser() {
    }
}
