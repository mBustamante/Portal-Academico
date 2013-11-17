package is2.repository.jpa;

import javax.inject.Inject;
import javax.persistence.PersistenceException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import is2.domain.Account;
import is2.repository.AccountDao;

@Repository
@Transactional(readOnly = true)
public class JpaAccountDao extends JpaGenericDao<Account, Long> implements AccountDao {

	@Inject
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public Account persist(Account account) {
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		super.persist(account);
		return account;
	}

	@Override
	public Account findByEmail(String email) {
		try {
			return entityManager.createNamedQuery(Account.FIND_BY_EMAIL, Account.class)
			    .setParameter("email", email).getSingleResult();
		} catch (PersistenceException e) {
			return null;
		}
	}

	@Override
	protected Class<Account> getClase() {
		return Account.class;
	}

}
