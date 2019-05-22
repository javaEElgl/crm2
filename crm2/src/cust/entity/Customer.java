package cust.entity;

public class Customer {
	private int ID;    //���
	private String no;		//�ͻ����
	private String name;   //�ͻ�����
	private String region; //�ͻ�����
	private String manager;  //�ͻ�����
	private String level;   //�ͻ��ȼ�
	private String satisfy;  //�ͻ������
	private String credit;   //�ͻ����ö�
	private String addr;	//��ַ
	private String zip;   //�ʱ�
	private String tel; 	//�绰
	private String fax;		//����
	private String website; 	//��ַ
	private String licenceID;	//Ӫҵִ�ձ��
	private String chieftain;	//���˴���
	private String bankroll;	//ע���ʽ�
	private String turnover;	//��Ӫҵ��
	private String bank;		//����������
	private String bankID;		//�����˻�
	private String localID;		//��˰�ֱ��
	private String nationalID;	//��˰�ֱ��	
	private int status;		//״̬
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String no, String name, String region, String manager,
			String level) {
		super();
		this.no = no;
		this.name = name;
		this.region = region;
		this.manager = manager;
		this.level = level;
	}


	public Customer(int iD, String name, String region, String manager,
			String level, String satisfy, String credit, String addr,
			String zip, String tel, String fax, String website,
			String licenceID, String chieftain, String bankroll,
			String turnover, String bank, String bankID, String localID,
			String nationalID) {
		super();
		ID = iD;
		this.name = name;
		this.region = region;
		this.manager = manager;
		this.level = level;
		this.satisfy = satisfy;
		this.credit = credit;
		this.addr = addr;
		this.zip = zip;
		this.tel = tel;
		this.fax = fax;
		this.website = website;
		this.licenceID = licenceID;
		this.chieftain = chieftain;
		this.bankroll = bankroll;
		this.turnover = turnover;
		this.bank = bank;
		this.bankID = bankID;
		this.localID = localID;
		this.nationalID = nationalID;
	}


	public Customer(String no, String name, String region, String manager,
			String level, String satisfy, String credit, String addr,
			String zip, String tel, String fax, String website,
			String licenceID, String chieftain, String bankroll,
			String turnover, String bank, String bankID, String localID,
			String nationalID) {
		super();
		this.no = no;
		this.name = name;
		this.region = region;
		this.manager = manager;
		this.level = level;
		this.satisfy = satisfy;
		this.credit = credit;
		this.addr = addr;
		this.zip = zip;
		this.tel = tel;
		this.fax = fax;
		this.website = website;
		this.licenceID = licenceID;
		this.chieftain = chieftain;
		this.bankroll = bankroll;
		this.turnover = turnover;
		this.bank = bank;
		this.bankID = bankID;
		this.localID = localID;
		this.nationalID = nationalID;
	}


	public Customer(int iD, String no, String name, String region,
			String manager, String level, String satisfy, String credit,
			String addr, String zip, String tel, String fax, String website,
			String licenceID, String chieftain, String bankroll,
			String turnover, String bank, String bankID, String localID,
			String nationalID, int status) {
		super();
		ID = iD;
		this.no = no;
		this.name = name;
		this.region = region;
		this.manager = manager;
		this.level = level;
		this.satisfy = satisfy;
		this.credit = credit;
		this.addr = addr;
		this.zip = zip;
		this.tel = tel;
		this.fax = fax;
		this.website = website;
		this.licenceID = licenceID;
		this.chieftain = chieftain;
		this.bankroll = bankroll;
		this.turnover = turnover;
		this.bank = bank;
		this.bankID = bankID;
		this.localID = localID;
		this.nationalID = nationalID;
		this.status = status;
	}


	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSatisfy() {
		return satisfy;
	}
	public void setSatisfy(String satisfy) {
		this.satisfy = satisfy;
	}
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLicenceID() {
		return licenceID;
	}
	public void setLicenceID(String licenceID) {
		this.licenceID = licenceID;
	}
	public String getChieftain() {
		return chieftain;
	}
	public void setChieftain(String chieftain) {
		this.chieftain = chieftain;
	}
	public String getBankroll() {
		return bankroll;
	}
	public void setBankroll(String bankroll) {
		this.bankroll = bankroll;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getBankID() {
		return bankID;
	}
	public void setBankID(String bankID) {
		this.bankID = bankID;
	}
	public String getLocalID() {
		return localID;
	}
	public void setLocalID(String localID) {
		this.localID = localID;
	}
	public String getNationalID() {
		return nationalID;
	}
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
