package is2.repository;

import is2.domain.Account;

public interface AccountDao extends GenericDao<Account, Long> {

	Account findByEmail(String email);
}
