// Vulnerable Java Code Sample
import java.sql.*;
import java.io.*;

public class VulnerableApp {
    
    // Hardcoded credentials - SECURITY ISSUE
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "SecretPass123";
    
    // SQL Injection vulnerability - SECURITY ISSUE
    public void getUserData(String userId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM users WHERE id = '" + userId + "'";
        ResultSet rs = stmt.executeQuery(query);
        
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
        conn.close();
    }
    
    // Command Injection vulnerability - SECURITY ISSUE
    public void pingHost(String host) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ping -c 4 " + host);
        
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(process.getInputStream())
        );
        
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
    
    // Path Traversal vulnerability - SECURITY ISSUE
    public String readFile(String filename) throws IOException {
        File file = new File("/var/www/files/" + filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        reader.close();
        
        return content.toString();
    }
    
    // Weak cryptography - SECURITY ISSUE
    public String hashPassword(String password) {
        try {
            java.security.MessageDigest md = 
                java.security.MessageDigest.getInstance("MD5");
            byte[] hash = md.digest(password.getBytes());
            return new String(hash);
        } catch (Exception e) {
            return null;
        }
    }
}
