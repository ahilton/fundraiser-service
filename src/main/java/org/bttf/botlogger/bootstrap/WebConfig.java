package org.bttf.botlogger.bootstrap;

import org.bttf.botlogger.FundController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig extends ResourceConfig {

    @Autowired
    public WebConfig() {
        register(FundController.class);
        register(CORSFilter.class);
    }
}
