/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 
/**
 * Description:
 * ��վ: <a href="
���Java����</a> 
 * Copyright (C), 2001-2012, Yeeku.H.Lee
 * This program is protected by copyright laws.
 * Program Name:
 * Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class ArrayUtils
{
/**
* ����һ�����߷��������߷������ַ����������ҵ���Ӧ���ַ���Ԫ�ص�λ��
* @param array ����������
* @param target �������ַ���
* @return Ŀ���ַ������ֵ�λ��,-1�����Ҳ���
*/
public static int search(String[] array, String target)
{
for (int i = 0 ; i < array.length ; i++ )
{
if (array[i] != null && array[i].equals(target))
{
return i;
}
}
return -1;
}
}