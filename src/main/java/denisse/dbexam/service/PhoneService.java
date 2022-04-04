package denisse.dbexam.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import denisse.dbexam.model.Phone;
import denisse.dbexam.model.User;
import denisse.dbexam.repo.PhoneRepo;
import denisse.dbexam.user.dto.PhoneDTO;
import denisse.dbexam.util.CommonsUtils;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PhoneService {
	@Autowired
	PhoneRepo phoneRepo;
	
	/**
	 * Persistir lista de Telefonos.
	 * - agrega uuid a cada objeto Phone.
	 * - relaciona con User cada Phone. 
	 * @param listaPhones    
	 * @param user 
	 * @return
	 */
	public List<Phone>  persistPhoneList(List<PhoneDTO> listaPhones, User user){
		//
		List<Phone>  m = new ArrayList<>();
		if(listaPhones!=null) {
			
			if(log.isDebugEnabled()) log.debug("Phone List to persist + {}", listaPhones);
			for( PhoneDTO p : listaPhones) {
				Phone px = new Phone();
				px.setCityCode(p.getCityCode());
				px.setCountryCode(p.getCityCode());
				px.setNumber(p.getNumber());
				px.setId(CommonsUtils.generateUUID());
				px.setUser(user);
				m.add(px);
			}
			phoneRepo.saveAll(m);
			
		}
		log.info("persist phone successful.");
		
		return m;
	}
	
	
	
}
