package com.redhat.devnation;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.reconciler.Context;
import io.javaoperatorsdk.operator.api.reconciler.Reconciler;
import io.javaoperatorsdk.operator.api.reconciler.UpdateControl;

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

