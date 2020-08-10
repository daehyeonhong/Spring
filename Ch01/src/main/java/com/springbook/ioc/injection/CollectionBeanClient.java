package com.springbook.ioc.injection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CollectionBeanClient {
	public static void main(String[] args) {
		/* Container 가동 */
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext02.xml");
		CollectionBeanList beanList = (CollectionBeanList) factory.getBean("collectionBeanList");
		CollectionBeanSet beanSet = (CollectionBeanSet) factory.getBean("collectionBeanSet");
		CollectionBeanMap beanMap = (CollectionBeanMap) factory.getBean("collectionBeanMap");
		CollectionBeanProperties beanProperties = (CollectionBeanProperties) factory.getBean("collectionBeanProperties");

		/* List_Object얻기 */
		List<String> list = beanList.getAddressList();

		for (String string : list) {
			System.out.println(string);
		}

		/* Set_Object 얻기 */
		Set<String> set = beanSet.getAddressList();
		Iterator<String> iteratorSet = set.iterator();
		while (iteratorSet.hasNext()) {
			System.out.println(iteratorSet.next());
		}

		/* Map_Object 얻기 */
		Map<String, String> map = beanMap.getAddressList();
		Set<String> keySet = map.keySet();
		Iterator<String> iteratorMap = keySet.iterator();
		while (iteratorMap.hasNext()) {
			String name = iteratorMap.next();
			System.out.println(map.get(name));
		}

		/* Properties 얻기 */
		Properties properties = beanProperties.getAddressList();
		Set<Object> kS = properties.keySet();
		Iterator<Object> iteratorProperties = kS.iterator();
		while (iteratorProperties.hasNext()) {
			String name = iteratorProperties.next().toString(), address = properties.getProperty(name);
			System.out.printf("%s : %s\n", name, address);
		}
	}
}