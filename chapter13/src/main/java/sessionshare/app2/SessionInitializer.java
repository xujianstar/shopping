package sessionshare.app2;

import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import sessionshare.app2.SessionConfig;
public class SessionInitializer extends AbstractHttpSessionApplicationInitializer {
    public SessionInitializer() {
        super(SessionConfig.class);
    }
}