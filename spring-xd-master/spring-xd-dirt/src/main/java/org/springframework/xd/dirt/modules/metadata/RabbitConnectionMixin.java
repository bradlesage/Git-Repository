/*
 * Copyright 2013-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.xd.dirt.modules.metadata;

import org.hibernate.validator.constraints.NotBlank;

import org.springframework.xd.module.options.spi.ModuleOption;

/**
 * Factors out options for the typical connection setup to RabbitMQ.
 *
 * @author Eric Bottard
 * @author Gary Russell
 * @author Glenn Renfro
 * @author Gary Russell
 */
public class RabbitConnectionMixin {

	private String vhost = "${spring.rabbitmq.virtual_host}";

	private String username = "${spring.rabbitmq.username}";

	private String password = "${spring.rabbitmq.password}";

	private String addresses = "${spring.rabbitmq.addresses}";

	private String useSSL = "${spring.rabbitmq.useSSL}";

	private String sslPropertiesLocation = "${spring.rabbitmq.sslProperties}";

	@NotBlank
	public String getUsername() {
		return username;
	}

	@ModuleOption("the username to use to connect to the broker")
	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}

	@ModuleOption("the password to use to connect to the broker")
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddresses() {
		return this.addresses;
	}

	@ModuleOption("a comma separated list of 'host[:port]' addresses")
	public void setAddresses(String addresses) {
		this.addresses = addresses;
	}

	public String getVhost() {
		return vhost;
	}

	@ModuleOption(value = "the RabbitMQ virtual host to use", hidden = true)
	public void setVhost(String vhost) {
		this.vhost = vhost;
	}

	public String getUseSSL() {
		return useSSL;
	}

	@ModuleOption(value = "true if SSL should be used for the connection", hidden = true)
	public void setUseSSL(String useSSL) {
		this.useSSL = useSSL;
	}

	public String getSslPropertiesLocation() {
		return sslPropertiesLocation;
	}

	@ModuleOption(value = "resource containing SSL properties", hidden = true)
	public void setSslPropertiesLocation(String sslPropertiesLocation) {
		this.sslPropertiesLocation = sslPropertiesLocation;
	}

}
