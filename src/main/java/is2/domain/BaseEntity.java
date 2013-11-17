package is2.domain;

import java.io.Serializable;

public interface BaseEntity<PK extends Serializable> {
	PK getId();
	void setId(PK id);
}
