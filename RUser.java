public class RUser extends User{
	private String type = "R";
	public RUser(String name, int password, double balance){
		super(name, password, balance);
	}
	public String getType(){
		return "R";
	}
	public void service(){
		super.service();
		System.out.println("感谢您的登录，用户" + this.getName());
		}
}