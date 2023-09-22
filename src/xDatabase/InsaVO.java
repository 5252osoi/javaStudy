package xDatabase;

public class InsaVO {
	private int idx;
	private String name;
	private int age;
	private String gender;
	private String ipsail;
	
	private String stryy;
	private String strmm;
	private String strdd;
	
	int getIdx() {
		return idx;
	}
	void setIdx(int idx) {
		this.idx = idx;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	String getGender() {
		return gender;
	}
	void setGender(String gender) {
		this.gender = gender;
	}
	String getIpsail() {
		return ipsail;
	}
	void setIpsail(String ipsail) {
		this.ipsail = ipsail;
	}
	String getStryy() {
		return stryy;
	}
	void setStryy(String stryy) {
		this.stryy = stryy;
	}
	String getStrmm() {
		return strmm;
	}
	void setStrmm(String strmm) {
		this.strmm = strmm;
	}
	String getStrdd() {
		return strdd;
	}
	void setStrdd(String strdd) {
		this.strdd = strdd;
	}
	
	@Override
	public String toString() {
		return "InsaVO [idx=" + idx + ", name=" + name + ", age=" + age + ", gender=" + gender + ", ipsail=" + ipsail
				+ ", stryy=" + stryy + ", strmm=" + strmm + ", strdd=" + strdd + "]";
	}
	
	
	
	
}
