package com.Exams.core.bo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

	private UserAccount user;

	public UserPrincipal() {
		System.out.println("UserPrincipal est crée ...!");
	}

	@Override
	public String toString() {
		return "MyUserPrincipal [user=" + user + "]";
	}

	public UserPrincipal(UserAccount user) {
		this.user = user;
	}

	public UserAccount getUser() {
		return user;
	}

	public void setUser(UserAccount user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		ArrayList<GrantedAuthority> arrayAuths = new ArrayList<GrantedAuthority>();

		SimpleGrantedAuthority auth = new SimpleGrantedAuthority(user.getRole().getNomRole());
		arrayAuths.add(auth);
		return arrayAuths;
	}

	// TODO : les méthodes suivantes à adapter si vous changer la conception des
	// classes
	// Sinon vous pouvez les laisser telles quelles
	public String getFirstName() {
		return user.getProprietaire().getNom();
	}

	public String getLastName() {
		return user.getProprietaire().getPrenom();
	}

	

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.isAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.isAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.isCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}

}