MySQL 和Java



MySQL的安装



Java的jar配置





```
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	private static String dbURL = "jdbc:mysql://localhost:3306/mySQL?useSSL=false&serverTimezone=UTC";
	private static String dbUser = "root";
	private static String dbPasswd = "123";
	
	public static Connection getConnection() {
		try {
			//加载mysql驱动类
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(dbURL,dbUser,dbPasswd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

```

