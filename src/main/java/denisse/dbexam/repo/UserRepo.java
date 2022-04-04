package denisse.dbexam.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import denisse.dbexam.model.User;
//public interface BookRepository extends CrudRepository<Book, Long>
@Repository
public interface UserRepo
		extends CrudRepository<User, String>{

	public User findByEmail(String email);
	

}