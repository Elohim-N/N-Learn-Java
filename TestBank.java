import java.util.Scanner;
public class TestBank{
	public static void main(String[] args) {
		TestBank tb = new TestBank();
		Bank bk = new Bank();
		Scanner s = new Scanner(System.in);
		tb.mainPage(s, bk);
	}
	public void mainPage(Scanner s, Bank bk){
		while(true){
		System.out.println("请输入数字选择对应功能：");
		System.out.println("1、注册  2、登录  3、退出");
		int ind = s.nextInt();
		if(ind == 1){
			regPage(s, bk);
		}
		else if(ind == 2){
			loginPage(s, bk);
		}
		else if(ind == 3){
			System.exit(0);
		}
		else{
			System.out.println("您的输入无效，请重新输入");
		}
	}
	}
	public void regPage(Scanner s, Bank bk){
		while(true){
			System.out.println("请输入用户名：");
			String input_name = s.next();
			String name;
			if(input_name.equals("error")){
				System.out.println("抱歉，您的用户名不合规，注册失败");
				break;
			}else{
				name = input_name;
			}

			System.out.println("请输入密码：");
			int password = s.nextInt();
			System.out.println("请输入存储金额：");
			double balance = s.nextDouble();
			System.out.println("请输入用户等级：");
			int type_level = s.nextInt();
			bk.regUser(name, password, balance, type_level);
			mainPage(s, bk);
		}
	}
	public void loginPage(Scanner s, Bank bk){
		while(true){
			System.out.println("请输入用户ID：");
			int id = s.nextInt();
			System.out.println("请输入密码：");
			int password = s.nextInt();
			User u = bk.loginUser(id, password);
			if(u.getName().equals("error")){
				mainPage(s, bk);
			}
			else{
				servicePage(s, u, bk);
			}
		}
	}
	public void servicePage(Scanner s, User u, Bank bk){
		while(true){
			System.out.println("1、存款；2、取款；3、账户查询；4、退出登录；5、VIP服务；6、退出系统；");
			int ind = s.nextInt();
			if(ind==1){
				System.out.println("请输入存款金额：");
				double add_money = s.nextDouble();
				u.saveMoney(add_money);
			}
			else if(ind==2){
				System.out.println("请输入取款金额：");
				double minus_money = s.nextDouble();
				u.takeMoney(minus_money);
			}
			else if(ind==3){
				u.service();
			}
			else if(ind==4){
				mainPage(s, bk);
			}
			else if(ind==5){
				if(u.getType().equals("R")){
					System.out.println("普通用户暂无VIP服务权限，期待您的解锁");
				}
				else if(u.getType().equals("S")){
					System.out.println("恭喜您解锁免费理财咨询服务");
				}
				else if(u.getType().equals("SSR")){
					System.out.println("恭喜您解锁专属私人理财助理服务");
				}
			}
			else if(ind==6){
				System.exit(0);
			}
			else{
				System.out.println("您的输入无效，请重新选择（1-6）");
			}
		}
	}
}