<?php  
echo "TEST Oracle!<br>";
// crear conexion con oracle
echo($_ENV["DB_USER"]);
echo($_ENV["DB_PASS"]);
echo($_ENV["DB_HOST"]);
echo "<br>";
//$db = "(DESCRIPTION=(ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.30.30)(PORT = 1521)))(CONNECT_DATA=(SERVICE_NAME=sisgen1_req)))";
$db = "(DESCRIPTION=(ADDRESS_LIST = (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.1.10)(PORT = 1521)))(CONNECT_DATA=(SID=ORCLCDB)))";
$conexion = oci_connect("sys", "Oradoc_db1", $db); 
//$conexion = oci_connect("DLT_BAS", "abc123", $db); 
echo "TEST Oracle!44";
if (!$conexion) {    
  $m = oci_error();    
  echo $m['message'], "n";    
  exit; 
} else {    
  echo "ConexiÛn con Èxito a Oracle!"; } 
 
?> 