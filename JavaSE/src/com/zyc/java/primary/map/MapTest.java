package com.zyc.java.primary.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Map�ӿ��е�key������ģ������ظ��ģ���set�洢key��Map�е�value���ظ�����collection�洢value��һ�Լ�ֵ�Թ�����һ��entry
 * 			key������Ҫ��дequals������hashcode����		value������Ҫ��дequals����
 * Map�ӿڣ��洢һ�����ݣ���ֵ����ʽ����ʵ���ࣺ
 * 								HashMap����Ҫʵ���࣬�̲߳���ȫ��Ч�ʸߣ����Դ洢null��jdk8�������顢����ͺ����
 * 									����LinkHashMap:�ܱ�֤����ʱ�����԰������˳�������˫����洢������Ƶ���ر�������ʹ��
 * 								TreeMap:���Ը��ݼ�ֵ�����򣬰���key���ţ�������洢
 * 								Hashtable:���ϵ�ʵ���࣬Ч�ʵͣ����ܴ洢null
 * 									����Properties:���������������ļ���key��value����string����
 * hashMap�ײ�ʵ��ԭ����jdk7Ϊ������
 * 			----��ʵ�����Ժ󴴽��˳���Ϊ16��һά����entry[] table��map.put[k,v]
 * 			----���������ʱ��������Ҫ֪���ŵ�λ��-->����k��hashֵ-->�õ��������еĴ��λ��(��Ҫ����hashֵ)
 * 			----�����λ����û�����ݣ�����ӳɹ�(��ӵ���entry����Ԫ��)��
 * 			----�����λ�ò�Ϊ��(����λ���ϴ���һ����������)��
 * 			----�Ƚ�k���Ѿ����ڵ�һ���������ݵ�hashֵ�����k��hashֵ����ڵ����ݶ�����ͬ������ӳɹ���
 * 			----���k��hashֵ��ĳһ��������ͬ��������Ƚϣ�����k��equals����������������ͬ����ӳɹ��������õ�ǰv�滻ԭ���ĵ�v��--�൱���޸�
 * ���ݣ�Ĭ�����ݷ�ʽΪԭ����2��������ԭ���ݸ���
 * 
 * hashMap�ײ�ʵ��ԭ��jdk8���������7�����¼��㲻ͬ��1����newʱû�д�������,2������������Node��3���״ε���put����ʱ���ڴ�������Ϊ16������
 * 											4���ײ�ṹ����+����+���������������ڵ����ݴ���8���Ҵ��λ�ò�Ϊnull�������鳤�ȳ���64����ʱ�����ϵ����ݸ�Ϊ������洢�����������
 * 
 * 
* @Description
* @author zyc 
* @version
* @date 2022��5��7������12:13:44
 */
public class MapTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Map map = new HashMap();
		map.put(Integer.valueOf(15), new String("zyc"));//�������
		map.put(Integer.valueOf(15), null);
//		Map map1 = new Hashtable();
//		map1.put(null, map);//���ܴ�null
		
		
		
		
	}
}
