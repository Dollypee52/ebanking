package africa.semicolon.ebanking.data.repository;

import africa.semicolon.ebanking.data.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
    boolean existByAccountNumber(String accountNumber);
}
