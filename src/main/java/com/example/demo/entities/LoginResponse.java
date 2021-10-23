package com.example.demo.entities;

public class LoginResponse {
	private Object ratings;
	private String jwt;
	private Object user;
	public Object getRatings() {
		return ratings;
	}
	public void setRatings(Object ratings) {
		this.ratings = ratings;
	}
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public Object getUser() {
		return user;
	}
	public void setUser(Object user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "LoginResponse [ratings=" + ratings + ", jwt=" + jwt + ", user=" + user + "]";
	}
	
}
