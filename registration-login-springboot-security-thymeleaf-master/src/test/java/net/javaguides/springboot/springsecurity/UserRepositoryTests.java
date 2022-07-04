package net.javaguides.springboot.springsecurity;
 
import static org.assertj.core.api.Assertions.assertThat;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.javaguides.springboot.springsecurity.model.User;
import net.javaguides.springboot.springsecurity.model.UserEntity;
import net.javaguides.springboot.springsecurity.repository.UserRepository;
 
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    // test methods go below
    @Test
    public void testCreateUser() {
    	User user = new User();
        user.setEmail("test@gmail.com");
        user.setPassword("testpswd");
        user.setFirstName("testfirstname");
        user.setLastName("testlastname");       
        User savedUser = repo.save(user);       
        User existUser = entityManager.find(User.class, savedUser.getId());    
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());   
         
    }
		@Test
	
		public void whenFindByEmail_thenReturnUser() {
		User user = new User();
		user.setEmail("test2@gmail.com");
		user.setFirstName("testfirstname2");
		user.setLastName("testlastname2");
		user.setPassword("testpswd2");	
		repo.save(user);	
		User found = repo.findByEmail(user.getEmail());	
		assertThat(found.getEmail()).isEqualTo("test2@gmail.com");
		
	}
		@Test
		
		public void whenFindByFirstName_thenReturnUser() {
		User user = new User();
		user.setEmail("test3@gmail.com");
		user.setFirstName("testfirstname3");	
		user.setPassword("testpswd3");	
		repo.save(user);	
		User found = repo.findByFirstName(user.getFirstName());	
		assertThat(found.getFirstName()).isEqualTo("testfirstname3");
		
	}		
}