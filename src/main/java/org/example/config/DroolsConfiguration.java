package org.example.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DroolsConfiguration {

    @Bean
    public KieContainer kieContainer() {
        final KieServices kieServices = KieServices.Factory.get();
        final KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("drools/rules.drl"));
        final KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
        final KieModule kieModule = kieBuilder.getKieModule();
        final KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        return kieContainer;
    }

}