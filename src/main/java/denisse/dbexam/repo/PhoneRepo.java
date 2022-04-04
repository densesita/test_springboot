package denisse.dbexam.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import denisse.dbexam.model.Phone;
import denisse.dbexam.model.User;
@Repository
public interface PhoneRepo
		extends CrudRepository<Phone, String>{

	public Phone findByUser(User user);
	

}