package denisse.dbexam.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import denisse.dbexam.user.model.User;
//public interface BookRepository extends CrudRepository<Book, Long>
@Repository
public interface UserRepo
		extends CrudRepository<User, String>{

	public User findByEmail(String email);
	

}