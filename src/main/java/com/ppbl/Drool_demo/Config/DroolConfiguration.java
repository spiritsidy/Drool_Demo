package com.ppbl.Drool_demo.Config;

import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.io.KieResources;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.io.File;


@Configuration
public class DroolConfiguration {

    private static final KieServices kieServices = KieServices.Factory.get();
    private static final KieResources kieResources= kieServices.getResources();

//    @Scheduled(fixedDelay = 2*60*1000, initialDelay = 1000)
//    public void updateSecondaryKieContainer(){
//        System.out.println("updateSecondaryKieContainer"+ (new Date()));
//        KieContainer defaultKieContainer = kieContainer(new File("/Users/sonu.maddheshiya/Downloads/Drool_demo/src/main/resources/rules/offer.drl"));
//    }
    @Bean
    public KieContainer kieContainer() {
//            KieFileSystem kfs = kieServices.newKieFileSystem();
//            File file = new File("/Users/sonu.maddheshiya/Desktop/offer1");
//            kfs.write(kieResources.newFileSystemResource(file).setResourceType(ResourceType.DRL));
//            KieBuilder kb = kieServices.newKieBuilder(kfs);
//            kb.buildAll();
//            KieModule kieModule= kb.getKieModule();
//            KieContainer kContainer = kieServices.newKieContainer(kieModule.getReleaseId());
//            return kContainer;
            //KieSession kSession = kContainer.newKieSession();

//        KieServices kServices = KieServices.Factory.get();
//
//        KieFileSystem kfs = kServices.newKieFileSystem();
//        KieRepository kr = kServices.getRepository();
//        File file = new File("/Users/sonu.maddheshiya/Desktop/offer1");
//        Resource resource = kServices.getResources().newFileSystemResource(file).setResourceType(ResourceType.DRL);
//        kfs.write(resource);
//        KieBuilder kb = kServices.newKieBuilder(kfs);
//        kb.buildAll();
//        KieContainer kContainer = kServices.newKieContainer(kr.getDefaultReleaseId());
//        return kContainer;
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
       // kieFileSystem.write(ResourceFactory.newClassPathResource("rules/offer.drl"));
       // kieFileSystem.write(ResourceFactory.newClassPathResource("rules/offer2.drl"));
       // kieFileSystem.write(kieResources.newFileSystemResource(new File("/Users/sonu.maddheshiya/Desktop/offer1")).setResourceType(ResourceType.DRL));
        kieFileSystem.write(ResourceFactory.newFileResource(new File("/Users/sonu.maddheshiya/Desktop/offer.drl")));
        KieBuilder kb = kieServices.newKieBuilder(kieFileSystem);
        kb.buildAll();
        KieModule kieModule = kb.getKieModule();
        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());
        KieScanner kieScanner= kieServices.newKieScanner(kieContainer);
        kieScanner.scanNow();
        kieScanner.start(100000L);
        return kieContainer;

    }
}
