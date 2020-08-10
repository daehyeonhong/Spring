package com.springbook.ioc.injection;

import java.util.Map;

public class CollectionBeanMap {
	private Map<String, String> addressList;

	public Map<String, String> getAddressList() {
		return addressList;
	}

	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
}