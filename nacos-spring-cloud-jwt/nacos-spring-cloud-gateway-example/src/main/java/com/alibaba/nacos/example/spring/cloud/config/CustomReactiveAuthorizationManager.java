package com.alibaba.nacos.example.spring.cloud.config;

import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.vote.RoleHierarchyVoter;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import reactor.core.publisher.Mono;

import java.util.Collections;

public class CustomReactiveAuthorizationManager<T> implements ReactiveAuthorizationManager<T> {

    private final RoleHierarchyVoter roleHierarchyVoter;

    private final String authority;

    public CustomReactiveAuthorizationManager(String authority, RoleHierarchy roleHierarchy) {
        this.authority = authority;
        this.roleHierarchyVoter = new RoleHierarchyVoter(roleHierarchy);
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, T object) {

        return authentication
                .map(a -> {
                    ConfigAttribute ca = (ConfigAttribute) () -> authority;
                    int voteResult = roleHierarchyVoter.vote(a, object, Collections.singletonList(ca));
                    boolean isAuthorized = voteResult == AccessDecisionVoter.ACCESS_GRANTED;
                    return new AuthorizationDecision(isAuthorized);
                })
                .defaultIfEmpty(new AuthorizationDecision(false));
    }

}
