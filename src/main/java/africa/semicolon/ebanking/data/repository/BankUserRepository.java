package africa.semicolon.ebanking.data.repository;

import africa.semicolon.ebanking.data.model.BankUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankUserRepository extends MongoRepository<BankUser, String> {

    Optional<BankUser> findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<BankUser> findByAccountNumber(String accountNumber);
}
