public class SUser extends User{
	private String type = "S";
	public SUser(String name, int password, double balance){
		super(name, password, balance);
	}
	public String getType(){
		return "S";
	}
	public void service(){
		super.service();
		System.out.println("感谢您的登录，VIP用户" + this.getName());
		}
}