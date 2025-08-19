import java.util.ArrayList;
public class Bank{
	private ArrayList<User> userList = new ArrayList<User>();
	public ArrayList<User> check(){
		return userList;
	}
	public void setUser(User u){
		userList.add(u);
	}
	public void regUser(String name, int password, double balance, int type_level){
		User u;
		switch(type_level){
			case 1:
				u = new RUser(name, password, balance);
				setUser(u);
				System.out.println("您已注册成功，用户id为" + u.getId() + "，请留意ID以便于下次登录");
				break;
			case 2:
				u = new SUser(name, password, balance);
				setUser(u);
				System.out.println("您已注册成功，用户id为" + u.getId() + "，请留意ID以便于下次登录");
				break;
			case 3:
				u = new SSRUser(name, password, balance);
				setUser(u);
				System.out.println("您已注册成功，用户id为" + u.getId() + "，请留意ID以便于下次登录");
				break;
			default:
				System.out.println("用户等级超出范围（1-3），注册失败");
			}
	}
	public User loginUser(int input_id, int input_password){
		for(int i = 0; i < userList.size(); i++){
			if(userList.get(i).getId() == input_id && userList.get(i).password == input_password){
				return userList.get(i);
			}
		}
		User error_user = new RUser("error", 0, 0.0);
		System.out.println("该用户不存在或密码错误，登录失败");
		return error_user;	
	}
}