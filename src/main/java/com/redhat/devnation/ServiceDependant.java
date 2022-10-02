package com.redhat.devnation;

import java.util.Map;

import io.fabric8.kubernetes.api.model.IntOrString;
import io.fabric8.kubernetes.api.model.Service;
import io.fabric8.kubernetes.api.model.ServiceBuilder;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.processing.dependent.kubernetes.CRUDKubernetesDependentResource;

public class ServiceDependant extends CRUDKubernetesDependentResource<Service, Greeting> {

    public ServiceDependant() {
        super(Service.class); 
    }
    
    @Override
    protected Service desired(Greeting primary, Context<Greeting> context) {
        Service service = new ServiceBuilder()
        .withNewMetadata()
            .withName("greeting-service")
            .withLabels(Map.of("app", "greeting-app"))
        .endMetadata()
        .withNewSpec()
            .withType("LoadBalancer")
            .addNewPort()
                .withPort(8080)
                .withTargetPort(new IntOrString(8080))
                .withProtocol("TCP")
            .endPort()
            .withSelector(Map.of("app", "greeting-app"))
        .endSpec()
        .build();
        return service;
    }
    

}
