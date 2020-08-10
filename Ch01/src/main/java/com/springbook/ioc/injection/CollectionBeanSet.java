package com.springbook.ioc.injection;

import java.util.Set;

public class CollectionBeanSet {
	private Set<String> addressList;

	public Set<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Set<String> addressList) {
		this.addressList = addressList;
	}

}