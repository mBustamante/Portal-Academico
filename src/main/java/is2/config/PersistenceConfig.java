package is2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { JpaConfig.class})
class PersistenceConfig {}