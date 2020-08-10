package com.springbook.ioc.injection;

import java.util.List;

public class CollectionBeanList {
	private List<String> addressList;

	/* Getter/Setter_Method */
	public List<String> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
}