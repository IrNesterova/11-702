package ru.itis.repositories;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.User;

import static org.junit.Assert.assertEquals;

public class UsersRepositoryJbdcTemplateImplTest {
    private UsersRepositoryJdbcTemplateImpl usersRepository;

    private final User EXPECTED = User.builder()
            .id(1L)
            .name("Марсель")
            .build();

    @Before
    public void setUp() throws Exception {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/shop");
        usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
    }

    @Test
    public void find() {
        User actual = usersRepository.find(1L);
        assertEquals(EXPECTED, actual);
    }
}
