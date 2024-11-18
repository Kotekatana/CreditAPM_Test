package ru.test.creditapm;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.test.creditapm.models.User;
import ru.test.creditapm.models.Work;
import ru.test.creditapm.repositories.UsersRepository;
import ru.test.creditapm.repositories.Impl.UsersRepositoryJpaImpl;
import ru.test.creditapm.repositories.WorksRepository;
import ru.test.creditapm.repositories.Impl.WorksRepositoryJpaImpl;
import ru.test.creditapm.services.UsersService;
import ru.test.creditapm.services.impl.UsersServiceImpl;


@SpringBootApplication
public class CreditApmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditApmApplication.class, args);
	}

}
