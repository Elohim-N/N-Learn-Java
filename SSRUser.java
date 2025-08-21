public class SSRUser extends User{
	private String type = "SSR";
	public SSRUser(String name, int password, double balance){
		super(name, password, balance);
	}
	public String getType(){
		return "SSR";
	}
	public void service(){
		super.service();
		System.out.println("感谢您的登录，尊敬的SVIP用户" + this.getName());
		}
}