<?php
// Vulnerable PHP Code Sample

// Hardcoded credentials - SECURITY ISSUE
$db_host = "localhost";
$db_user = "admin";
$db_pass = "AdminPass123";
$db_name = "testdb";

// SQL Injection vulnerability - SECURITY ISSUE
function getUserData($userId) {
    global $db_host, $db_user, $db_pass, $db_name;
    
    $conn = mysqli_connect($db_host, $db_user, $db_pass, $db_name);
    $query = "SELECT * FROM users WHERE id = '$userId'";
    $result = mysqli_query($conn, $query);
    
    return mysqli_fetch_all($result);
}

// XSS vulnerability - SECURITY ISSUE
function displayUserInput($input) {
    echo "<h1>Welcome, " . $input . "</h1>";
}

// Command Injection vulnerability - SECURITY ISSUE
function pingHost($host) {
    $output = shell_exec("ping -c 4 " . $host);
    return $output;
}

// Path Traversal vulnerability - SECURITY ISSUE
function readFile($filename) {
    $filepath = "/var/www/uploads/" . $filename;
    return file_get_contents($filepath);
}

// Weak cryptography - SECURITY ISSUE
function hashPassword($password) {
    return md5($password);
}

// Using eval - SECURITY ISSUE
function calculate($expression) {
    return eval("return " . $expression . ";");
}

// Example usage
if (isset($_GET['action'])) {
    $action = $_GET['action'];
    
    if ($action == 'getUser') {
        $userId = $_GET['id'];
        $userData = getUserData($userId);
        print_r($userData);
    }
}
?>
