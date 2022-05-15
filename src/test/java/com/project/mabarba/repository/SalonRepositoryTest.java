package com.project.mabarba.repository;

import com.project.mabarba.models.Salon;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class SalonRepositoryTest {

    private String dDate="2022-05-12 15:32:52";
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private Date cDate = df.parse(dDate);


    @MockBean
    private SalonRepository salonRepository;

    SalonRepositoryTest() throws ParseException {
    }

    @Test
    void save() {

        //given

        Salon expectedSalonObject = new Salon(376l, "Beauty", "23774563489",false, cDate);

        //when
        Salon actualSalonObject = salonRepository.save(expectedSalonObject);

        //then
        assertThat(actualSalonObject).usingRecursiveComparison()
                .ignoringFields("id").isEqualTo(expectedSalonObject);
    }

    @Test
    void findAllByOrderByCreatedAtDesc() {
    }


}