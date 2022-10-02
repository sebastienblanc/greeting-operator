package com.redhat.devnation;


import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.api.model.apps.DeploymentBuilder;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.processing.dependent.kubernetes.CRUDKubernetesDependentResource;

public class DeploymentDependant extends CRUDKubernetesDependentResource<Deployment, Greeting> {

    public DeploymentDependant() {
        super(Deployment.class); 
    }

    @Override
    protected Deployment desired(Greeting primary, Context<Greeting> context) {
        Deployment deployment = new DeploymentBuilder()
        .withNewMetadata()
           .withName("greeting-app")
           .addToLabels("app", "greeting-app")
        .endMetadata()
        .withNewSpec()
           .withReplicas(1)
           .withNewTemplate()
             .withNewMetadata()
             .addToLabels("app", "greeting-app")
             .endMetadata()
             .withNewSpec()
               .addNewContainer()
                  .withName("greeting-container")
                  .withImage("quay.io/rhdevelopers/blue-green-canary")
                  .addNewEnv().withName("BLUE_GREEN_CANARY_COLOR").withValue(primary.getSpec().getColor()).endEnv()
                  .addNewEnv().withName("BLUE_GREEN_CANARY_MESSAGE").withValue(primary.getSpec().getGreeting()).endEnv()
               .endContainer()
             .endSpec()
           .endTemplate()
           .withNewSelector()
             .addToMatchLabels("app","greeting-app")
           .endSelector()
        .endSpec()
      .build();
    return deployment;
    }

    
    
}
