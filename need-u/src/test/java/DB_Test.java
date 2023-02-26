import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

/**
 * DB 연결 테스트
 * 
 * @author USER
 *
 */
public class DB_Test {

	@Test
	public void test() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver"); // 마리아DB

		Connection connection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3366/needu-local", "root",
				"46824682"); // 마리아DB 연결설정
		System.out.println(connection);
	}
}