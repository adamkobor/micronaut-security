/*
 * Copyright 2017-2020 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.micronaut.security.token.jwt.generator;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.core.util.ArgumentUtils;
import io.micronaut.security.token.jwt.config.JwtConfigurationProperties;

import java.util.Optional;

/**
 * Refresh token configuration.
 *
 * @author James Kleeh
 * @since 2.0.0
 */
@ConfigurationProperties(RefreshTokenConfigurationProperties.PREFIX)
public class RefreshTokenConfigurationProperties implements RefreshTokenConfiguration {

    public static final String PREFIX = JwtConfigurationProperties.PREFIX + ".generator.refresh-token";

    private boolean enabled = false;
    private String secret;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled True if refresh tokens should be included in authentication responses
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public Optional<String> getSecret() {
        return Optional.ofNullable(secret);
    }

    /**
     * @param secret The secret used to sign refresh token values
     */
    public void setSecret(String secret) {
        ArgumentUtils.requireNonNull("secret", secret);
        this.secret = secret;
    }
}