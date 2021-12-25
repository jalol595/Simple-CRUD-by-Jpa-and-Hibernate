package uz.pdp.appcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appcrud.model.Phone;

import javax.persistence.Id;
@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {

}
