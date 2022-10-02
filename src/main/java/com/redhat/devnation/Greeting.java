package com.redhat.devnation;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Version;

@Version("v1")
@Group("devnation.redhat.com")
public class Greeting extends CustomResource<GreetingSpec, GreetingStatus> implements Namespaced {}

