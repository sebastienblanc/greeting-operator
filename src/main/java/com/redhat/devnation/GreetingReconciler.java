package com.redhat.devnation;

import static io.javaoperatorsdk.operator.api.reconciler.Constants.WATCH_CURRENT_NAMESPACE;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.ControllerConfiguration;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;
import io.javaoperatorsdk.operator.api.reconciler.dependent.Dependent;

@ControllerConfiguration(namespaces = WATCH_CURRENT_NAMESPACE, dependents = {
  @Dependent(type = DeploymentDependant.class),
  @Dependent(type = ServiceDependant.class)})
public class GreetingReconciler implements Reconciler<Greeting> { 
  private final KubernetesClient client;

  public GreetingReconciler(KubernetesClient client) {
    this.client = client;
  }

  // TODO Fill in the rest of the reconciler

  @Override
  public UpdateControl<Greeting> reconcile(Greeting resource, Context context) {
    // TODO: fill in logic

    return UpdateControl.noUpdate();
  }
}

