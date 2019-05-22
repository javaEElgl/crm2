package sale.dao;

import java.util.List;

import sale.entity.Sale;

public interface SaleDao {
	public List<Sale> splitPage(List<Sale> list,int begin,int end);   //��ҳ��ѯ
	public List<Sale> find();   		        //��ѯ����
	public List<Sale> find(Sale sale);   		//����ָ����Ϣ��ѯ
	public boolean add(Sale sale);				//���
	public boolean del(Sale sale);				//ɾ��
	public boolean update(Sale sale);           //�޸�
	
	public Sale findById(int id);//����id��ѯָ����Sale
	public boolean dispatch(Sale sale); //ָ������
	public int count();//ͳ�Ƽ�¼����
	public int status(Sale sale);//�鿴����״̬
	public boolean finish(Sale sale);//���񿪷�����
}
