/*
 */
package org.apache.taverna.server.master.identity;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.apache.taverna.server.master.common.Roles.ADMIN;
import static org.apache.taverna.server.master.common.Roles.USER;
import static org.apache.taverna.server.master.defaults.Default.AUTHORITY_PREFIX;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.Query;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * The representation of a user in the database.
 * <p>
 * A user consists logically of a (non-ordered) tuple of items:
 * <ul>
 * <li>The {@linkplain #getUsername() user name},
 * <li>The {@linkplain #getPassword() user's password} (salted, encoded),
 * <li>Whether the user is {@linkplain #isEnabled() enabled} (i.e., able to log
 * in),
 * <li>Whether the user has {@linkplain #isAdmin() administrative privileges}, and
 * <li>What {@linkplain #getLocalUsername() system (Unix) account} the user's
 * workflows will run as; separation between different users that are mapped to
 * the same system account is nothing like as strongly enforced.
 * </ul>
 * 
 * @author Donal Fellows
 */
@PersistenceCapable(schema = "USERS", table = "LIST")
@Query(name = "users", language = "SQL", value = "SELECT id FROM USERS.LIST ORDER BY id", resultClass = String.class)
@XmlRootElement
@XmlType(name = "User", propOrder = {})
@SuppressWarnings("serial")
public class User implements UserDetails {
	@XmlElement
	@Persistent
	private boolean disabled;
	@XmlElement(name = "username", required = true)
	@Persistent(primaryKey = "true")
	private String id;
	@XmlElement(name = "password", required = true)
	@Persistent(column = "password")
	private String encodedPassword;
	@XmlElement
	@Persistent
	private boolean admin;
	@XmlElement
	@Persistent
	private String localUsername;

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auths = new ArrayList<>();
		auths.add(new LiteralGrantedAuthority(USER));
		if (admin)
			auths.add(new LiteralGrantedAuthority(ADMIN));
		if (localUsername != null)
			auths.add(new LiteralGrantedAuthority(AUTHORITY_PREFIX
					+ localUsername));
		return auths;
	}

	@Override
	public String getPassword() {
		return encodedPassword;
	}

	@Override
	public String getUsername() {
		return id;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return !disabled;
	}

	void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	void setUsername(String username) {
		this.id = username;
	}

	void setEncodedPassword(String password) {
		this.encodedPassword = password;
	}

	void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isAdmin() {
		return admin;
	}

	void setLocalUsername(String localUsername) {
		this.localUsername = localUsername;
	}

	public String getLocalUsername() {
		return localUsername;
	}
}

@SuppressWarnings("serial")
class LiteralGrantedAuthority implements GrantedAuthority {
	private String auth;

	LiteralGrantedAuthority(String auth) {
		this.auth = auth;
	}

	@Override
	public String getAuthority() {
		return auth;
	}

	@Override
	public String toString() {
		return "AUTHORITY(" + auth + ")";
	}
}
